package com.hytsnbr.spring_test.base_common.exception.database;

import org.apache.commons.lang3.StringUtils;

import com.hytsnbr.spring_test.base_common.exception.common.SystemException;

public class SearchCountLimitOverException extends SystemException {
    
    private static final String MSG = "DB検索結果上限オーバー";
    
    public SearchCountLimitOverException() {
        super();
    }
    
    public SearchCountLimitOverException(String msg) {
        super(StringUtils.isNotBlank(msg) ? msg : MSG);
    }
}
