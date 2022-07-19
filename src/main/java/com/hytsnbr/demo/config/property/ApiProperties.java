package com.hytsnbr.demo.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author hytsnbr10519
 */
@Data
@Configuration
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
