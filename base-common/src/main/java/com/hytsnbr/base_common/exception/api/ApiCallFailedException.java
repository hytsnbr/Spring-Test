package com.hytsnbr.base_common.exception.api;

import org.springframework.web.client.HttpStatusCodeException;

public class ApiCallFailedException extends ApiException {
    
    private static final String MESSAGE = "API呼び出しでエラーが発生しました";
    
    public ApiCallFailedException() {
        super(MESSAGE);
    }
    
    public ApiCallFailedException(String msg) {
        super(msg);
    }
    
    public ApiCallFailedException(HttpStatusCodeException e) {
        super(e.getMessage());
    }
}