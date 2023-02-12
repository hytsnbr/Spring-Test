package com.hytsnbr.base_common.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

public class BaseController {
    
    private static final String REDIRECT = "redirect: ";
    
    protected String redirect(String url) {
        return REDIRECT + url;
    }
    
    protected String redirect(String url, Map<String, String> queryParams) {
        URI uri = UriComponentsBuilder.fromUriString(url).build(queryParams);
        // TODO: ここでリダイレクト用のURLを組み立てる
        
        return redirect(uri.toString());
    }
}