package com.hytsnbr.demo.exception.common;

public class BaseException extends Exception {

    private static final String MSG = "Something Happened......";

    public BaseException() {
        super(MSG);
    }

    public BaseException(String msg) {
        super(msg);
    }
}