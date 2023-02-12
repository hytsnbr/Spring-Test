package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * 日時オブジェクトの変換クラス 基底クラス
 */
public abstract class AbstractDateConverter<T> {
    
    protected final TimeZone timeZone;
    
    protected AbstractDateConverter() {
        this.timeZone = TimeZone.getTimeZone("UTC");
    }
    
    protected AbstractDateConverter(String zoneId) {
        this.timeZone = TimeZone.getTimeZone(zoneId);
    }
    
    /**
     * 文字列から生成
     */
    public abstract T fromString(String target, String pattern)
        throws ParseException, NullPointerException, IllegalArgumentException;
    
    /**
     * エポック秒から生成
     */
    public abstract T fromEpochTime(long epochTime);
    
    /**
     * java.util.Date へ変換
     */
    public abstract java.util.Date toUtilDate(T target);
    
    /**
     * java.sql.Date へ変換
     */
    public abstract java.sql.Date toSqlDate(T target);
    
    /**
     * java.sql.TimeStamp へ変換
     */
    public abstract Timestamp toTimeStamp(T target);
    
    /**
     * java.time.LocalDate へ変換
     */
    public abstract LocalDate toLocalDate(T target);
    
    /**
     * java.time.LocalDateTime へ変換
     */
    public abstract LocalDateTime toLocalDateTime(T target);
    
    /**
     * UNIX時間へ変換
     */
    public abstract long toUnixTime(T target);
}
