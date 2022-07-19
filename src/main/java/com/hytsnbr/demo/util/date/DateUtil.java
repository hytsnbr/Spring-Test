package com.hytsnbr.demo.util.date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.hytsnbr.demo.util.date.converter.DateConverter;
import com.hytsnbr.demo.util.date.converter.LocalDateConverter;
import com.hytsnbr.demo.util.date.converter.LocalDateTimeConverter;
import com.hytsnbr.demo.util.date.converter.SqlDateConverter;
import com.hytsnbr.demo.util.date.converter.TimestampConverter;
import com.hytsnbr.demo.util.date.converter.UtilDateConverter;

public final class DateUtil {

    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static DateConverter<java.util.Date> utilDate() {
        return new UtilDateConverter();
    }

    public static DateConverter<java.sql.Date> sqlDate() {
        return new SqlDateConverter();
    }

    public static DateConverter<LocalDate> localDate() {
        return new LocalDateConverter();
    }

    public static DateConverter<LocalDateTime> localDateTime() {
        return new LocalDateTimeConverter();
    }

    public static DateConverter<Timestamp> timestamp() {
        return new TimestampConverter();
    }
}
