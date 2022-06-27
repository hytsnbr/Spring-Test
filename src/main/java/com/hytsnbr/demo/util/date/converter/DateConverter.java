package com.hytsnbr.demo.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class DateConverter<T> {

    abstract T fromString(String target, String pattern)
            throws ParseException, NullPointerException, IllegalArgumentException;

    abstract T fromEpochTime(long epochTime);

    abstract java.util.Date toUtilDate(T target);

    abstract java.sql.Date toSqlDate(T target);

    abstract Timestamp toTimeStamp(T target);

    abstract LocalDate toLocalDate(T target);

    abstract LocalDateTime toLocalDateTime(T target);
}
