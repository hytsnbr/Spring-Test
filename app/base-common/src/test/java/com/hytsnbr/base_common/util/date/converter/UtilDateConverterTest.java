package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hytsnbr.base_common.constant.DateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UtilDateConverterTest {
    
    private static final String TIME_ZONE = "UTC";
    
    private UtilDateConverter utilDateConverter;
    
    @BeforeEach
    void setUp() {
        utilDateConverter = new UtilDateConverter(TIME_ZONE);
    }
    
    @Test
    void fromString() {
        final String dateString = "2022-01-01 12:59:30";
        
        SimpleDateFormat format = new SimpleDateFormat(DateFormat.SLASH_YYYYMMDDHHMM.getFormat());
        format.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
        final var expected = format.format(this.createTestDate());
        try {
            final var actual = format.format(utilDateConverter.fromString(dateString, DateFormat.HYPHEN_YYYYMMDDHHMM));
            
            assertEquals(expected, actual);
        } catch (ParseException e) {
            fail();
        }
    }

//    @Test
//    void fromEpochTime() {
//        final long epochTime = 1641041970000L; // 2022-01-01 12:59:30
//        
//        final var expected = new Date(epochTime);
//        final var actual = utilDateConverter.fromEpochTime(epochTime);
//        
//        assertEquals(expected.toString(), actual.toString());
//    }
    
    private Date createTestDate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(TIME_ZONE));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 30);
        calendar.set(Calendar.MILLISECOND, 0);
        
        return calendar.getTime();
    }
    
    @Test
    void toUtilDate() {
        final Date testDate = this.createTestDate();
        
        final var expected = this.createTestDate();
        final var actual = utilDateConverter.toUtilDate(testDate);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toSqlDate() {
        final long epochTime = 1640995200000L; // 2022-01-01 00:00
        final Date testDate = this.createTestDate();
        
        final var expected = new java.sql.Date(epochTime);
        final var actual = utilDateConverter.toSqlDate(testDate);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toTimestamp() {
        final long epochTime = 1641041970000L; // 2022-01-01 12:59:30
        final Date testDate = this.createTestDate();
        
        final var expected = new Timestamp(epochTime);
        final var actual = utilDateConverter.toTimestamp(testDate);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDate() {
        final Date testDate = this.createTestDate();
        
        final var expected = LocalDate.of(2022, 1, 1);
        final var actual = utilDateConverter.toLocalDate(testDate);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDateTime() {
        final Date testDate = this.createTestDate();
        
        final var expected = LocalDateTime.of(2022, 1, 1, 12, 59, 30);
        final var actual = utilDateConverter.toLocalDateTime(testDate);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toUnixTime() {
        final Date testDate = this.createTestDate();
        
        final var expected = 1641041970000L; // 2022-01-01 12:59:30
        final var actual = utilDateConverter.toUnixTime(testDate);
        
        assertEquals(expected, actual);
    }
}
