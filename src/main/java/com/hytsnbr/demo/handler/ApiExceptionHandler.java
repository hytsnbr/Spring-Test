package com.hytsnbr.demo.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hytsnbr.demo.exception.api.ApiException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    /**
     * {@link ExceptionHandler}
     */
    @ExceptionHandler(ApiException.class)
    public String apiExceptionHandler(Exception exception, Model model) {
        log.error("Something Error Happened...", exception);

        model.addAttribute("exception", exception);

        return "/error";
    }
}
