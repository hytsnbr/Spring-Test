package com.hytsnbr.demo.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public final class UtilDateConverter extends DateConverter<Date> {

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

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(target);

        // java.sql.Date は java.util.Date と違い「年月日」までしか持たないため
        // 「時分秒ミリ秒」は初期化する必要がある
        // 参考: https://higayasuo.hatenablog.com/entry/20090219/1235020303
        //       https://salumarine.com/how-to-convert-java-util-date-to-java-sql-date/
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
        // LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Java9 から
        LocalDate localDate = LocalDate.ofInstant(target.toInstant(), ZoneId.systemDefault());

        return localDate;
    }

    @Override
    public LocalDateTime toLocalDateTime(Date target) {

        // Java8 まで
        // LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // Java9 から
        LocalDateTime localDateTime = LocalDateTime.ofInstant(target.toInstant(), ZoneId.systemDefault());

        return localDateTime;
    }
}
