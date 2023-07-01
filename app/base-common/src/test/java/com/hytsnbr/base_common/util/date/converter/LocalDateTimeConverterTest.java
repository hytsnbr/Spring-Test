package com.hytsnbr.base_common.util.date.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hytsnbr.base_common.constant.DateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class LocalDateTimeConverterTest {
    
    private static final String TIME_ZONE = "UTC";
    
    private LocalDateTimeConverter localDateTimeConverter;
    
    @BeforeEach
    void setUp() {
        localDateTimeConverter = new LocalDateTimeConverter(TIME_ZONE);
    }
    
    @Test
    void fromString() {
        final String dateString = "2022-01-01 12:59";
        
        final var expected = this.createTestLocalDateTime();
        try {
            final var actual = localDateTimeConverter.fromString(dateString, DateFormat.HYPHEN_YYYYMMDDHHMM);
            
            assertEquals(expected.toString(), actual.toString());
        } catch (Exception e) {
            fail();
        }
    }

//    @Test
//    void fromEpochTime() {
//        final long epochTime = 1641009540000L; // 2022-01-01 12:59
//        
//        final var expected = this.createTestLocalDateTime();
//        final var actual = localDateTimeConverter.fromEpochTime(epochTime);
//        
//        assertEquals(expected.toString(), actual.toString());
//    }
    
    private LocalDateTime createTestLocalDateTime() {
        return LocalDateTime.of(2022, 1, 1, 12, 59);
    }
    
    @Test
    void toUtilDate() {
        final LocalDateTime testLocalDateTime = this.createTestLocalDateTime();
        
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(TIME_ZONE));
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        final var expected = new java.util.Date(calendar.getTimeInMillis() - TimeZone.getDefault().getRawOffset());
        final var actual = localDateTimeConverter.toUtilDate(testLocalDateTime);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toSqlDate() {
        final long epochTime = 1641009540000L; // 2022-01-01 12:59
        final LocalDateTime testLocalDateTime = this.createTestLocalDateTime();
        
        final var expected = new Date(epochTime);
        final var actual = localDateTimeConverter.toSqlDate(testLocalDateTime);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    @SuppressWarnings("deprecation")
    void toTimestamp() {
        final LocalDateTime testLocalDateTime = this.createTestLocalDateTime();
        
        final var expected = new Timestamp(2022 - 1900, 0, 1, 12, 59, 0, 0);
        final var actual = localDateTimeConverter.toTimestamp(testLocalDateTime);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDate() {
        final LocalDateTime testLocalDateTime = this.createTestLocalDateTime();
        
        final var expected = LocalDate.of(2022, 1, 1);
        final var actual = localDateTimeConverter.toLocalDate(testLocalDateTime);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDateTime() {
        final LocalDateTime testLocalDateTime = this.createTestLocalDateTime();
        
        final var expected = this.createTestLocalDateTime();
        final var actual = localDateTimeConverter.toLocalDateTime(testLocalDateTime);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toUnixTime() {
        final LocalDateTime testLocalDateTime = this.createTestLocalDateTime();
        
        final var expected = 1641041940L; // 2022-01-01 12:59
        final var actual = localDateTimeConverter.toUnixTime(testLocalDateTime);
        
        assertEquals(expected, actual);
    }
}
