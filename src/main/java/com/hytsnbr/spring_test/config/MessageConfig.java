package com.hytsnbr.spring_test.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * メッセージファイル設定
 */
@Configuration
public class MessageConfig implements WebMvcConfigurer {
    
    /**
     * バリデーションメッセージを Hibernate Validator のデフォルトから
     * Spring の MessageSource (message.properties) に変更する
     *
     * @return localValidatorFactoryBean
     */
    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        
        return localValidatorFactoryBean;
    }
}
