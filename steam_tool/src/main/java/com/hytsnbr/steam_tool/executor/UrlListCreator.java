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

public class UrlListCreator extends AbstractCreator {
    
    private static final String FILE_NAME = "%s.java";
    
    private static final String URL_FORMAT = "https://api.steampowered.com/%s/%s/v%d";
    
    @Override
    public void execute() {
        try {
            super.cleanResultDirectory(GenerateFileType.URL);
        } catch (IOException e) {
            throw new SystemException("ファイル生成先のクリーンアップに失敗しました");
        }
        
        final List<Interface> apiInterfaceList = SteamDao.getSupportedApiList().getApiInterfaceList();
        
        Context context = new VelocityContext();
        context.put("className", "SteamApiEndpoints");
        
        List<Map<String, String>> params = new ArrayList<>();
        for (Interface apiInterface : apiInterfaceList) {
            apiInterface.getMethods().forEach(method -> {
                Map<String, String> param = new HashMap<>();
                param.put("fieldName", method.getName());
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
