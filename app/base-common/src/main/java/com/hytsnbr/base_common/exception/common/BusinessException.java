package com.hytsnbr.base_common.exception.common;

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