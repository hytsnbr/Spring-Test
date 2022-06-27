package com.hytsnbr.demo.exception.api;

public class ApiCallFailedException extends ApiException {

    public ApiCallFailedException(String msg) {
        super(msg);
    }
}