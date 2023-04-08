package com.hytsnbr.base_common.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 共通インターセプター
 */
@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        
        // log.info("Interceptor: PreHandle");
        
        return true;
    }
    
    @Override
    public void postHandle(
        HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView
    ) {
        
        // log.info("Interceptor: PostHandle");
    }
    
    @Override
    public void afterCompletion(
        HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex
    ) {
        
        // log.info("Interceptor: AfterCompletion");
    }
}
