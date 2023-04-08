package com.hytsnbr.base_common.exception.common;

public class BaseException extends RuntimeException {
    
    private static final String MSG = "Something Happened......";
    
    public BaseException() {
        super(MSG);
    }
    
    public BaseException(String msg) {
        super(msg);
    }
}