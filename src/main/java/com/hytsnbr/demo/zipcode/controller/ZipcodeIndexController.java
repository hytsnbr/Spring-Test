package com.hytsnbr.demo.zipcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hytsnbr.demo.zipcode.repository.ZipCodeApi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/zipcode")
public class ZipcodeIndexController {

    private final ZipCodeApi zipCodeApi;

    /**
     * コンストラクタ
     */
    public ZipcodeIndexController(ZipCodeApi zipCodeApi) {
        this.zipCodeApi = zipCodeApi;
    }

    @GetMapping
    public String index(Model model) {

        return "zipcode/index";
    }

    @GetMapping(value = "/", params = "zipcode")
    public String zipcode(@RequestParam(name = "zipcode") String zipcode, Model model) {

        String address = zipCodeApi.getAddress(zipcode);
        model.addAttribute("address", address);

        return "zipcode/index";
    }
}
