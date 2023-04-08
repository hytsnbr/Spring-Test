package com.hytsnbr.base_common.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * APIキー設定
 *
 * @author hytsnbr10519
 */
@Data
@Configuration
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "api.key")
public class ApiKey {
    
    private String steam;
}
