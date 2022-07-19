package com.hytsnbr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController extends BaseController {

    @GetMapping("/error")
    public String error(Model model) {

        return "error/500";
    }
}
