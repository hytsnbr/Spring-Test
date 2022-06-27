package com.hytsnbr.demo.exception.api;

import org.springframework.web.client.RestClientException;

public class ApiException extends RestClientException {

    private static final String MSG_FORMAT = "[API Exception] %s";

    public ApiException(String msg) {
        super(String.format(MSG_FORMAT, msg));
    }
}