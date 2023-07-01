package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.hytsnbr.base_common.constant.DateFormat;

public final class LocalDateTimeConverter extends AbstractDateConverter<LocalDateTime> {
    
    public LocalDateTimeConverter() {
    }
    
    public LocalDateTimeConverter(String zoneId) {
        super(zoneId);
    }
    
    @Override
    public LocalDateTime fromString(String target, DateFormat pattern)
        throws NullPointerException, IllegalArgumentException {
        return LocalDateTime.parse(target, DateTimeFormatter.ofPattern(pattern.getFormat()));
    }
    
    @Override
    public LocalDateTime fromEpochTime(long epochTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochTime), ZoneId.systemDefault());
    }
    
    @Override
    public Date toUtilDate(LocalDateTime target) {
        return Date.from(ZonedDateTime.of(target, ZoneId.systemDefault()).toInstant());
    }
    
    @Override
    public java.sql.Date toSqlDate(LocalDateTime target) {
        return java.sql.Date.valueOf(target.toLocalDate());
    }
    
    @Override
    public Timestamp toTimestamp(LocalDateTime target) {
        return Timestamp.valueOf(target);
    }
    
    @Override
    public LocalDate toLocalDate(LocalDateTime target) {
        return target.toLocalDate();
    }
    
    @Override
    public LocalDateTime toLocalDateTime(LocalDateTime target) {
        return target;
    }
    
    @Override
    public long toUnixTime(LocalDateTime target) {
        return target.atZone(timeZone.toZoneId()).toEpochSecond();
    }
}
