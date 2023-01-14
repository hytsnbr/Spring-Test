package com.hytsnbr.spring_test.handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hytsnbr.spring_test.exception.api.ApiException;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {
    
    /**
     * {@link ExceptionHandler}
     */
    @ExceptionHandler(ApiException.class)
    public String apiExceptionHandler(Exception exception) {
        log.error("Something Error Happened...", exception);
        
        return "/error";
    }
}
