package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

import com.hytsnbr.base_common.constant.DateFormat;

/**
 * 日時オブジェクトの変換クラス 基底クラス
 */
public abstract sealed class AbstractDateConverter<T>
    permits LocalDateConverter, LocalDateTimeConverter, SqlDateConverter, TimestampConverter, UtilDateConverter {
    
    /** タイムゾーン */
    protected final TimeZone timeZone;
    
    /**
     * コンストラクタ
     */
    AbstractDateConverter() {
        this.timeZone = TimeZone.getTimeZone("UTC");
    }
    
    /**
     * コンストラクタ（タイムゾーンID指定版）<br>
     * 存在しない・解析できないタイムゾーンIDが指定された場合は <code>GMT</code> にフォールバックされる
     *
     * @param zoneId タイムゾーン
     */
    AbstractDateConverter(String zoneId) {
        this.timeZone = TimeZone.getTimeZone(zoneId);
    }
    
    /**
     * 文字列から生成
     */
    abstract T fromString(String target, DateFormat pattern)
        throws ParseException, NullPointerException, IllegalArgumentException;
    
    /**
     * エポック秒から生成
     */
    abstract T fromEpochTime(long epochTime);
    
    /**
     * java.util.Date へ変換
     */
    abstract Date toUtilDate(T target);
    
    /**
     * java.sql.Date へ変換
     */
    abstract java.sql.Date toSqlDate(T target);
    
    /**
     * java.sql.Timestamp へ変換
     */
    abstract Timestamp toTimestamp(T target);
    
    /**
     * java.time.LocalDate へ変換
     */
    abstract LocalDate toLocalDate(T target);
    
    /**
     * java.time.LocalDateTime へ変換
     */
    abstract LocalDateTime toLocalDateTime(T target);
    
    /**
     * UNIX時間へ変換
     */
    abstract long toUnixTime(T target);
}
