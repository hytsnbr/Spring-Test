package com.hytsnbr.base_common.exception.api;

import org.apache.commons.lang3.StringUtils;

/**
 * レスポンスが空
 */
public class ApiNoResponseException extends com.hytsnbr.base_common.exception.api.ApiException {
    
    private static final String MESSAGE = "レスポンスが空です";
    
    public ApiNoResponseException() {
        super(MESSAGE);
    }
    
    public ApiNoResponseException(String msg) {
        super(StringUtils.isBlank(msg) ? MESSAGE : msg);
    }
}