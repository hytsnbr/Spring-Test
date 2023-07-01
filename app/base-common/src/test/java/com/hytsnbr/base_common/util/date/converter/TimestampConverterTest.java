package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hytsnbr.base_common.constant.DateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TimestampConverterTest {
    
    private static final String TIME_ZONE = "UTC";
    
    private TimestampConverter timestampConverter;
    
    @BeforeEach
    void setUp() {
        timestampConverter = new TimestampConverter(TIME_ZONE);
    }
    
    @Test
    @SuppressWarnings("deprecation")
    void fromString() {
        final String dateString = "2022-01-01 12:59:30";
        
        final var expected = new Timestamp(2022 - 1900, Calendar.JANUARY, 1, 12, 59, 30, 0);
        try {
            final var actual = timestampConverter.fromString(dateString, DateFormat.HYPHEN_YYYYMMDDHHMMSS);
            
            assertEquals(expected.toString(), actual.toString());
        } catch (ParseException e) {
            fail();
        }
    }

//    @Test
//    void fromEpochTime() {
//        final long epochTime = 1641041970000L; // 2022-01-01 12:59:30
//        
//        final var expected = new Date(epochTime);
//        final var actual = timestampConverter.fromEpochTime(epochTime);
//        
//        assertEquals(expected.toString(), actual.toString());
//    }
    
    @Test
    void toUtilDate() {
        final long epochTime = 1641009570000L; // 2022-01-01 12:59
        final Timestamp testTimestamp = this.createTestTimestamp();
        
        final var expected = new Date(epochTime);
        final var actual = timestampConverter.toUtilDate(testTimestamp);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @SuppressWarnings("deprecation")
    private Timestamp createTestTimestamp() {
        return new Timestamp(2022 - 1900, 0, 1, 12, 59, 30, 0);
    }
    
    @Test
    void toSqlDate() {
        final long epochTime = 1640995200000L; // 2022-01-01 00:00
        final Timestamp testTimestamp = this.createTestTimestamp();
        
        final var expected = new java.sql.Date(epochTime);
        final var actual = timestampConverter.toSqlDate(testTimestamp);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toTimestamp() {
        final var expected = this.createTestTimestamp();
        final var actual = timestampConverter.toTimestamp(this.createTestTimestamp());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDate() {
        final var expected = LocalDate.of(2022, 1, 1);
        final var actual = timestampConverter.toLocalDate(this.createTestTimestamp());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDateTime() {
        final var expected = LocalDateTime.of(2022, 1, 1, 12, 59, 30);
        final var actual = timestampConverter.toLocalDateTime(this.createTestTimestamp());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toUnixTime() {
        final var expected = 1641041970000L; // 2022-01-01 12:59:30
        final var actual = timestampConverter.toUnixTime(this.createTestTimestamp());
        
        assertEquals(expected, actual);
    }
}
