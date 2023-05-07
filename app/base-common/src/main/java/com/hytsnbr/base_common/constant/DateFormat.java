package com.hytsnbr.base_common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日付フォーマット 定数
 */
@Getter
@AllArgsConstructor
public enum DateFormat {
    
    HYPHEN_YYYYMMDD("yyyy-MM-dd"),
    HYPHEN_YYYYMMDDHHMM("yyyy-MM-dd HH:mm"),
    HYPHEN_YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),
    
    SLASH_YYYYMMDD("yyyy/MM/dd"),
    SLASH_YYYYMMDDHHMM("yyyy/MM/dd HH:mm"),
    SLASH_YYYYMMDDHHMMSS("yyyy/MM/dd HH:mm:ss"),
    ;
    
    private final String format;
}
