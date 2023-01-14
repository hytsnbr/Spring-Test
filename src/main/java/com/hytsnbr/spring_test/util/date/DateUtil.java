package com.hytsnbr.spring_test.util.date;

import com.hytsnbr.spring_test.util.date.converter.*;

public final class DateUtil {
    
    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    public static UtilDateConverter utilDate() {
        return new UtilDateConverter();
    }
    
    public static SqlDateConverter sqlDate() {
        return new SqlDateConverter();
    }
    
    public static LocalDateConverter localDate() {
        return new LocalDateConverter();
    }
    
    public static LocalDateTimeConverter localDateTime() {
        return new LocalDateTimeConverter();
    }
    
    public static TimestampConverter timestamp() {
        return new TimestampConverter();
    }
}
