package com.hytsnbr.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author hytsnbr10519
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "api.key")
public class ApiKey {

    private String steam;
}
