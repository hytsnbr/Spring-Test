package com.hytsnbr.base_common.exception.common;

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