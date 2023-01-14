package com.hytsnbr.spring_test.exception;

import com.hytsnbr.spring_test.exception.common.SystemException;

/**
 * コレクションのサイズが仕様よりも大きいときの例外
 */
public class CollectionOversizeException extends SystemException {
    
    public CollectionOversizeException() {
        super("Collection Size is too large.");
    }
    
    public CollectionOversizeException(int expectedSize) {
        super("Collection Size is too large. Expected: ");
    }
    
    public CollectionOversizeException(String msg) {
        super(msg);
    }
}
