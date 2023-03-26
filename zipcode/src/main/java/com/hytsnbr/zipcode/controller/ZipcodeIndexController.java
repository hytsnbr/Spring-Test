package com.hytsnbr.zipcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.hytsnbr.zipcode.dao.ZipcodeApi;

@Slf4j
@RestController
@RequestMapping("/zipcode")
public class ZipcodeIndexController {
    
    private final ZipcodeApi zipcodeApi;
    
    /**
     * コンストラクタ
     */
    public ZipcodeIndexController(ZipcodeApi zipcodeApi) {
        this.zipcodeApi = zipcodeApi;
    }
    
    @GetMapping
    public String zipcode(@RequestParam String zipcode) {
        
        String address = zipcodeApi.getAddress(zipcode);
        
        return "zipcode/index";
    }
}
