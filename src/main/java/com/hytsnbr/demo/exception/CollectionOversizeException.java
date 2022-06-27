package com.hytsnbr.demo.exception;

import com.hytsnbr.demo.exception.common.SystemException;

/**
 * コレクションのサイズが仕様よりも大きいときの例外
 */
public class CollectionOversizeException extends SystemException {

    public CollectionOversizeException() {
        super("Collection Size is too large");
    }

    public CollectionOversizeException(String msg) {
        super(msg);
    }
}
