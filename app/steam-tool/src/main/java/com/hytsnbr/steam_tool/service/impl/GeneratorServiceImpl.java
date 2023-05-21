package com.hytsnbr.steam_tool.service.impl;

import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hytsnbr.base_common.exception.common.SystemException;
import com.hytsnbr.steam_tool.executor.InterfaceCreator;
import com.hytsnbr.steam_tool.executor.RequestCreator;
import com.hytsnbr.steam_tool.executor.UrlListCreator;
import com.hytsnbr.steam_tool.service.GeneratorService;

@Service
public class GeneratorServiceImpl implements GeneratorService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorServiceImpl.class);
    
    private final InterfaceCreator interfaceCreator;
    
    private final RequestCreator requestCreator;
    
    private final UrlListCreator urlListCreator;
    
    public GeneratorServiceImpl(
        InterfaceCreator interfaceCreator,
        RequestCreator requestCreator,
        UrlListCreator urlListCreator
    ) {
        this.interfaceCreator = interfaceCreator;
        this.requestCreator = requestCreator;
        this.urlListCreator = urlListCreator;
    }
    
    @Override
    public void generate() {
        // Apache Velocity 設定
        Properties prop = new Properties();
        prop.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
        prop.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        Velocity.init(prop);
        
        try {
            // 生成処理
            requestCreator.execute();
            interfaceCreator.execute();
            urlListCreator.execute();
            
            LOGGER.info("生成に成功しました");
        } catch (SystemException e) {
            LOGGER.error("生成に失敗しました", e);
        }
    }
}
