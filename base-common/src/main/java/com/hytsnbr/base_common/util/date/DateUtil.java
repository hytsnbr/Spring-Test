package com.hytsnbr.base_common.util.date;

import com.hytsnbr.base_common.util.date.converter.LocalDateConverter;
import com.hytsnbr.base_common.util.date.converter.LocalDateTimeConverter;
import com.hytsnbr.base_common.util.date.converter.SqlDateConverter;
import com.hytsnbr.base_common.util.date.converter.TimestampConverter;
import com.hytsnbr.base_common.util.date.converter.UtilDateConverter;

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
