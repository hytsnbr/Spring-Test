package com.hytsnbr.steam_tool.executor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import com.hytsnbr.base_common.exception.common.SystemException;
import com.hytsnbr.steam_tool.constant.GenerateFileType;
import com.hytsnbr.steam_tool.dao.SteamDao;
import com.hytsnbr.steam_tool.dto.GetSupportedApiListResponse.ApiList.Interface;

public class InterfaceCreator extends AbstractCreator {
    
    private static final String FILE_NAME = "%s.java";
    
    @Override
    public void execute() throws SystemException {
        try {
            super.cleanResultDirectory(GenerateFileType.INTERFACE);
        } catch (IOException e) {
            throw new SystemException("ファイル生成先のクリーンアップに失敗しました");
        }
        
        final List<Interface> apiInterfaceList = SteamDao.getSupportedApiList().getApiInterfaceList();
        
        for (Interface apiInterface : apiInterfaceList) {
            final String interfaceName = apiInterface.getName().replace("_", "");
            
            Context context = new VelocityContext();
            context.put("interfaceName", interfaceName);
            
            List<Map<String, String>> params = new ArrayList<>();
            apiInterface.getMethods().forEach(method -> {
                Map<String, String> param = new HashMap<>();
                param.put("apiName", method.getName());
                param.put("responseName", method.getName() + "Request");
                param.put("requestName", method.getName() + "Response");
                
                params.add(param);
            });
            context.put("params", params);
            
            super.generateFiles(GenerateFileType.INTERFACE, String.format(FILE_NAME, interfaceName), context);
        }
    }
}
