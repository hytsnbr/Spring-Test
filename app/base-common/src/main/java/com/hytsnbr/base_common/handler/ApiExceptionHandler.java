package com.hytsnbr.base_common.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

import com.hytsnbr.base_common.exception.api.ApiException;

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
