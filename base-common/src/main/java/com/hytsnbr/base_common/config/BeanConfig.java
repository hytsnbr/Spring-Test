package com.hytsnbr.base_common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * DIさせるクラスを定義
 */
@Configuration
public class BeanConfig {
    
    // Bean Validation の Validator を生成するコンポーネントの Bean定義    
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        // バリデーションメッセージをカスタムする
        // bean.setValidationMessageSource();
        
        return bean;
    }
    
    // Method Validation(AOP) を適用するコンポーネントの Bean定義
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(
        LocalValidatorFactoryBean localValidatorFactoryBean
    ) {
        MethodValidationPostProcessor bean = new MethodValidationPostProcessor();
        bean.setValidator(localValidatorFactoryBean);
        
        return bean;
    }
}
