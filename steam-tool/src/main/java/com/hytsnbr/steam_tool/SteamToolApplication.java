package com.hytsnbr.steam_tool;

import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import com.hytsnbr.base_common.exception.common.SystemException;
import com.hytsnbr.steam_tool.executor.InterfaceCreator;
import com.hytsnbr.steam_tool.executor.RequestCreator;
import com.hytsnbr.steam_tool.executor.UrlListCreator;

@ConfigurationPropertiesScan(value = "com.hytsnbr.base_common.config.property")
@SpringBootApplication
public class SteamToolApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SteamToolApplication.class);
    
    public static void main(String[] args) {
        // Apache Velocity 設定
        Properties prop = new Properties();
        prop.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
        prop.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        Velocity.init(prop);
        
        try {
            // 生成処理
            RequestCreator requestCreator = new RequestCreator();
            requestCreator.execute();
            
            InterfaceCreator interfaceCreator = new InterfaceCreator();
            interfaceCreator.execute();
            
            UrlListCreator urlListCreator = new UrlListCreator();
            urlListCreator.execute();
            
            LOGGER.info("生成に成功しました");
        } catch (SystemException e) {
            LOGGER.error("生成に失敗しました", e);
        }
    }
}