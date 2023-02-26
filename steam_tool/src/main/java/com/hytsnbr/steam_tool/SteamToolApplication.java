package com.hytsnbr.steam_tool;

import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import com.hytsnbr.steam_tool.executor.InterfaceCreator;
import com.hytsnbr.steam_tool.executor.RequestCreator;

@ConfigurationPropertiesScan(value = "com.hytsnbr.base_common.config.property")
@SpringBootApplication
public class SteamToolApplication {
    
    public static void main(String[] args) {
        // Apache Velocity 設定
        Properties prop = new Properties();
        prop.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
        prop.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        Velocity.init(prop);
        
        // 生成処理
        RequestCreator.execute();
        InterfaceCreator.execute();
    }
}