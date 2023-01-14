package com.hytsnbr.spring_test.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// TODO: 異常系テスト
public class UtilDateConverterTest {
    
    private UtilDateConverter utilDateConverter;
    
    @BeforeEach
    void setUp() {
        utilDateConverter = new UtilDateConverter();
    }
    
    @Test
    void testFromEpochTimeSuccess() {
        final long epochTime = 1641041940000L; // 2022-01-01 12:59
        
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        final Date excepted = calendar.getTime();
        final Date actual = utilDateConverter.fromEpochTime(epochTime);
        
        assertEquals(excepted, actual);
    }
    
    @Test
    void testFromString() {
        final String dateString = "2022-01-01 12:59";
        
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        final Date excepted = calendar.getTime();
        try {
            final Date actual = utilDateConverter.fromString(dateString, "yyyy-mm-dd HH:mm");
            assertEquals(excepted, actual);
        } catch (ParseException e) {
            fail();
        }
    }
    
    @Test
    void testToLocalDate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 59);
        final Date testDate = calendar.getTime();
        
        final LocalDate excepted = LocalDate.of(2022, 1, 1);
        final LocalDate actual = utilDateConverter.toLocalDate(testDate);
        
        assertEquals(excepted, actual);
    }
    
    @Test
    void testToLocalDateTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        final Date testDate = calendar.getTime();
        
        final LocalDateTime excepted = LocalDateTime.of(2022, 1, 1, 12, 59, 59);
        final LocalDateTime actual = utilDateConverter.toLocalDateTime(testDate);
        
        assertEquals(excepted, actual);
    }
    
    @Test
    void testToSqlDate() {
        final long epochTime = 1640995200000L; // 2022-01-01 00:00
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        final Date testDate = calendar.getTime();
        
        final java.sql.Date excepted = new java.sql.Date(epochTime);
        final java.sql.Date actual = utilDateConverter.toSqlDate(testDate);
        
        assertEquals(excepted, actual);
    }
    
    @Test
    void testToTimeStamp() {
        final long epochTime = 1641041940000L; // 2022-01-01 12:59
        
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final Date testDate = calendar.getTime();
        
        final Timestamp excepted = new Timestamp(epochTime);
        final Date actual = utilDateConverter.toTimeStamp(testDate);
        
        assertEquals(excepted, actual);
    }
}
