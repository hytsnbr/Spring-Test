package com.hytsnbr.steam_tool.executor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import com.google.common.base.CaseFormat;
import com.hytsnbr.steam_tool.constant.DataType;
import com.hytsnbr.steam_tool.dao.SteamDao;
import com.hytsnbr.steam_tool.dto.GetSupportedApiListResponse.ApiList.Interface;

public final class RequestCreator {
    
    private static final String DIR_PATH = "steam_tool/result/request";
    
    private static final String TEMPLATE_PATH = "templates/request.vm";
    
    private static final String FILE_NAME = "%sRequest.java";
    
    private RequestCreator() {}
    
    public static void execute() {
        Path dir = Paths.get(DIR_PATH);
        if (Files.exists(dir)) {
            try (Stream<Path> stream = Files.walk(dir)) {
                if (Files.exists(dir)) {
                    stream.map(Path::toFile).forEach(File::delete);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.createDirectories(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        final List<Interface> apiInterfaceList = SteamDao.getSupportedApiList().getApiInterfaceList();
        
        for (Interface apiInterface : apiInterfaceList) {
            apiInterface.getMethods().forEach(method -> {
                Context context = new VelocityContext();
                context.put("className", method.getName());
                
                List<Map<String, String>> params = new ArrayList<>();
                method.getParameters().forEach(parameter -> {
                    Map<String, String> param = new HashMap<>();
                    param.put("required", String.valueOf(parameter.isOptional()));
                    param.put("type", DataType.toEnum(parameter.getType()).getClassName());
                    param.put("name", CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, parameter.getName()));
                    
                    params.add(param);
                });
                context.put("params", params);
                
                Template template = Velocity.getTemplate(TEMPLATE_PATH, StandardCharsets.UTF_8.name());
                
                Path path = Paths.get(DIR_PATH, String.format(FILE_NAME, method.getName()));
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                    if (Files.notExists(path)) {
                        Files.createFile(path);
                    }
                    template.merge(context, bufferedWriter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
