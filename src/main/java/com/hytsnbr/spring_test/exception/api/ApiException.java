package com.hytsnbr.spring_test.exception.api;

import org.springframework.web.client.RestClientException;

/**
 * API関連例外の基底クラス
 */
public class ApiException extends RestClientException {
    
    private static final String MSG_FORMAT = "[API Exception] %s";
    
    public ApiException(String msg) {
        super(String.format(MSG_FORMAT, msg));
    }
}