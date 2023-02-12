package com.hytsnbr.base_common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController extends com.hytsnbr.base_common.controller.BaseController {
    
    @GetMapping
    
    public void index() {
    }
}
