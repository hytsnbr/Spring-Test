package com.hytsnbr.spring_test.base_common.exception.database;

import org.apache.commons.lang3.StringUtils;

import com.hytsnbr.spring_test.base_common.exception.common.BusinessException;

public class NotFoundRecordsException extends BusinessException {
    
    private static final String MSG = "DB検索レコードなし";
    
    public NotFoundRecordsException() {
        super();
    }
    
    public NotFoundRecordsException(String msg) {
        super(StringUtils.isNotBlank(msg) ? msg : MSG);
    }
}