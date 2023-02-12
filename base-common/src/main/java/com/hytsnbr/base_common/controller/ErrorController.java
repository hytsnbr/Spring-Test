package com.hytsnbr.base_common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController extends com.hytsnbr.base_common.controller.BaseController {
    
    @GetMapping("/error")
    public void error() {
    }
}
