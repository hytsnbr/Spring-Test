package com.hytsnbr.base_common.util.date.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.hytsnbr.base_common.constant.DateFormat;

public final class SqlDateConverter extends AbstractDateConverter<Date> {
    
    public SqlDateConverter() {
    }
    
    public SqlDateConverter(String zoneId) {
        super(zoneId);
    }
    
    @Override
    public Date fromString(String target, DateFormat pattern)
        throws ParseException, NullPointerException, IllegalArgumentException {
        
        // Null Check
        Objects.requireNonNull(target);
        Objects.requireNonNull(pattern);
        
        // Empty Check
        if (target.equals("")) {
            throw new IllegalArgumentException("");
        }
        
        // Converting
        SimpleDateFormat format = new SimpleDateFormat(pattern.getFormat());
        java.util.Date date = format.parse(target);
        
        return new Date(date.getTime());
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
    public Timestamp toTimestamp(Date target) {
        return new Timestamp(target.getTime());
    }
    
    @Override
    public LocalDate toLocalDate(Date target) {
        return target.toLocalDate();
    }
    
    @Override
    public LocalDateTime toLocalDateTime(Date target) {
        return target.toLocalDate().atStartOfDay();
    }
    
    @Override
    public long toUnixTime(Date target) {
        return target.getTime();
    }
}
