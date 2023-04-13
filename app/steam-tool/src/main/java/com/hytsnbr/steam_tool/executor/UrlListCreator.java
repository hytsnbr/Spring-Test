package com.hytsnbr.steam_tool.executor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.springframework.stereotype.Component;

import com.google.common.base.CaseFormat;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.base_common.exception.common.SystemException;
import com.hytsnbr.steam_tool.constant.GenerateFileType;
import com.hytsnbr.steam_tool.dao.SteamDao;
import com.hytsnbr.steam_tool.dto.GetSupportedApiListResponse.ApiList.Interface;

@Component
public final class UrlListCreator extends AbstractCreator {
    
    private static final String FILE_NAME = "%s.java";
    
    private static final String URL_FORMAT = "https://api.steampowered.com/%s/%s/v%d";
    
    private final ApiKey apiKey;
    
    /**
     * コンストラクタ
     */
    public UrlListCreator(ApiKey apiKey) {
        this.apiKey = apiKey;
    }
    
    @Override
    public void execute() {
        try {
            super.cleanResultDirectory(GenerateFileType.URL);
        } catch (IOException e) {
            throw new SystemException("ファイル生成先のクリーンアップに失敗しました");
        }
        
        final List<Interface> apiInterfaceList = SteamDao.getSupportedApiList(apiKey.getSteam()).getApiInterfaceList();
        
        Context context = new VelocityContext();
        context.put("className", "SteamApiEndpoints");
        
        List<Map<String, String>> params = new ArrayList<>();
        for (Interface apiInterface : apiInterfaceList) {
            apiInterface.getMethods().forEach(method -> {
                Map<String, String> param = new HashMap<>();
                param.put("fieldName", CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, method.getName()));
                param.put("value",
                    String.format(URL_FORMAT, apiInterface.getName(), method.getName(), method.getVersion())
                );
                
                params.add(param);
            });
        }
        context.put("params", params);
        
        super.generateFiles(GenerateFileType.URL, String.format(FILE_NAME, "SteamApiEndpoints"), context);
    }
}
