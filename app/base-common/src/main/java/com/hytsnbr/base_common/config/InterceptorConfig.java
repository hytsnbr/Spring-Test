package com.hytsnbr.base_common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hytsnbr.base_common.common.Interceptor;

/**
 * AOP用インターセプター設定
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor());
    }
    
    @Bean
    public HandlerInterceptor getInterceptor() {
        return new Interceptor();
    }
}
