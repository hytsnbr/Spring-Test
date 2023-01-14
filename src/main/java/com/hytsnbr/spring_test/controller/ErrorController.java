package com.hytsnbr.spring_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController extends BaseController {
    
    @GetMapping("/error")
    public void error() {
    }
}
