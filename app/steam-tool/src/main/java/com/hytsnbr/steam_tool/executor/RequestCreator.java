package com.hytsnbr.steam_tool.executor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.springframework.stereotype.Component;

import com.google.common.base.CaseFormat;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.base_common.exception.common.SystemException;
import com.hytsnbr.steam_tool.constant.DataType;
import com.hytsnbr.steam_tool.constant.GenerateFileType;
import com.hytsnbr.steam_tool.dao.SteamDao;
import com.hytsnbr.steam_tool.dto.GetSupportedApiListResponse.ApiList.Interface;

@Component
public final class RequestCreator extends AbstractCreator {
    
    private static final String FILE_NAME = "%sRequest.java";
    
    private final ApiKey apiKey;
    
    /**
     * コンストラクタ
     */
    public RequestCreator(ApiKey apiKey) {
        this.apiKey = apiKey;
    }
    
    @Override
    public void execute() throws SystemException {
        try {
            super.cleanResultDirectory(GenerateFileType.REQUEST);
        } catch (IOException e) {
            throw new SystemException("ファイル生成先のクリーンアップに失敗しました");
        }
        
        final List<Interface> apiInterfaceList = SteamDao.getSupportedApiList(apiKey.getSteam()).getApiInterfaceList();
        
        for (Interface apiInterface : apiInterfaceList) {
            apiInterface.getMethods().forEach(method -> {
                Context context = new VelocityContext();
                context.put("className", method.getName());
                
                List<Map<String, String>> params = new ArrayList<>();
                method.getParameters().forEach(parameter -> {
                    Map<String, String> param = new HashMap<>();
                    param.put("required", String.valueOf(parameter.isOptional()));
                    param.put("type", DataType.toEnum(parameter.getType()).getClassName());
                    param.put("typeAsList", parameter.getName().match("\[.+\]")));
                    param.put("name", CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, parameter.getName()));
                    param.put("isDataTypeEnum", String.valueOf(StringUtils.equals(parameter.getType(), "{enum}")));
                    param.put("jsonPropertyName", parameter.getName());
                    
                    params.add(param);
                });
                context.put("params", params);
                
                super.generateFiles(GenerateFileType.REQUEST, String.format(FILE_NAME, method.getName()), context);
            });
        }
    }
}
