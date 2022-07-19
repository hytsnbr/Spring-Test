package com.hytsnbr.demo.controller;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

public class BaseController {

    private static final String REDIRECT = "redirect: ";

    protected String redirect(String url, Object... params) {
        URI uri = UriComponentsBuilder.fromUriString(url).build(params);
        // TODO: ここでリダイレクト用のURLを組み立てる

        return REDIRECT + uri; // TODO
    }
}