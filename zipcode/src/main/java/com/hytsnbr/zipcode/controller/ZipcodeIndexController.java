package com.hytsnbr.zipcode.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.zipcode.dao.ZipCodeApi;

@Slf4j
@RestController
@RequestMapping("/zipcode")
public class ZipcodeIndexController {
    
    private final ZipCodeApi zipCodeApi;
    
    /**
     * コンストラクタ
     */
    public ZipcodeIndexController(ZipCodeApi zipCodeApi) {
        this.zipCodeApi = zipCodeApi;
    }
    
    @GetMapping(params = "zipcode")
    public String zipcode(@RequestParam String zipcode) {
        
        String address = zipCodeApi.getAddress(zipcode);
        
        return "zipcode/index";
    }
}
