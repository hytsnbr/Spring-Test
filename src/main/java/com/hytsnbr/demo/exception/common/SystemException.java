package com.hytsnbr.demo.exception.common;

// システムエラー
// 仕様外のエラーとか
public class SystemException extends BaseException {

    public SystemException() {
        super();
    }

    public SystemException(String msg) {
        super(msg);
    }
}