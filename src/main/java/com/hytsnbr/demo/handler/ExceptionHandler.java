package com.hytsnbr.demo.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    /**
     * {@link ExceptionHandler}
     */
    @org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class, RuntimeException.class })
    public String exceptionHandler(Exception exception, Model model) {
        log.error("Something Error Happened...", exception);

        model.addAttribute("exception", exception);

        return "redirect:/error";
    }
}
