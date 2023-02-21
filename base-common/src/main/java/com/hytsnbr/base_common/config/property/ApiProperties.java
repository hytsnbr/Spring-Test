package com.hytsnbr.base_common.config.property;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

/**
 * API 関連設定
 *
 * @author hytsnbr10519
 */
@Data
@Configuration
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "api.config")
public class ApiProperties {
    
    private Timeout timeout;
    
    /**
     * API 呼び出しタイムアウト設定
     */
    @Data
    public static class Timeout {
        
        /**
         * 読み取り
         */
        private long read;
        
        /**
         * 接続
         */
        private long connection;
    }
}
