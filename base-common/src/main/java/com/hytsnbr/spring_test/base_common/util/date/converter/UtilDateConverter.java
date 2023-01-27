package com.hytsnbr.spring_test.base_common.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public final class UtilDateConverter extends AbstractDateConverter<Date> {
    
    public UtilDateConverter() {
    }
    
    public UtilDateConverter(String zoneId) {
        super(zoneId);
    }
    
    @Override
    public Date fromString(String target, String pattern)
        throws ParseException, NullPointerException, IllegalArgumentException {
        
        // Null Check
        Objects.requireNonNull(target);
        Objects.requireNonNull(pattern);
        
        // Converting
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(target);
    }
    
    @Override
    public Date fromEpochTime(long epochTime) {
        return new Date(epochTime);
    }
    
    @Override
    public Date toUtilDate(Date target) {
        return target;
    }
    
    @Override
    public java.sql.Date toSqlDate(Date target) {
        
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(target);
        
        // java.sql.Date は java.util.Date と違い「年月日」までしか持たないため
        // 「時分秒ミリ秒」は初期化する必要がある
        // 参考: https://higayasuo.hatenablog.com/entry/20090219/1235020303
        // https://salumarine.com/how-to-convert-java-util-date-to-java-sql-date/
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        return new java.sql.Date(calendar.getTimeInMillis());
    }
    
    @Override
    public Timestamp toTimeStamp(Date target) {
        return Timestamp.from(target.toInstant());
    }
    
    @Override
    public LocalDate toLocalDate(Date target) {
        
        // Java8 まで
        // LocalDate localDate = target.toInstant().atZone(timeZone.toZoneId()).toLocalDate();
        
        // Java9 から
        return LocalDate.ofInstant(target.toInstant(), timeZone.toZoneId());
    }
    
    @Override
    public LocalDateTime toLocalDateTime(Date target) {
        
        // Java8 まで
        // LocalDateTime localDateTime = target.toInstant().atZone(timeZone.toZoneId()).toLocalDateTime();
        
        // Java9 から
        return LocalDateTime.ofInstant(target.toInstant(), timeZone.toZoneId());
    }
    
    @Override
    public long toUnixTime(Date target) {
        return target.getTime();
    }
}
