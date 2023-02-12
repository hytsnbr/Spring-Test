package com.hytsnbr.base_common.config.property;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * APIキー設定
 *
 * @author hytsnbr10519
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "api.key")
public class ApiKey {
    
    private String steam;
}
