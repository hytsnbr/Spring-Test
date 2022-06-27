package com.hytsnbr.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * DIさせるクラスを定義
 */
@Configuration
public class BeanConfig {

    //	@Bean
    //	public RestTemplate restTemplate(ApiProperties apiProperties) {
    //		// RestTemplate についての諸設定はここで行う
    //		return new RestTemplateBuilder()
    //			.setConnectTimeout(Duration.ofSeconds(apiProperties.getTimeout().getConnection()))
    //			.setReadTimeout(Duration.ofSeconds(apiProperties.getTimeout().getRead()))
    //			.build();
    //	}
}
