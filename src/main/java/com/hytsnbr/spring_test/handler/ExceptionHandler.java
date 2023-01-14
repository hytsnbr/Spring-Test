package com.hytsnbr.spring_test.handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.hytsnbr.spring_test.dto.BaseResponse;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {
    
    /**
     * {@link ExceptionHandler}
     */
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<BaseResponse> exceptionHandler(Exception exception) {
        log.error("Something Error Happened...", exception);
        
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
