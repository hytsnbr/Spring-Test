package com.hytsnbr.base_common.util.date.converter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hytsnbr.base_common.constant.DateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class LocalDateConverterTest {
    
    private static final String TIME_ZONE = "UTC";
    
    private LocalDateConverter localDateConverter;
    
    @BeforeEach
    void setUp() {
        localDateConverter = new LocalDateConverter(TIME_ZONE);
    }
    
    @Test
    void fromString() {
        final String dateString = "2022-01-01";
        
        final var expected = LocalDate.of(2022, 1, 1);
        try {
            final var actual = localDateConverter.fromString(dateString, DateFormat.HYPHEN_YYYYMMDD);
            
            assertEquals(expected.toString(), actual.toString());
        } catch (Exception e) {
            fail();
        }
    }

//    @Test
//    void fromEpochTime() {
//        final long epochDay = 18993L; // 2022-01-01
//        
//        final var expected = LocalDate.of(2022, 1, 1);
//        final var actual = localDateConverter.fromEpochTime(epochDay);
//        
//        assertEquals(expected.toString(), actual.toString());
//    }
    
    @Test
    @SuppressWarnings("deprecation")
    void toUtilDate() {
        final var expected = new java.util.Date(2022 - 1900, Calendar.JANUARY, 1);
        final var actual = localDateConverter.toUtilDate(this.createTestLocalDate());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    private LocalDate createTestLocalDate() {
        return LocalDate.of(2022, 1, 1);
    }
    
    @Test
    @SuppressWarnings("deprecation")
    void toSqlDate() {
        final var expected = new java.sql.Date(2022 - 1900, Calendar.JANUARY, 1);
        final var actual = localDateConverter.toSqlDate(this.createTestLocalDate());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    @SuppressWarnings("deprecation")
    void toTimestamp() {
        final var expected = new Timestamp(2022 - 1900, 0, 1, 0, 0, 0, 0);
        final var actual = localDateConverter.toTimestamp(this.createTestLocalDate());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDate() {
        final var expected = LocalDate.of(2022, 1, 1);
        final var actual = localDateConverter.toLocalDate(this.createTestLocalDate());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toLocalDateTime() {
        final var expected = LocalDateTime.of(2022, 1, 1, 0, 0);
        final var actual = localDateConverter.toLocalDateTime(this.createTestLocalDate());
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void toUnixTime() {
        final var expected = 1640995200L; // 2022-01-01
        final var actual = localDateConverter.toUnixTime(this.createTestLocalDate());
        
        assertEquals(expected, actual);
    }
}
