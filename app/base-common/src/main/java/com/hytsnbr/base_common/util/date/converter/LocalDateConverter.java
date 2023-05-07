package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.hytsnbr.base_common.constant.DateFormat;

public final class LocalDateConverter extends AbstractDateConverter<LocalDate> {
    
    public LocalDateConverter() {
    }
    
    public LocalDateConverter(String zoneId) {
        super(zoneId);
    }
    
    @Override
    public LocalDate fromString(String target, DateFormat pattern)
        throws NullPointerException, IllegalArgumentException {
        return LocalDate.parse(target, DateTimeFormatter.ofPattern(pattern.getFormat()));
    }
    
    @Override
    public LocalDate fromEpochTime(long epochTime) {
        return LocalDate.ofEpochDay(epochTime);
    }
    
    @Override
    public Date toUtilDate(LocalDate target) {
        return Date.from(ZonedDateTime.of(target.atStartOfDay(), timeZone.toZoneId()).toInstant());
    }
    
    @Override
    public java.sql.Date toSqlDate(LocalDate target) {
        return java.sql.Date.valueOf(target);
    }
    
    @Override
    public Timestamp toTimestamp(LocalDate target) {
        return Timestamp.valueOf(toLocalDateTime(target));
    }
    
    @Override
    public LocalDate toLocalDate(LocalDate target) {
        return target;
    }
    
    @Override
    public LocalDateTime toLocalDateTime(LocalDate target) {
        return target.atStartOfDay();
    }
    
    @Override
    public long toUnixTime(LocalDate target) {
        return target.atStartOfDay(timeZone.toZoneId()).toEpochSecond();
    }
}
