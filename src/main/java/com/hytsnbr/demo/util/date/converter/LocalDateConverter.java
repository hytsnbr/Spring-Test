package com.hytsnbr.demo.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class LocalDateConverter extends DateConverter<LocalDate> {

    @Override
    public LocalDate fromString(String target, String pattern)
            throws ParseException, NullPointerException, IllegalArgumentException {
        return LocalDate.parse(target, DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public LocalDate fromEpochTime(long epochTime) {
        return LocalDate.ofEpochDay(epochTime);
    }

    @Override
    public java.util.Date toUtilDate(LocalDate target) {
        return java.util.Date.from(ZonedDateTime.of(target.atStartOfDay(), ZoneId.systemDefault())
                .toInstant());
    }

    @Override
    public java.sql.Date toSqlDate(LocalDate target) {
        return java.sql.Date.valueOf(target);
    }

    @Override
    public Timestamp toTimeStamp(LocalDate target) {
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
}
