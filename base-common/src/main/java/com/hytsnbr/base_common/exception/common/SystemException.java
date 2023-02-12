package com.hytsnbr.base_common.exception.common;

// システムエラー
// 仕様外のエラーとか
public class SystemException extends com.hytsnbr.base_common.exception.common.BaseException {
    
    public SystemException() {
        super();
    }
    
    public SystemException(String msg) {
        super(msg);
    }
}