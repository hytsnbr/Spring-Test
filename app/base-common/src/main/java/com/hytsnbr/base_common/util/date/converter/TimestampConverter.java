package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import com.hytsnbr.base_common.constant.DateFormat;

public final class TimestampConverter extends AbstractDateConverter<Timestamp> {
    
    public TimestampConverter() {
    }
    
    public TimestampConverter(String zoneId) {
        super(zoneId);
    }
    
    @Override
    public Timestamp fromString(String target, DateFormat pattern)
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
        Date date = format.parse(target);
        
        return new Timestamp(date.getTime());
    }
    
    @Override
    public Timestamp fromEpochTime(long epochTime) {
        return Timestamp.from(Instant.ofEpochMilli(epochTime));
    }
    
    @Override
    public Date toUtilDate(Timestamp target) {
        return new Date(target.getTime());
    }
    
    @Override
    public java.sql.Date toSqlDate(Timestamp target) {
        return new java.sql.Date(target.getTime());
    }
    
    @Override
    public Timestamp toTimestamp(Timestamp target) {
        return target;
    }
    
    @Override
    public LocalDate toLocalDate(Timestamp target) {
        return target.toLocalDateTime().toLocalDate();
    }
    
    @Override
    public LocalDateTime toLocalDateTime(Timestamp target) {
        return target.toLocalDateTime();
    }
    
    @Override
    public long toUnixTime(Timestamp target) {
        return target.getTime();
    }
}
