package com.hytsnbr.base_common.util.date.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public final class SqlDateConverter
    extends com.hytsnbr.base_common.util.date.converter.AbstractDateConverter<Date> {
    
    public SqlDateConverter() {
    }
    
    public SqlDateConverter(String zoneId) {
        super(zoneId);
    }
    
    @Override
    public Date fromString(String target, String pattern)
        throws ParseException, NullPointerException, IllegalArgumentException {
        
        // Null Check
        Objects.requireNonNull(target);
        Objects.requireNonNull(pattern);
        
        // Empty Check
        if (target.equals("") || pattern.equals("")) {
            throw new IllegalArgumentException("");
        }
        
        // Converting
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        java.util.Date date = format.parse(target);
        
        return (Date) date;
    }
    
    @Override
    public Date fromEpochTime(long epochTime) {
        return new Date(epochTime);
    }
    
    @Override
    public java.util.Date toUtilDate(Date target) {
        // java.sqi.Date は java.util.Date のラッパーなのでそのまま返却可能
        return target;
    }
    
    @Override
    public Date toSqlDate(Date target) {
        return target;
    }
    
    @Override
    public Timestamp toTimeStamp(Date target) {
        return Timestamp.from(target.toInstant());
    }
    
    @Override
    public LocalDate toLocalDate(Date target) {
        return target.toLocalDate();
    }
    
    @Override
    public LocalDateTime toLocalDateTime(Date target) {
        return target.toLocalDate()
                     .atStartOfDay();
    }
    
    @Override
    public long toUnixTime(Date target) {
        return target.getTime();
    }
}
