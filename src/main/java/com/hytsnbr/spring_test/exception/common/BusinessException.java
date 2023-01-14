package com.hytsnbr.spring_test.exception.common;

// ビジネスエラー
// 仕様上想定されるエラーとか
public class BusinessException extends BaseException {
    
    public BusinessException() {
        super();
    }
    
    public BusinessException(String msg) {
        super(msg);
    }
}