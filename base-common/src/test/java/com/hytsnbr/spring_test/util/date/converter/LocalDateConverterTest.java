package com.hytsnbr.spring_test.util.date.converter;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hytsnbr.spring_test.base_common.util.date.converter.LocalDateConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LocalDateConverterTest {
    
    private LocalDateConverter localDateConverter;
    
    @BeforeEach
    void setUp() {
        localDateConverter = new LocalDateConverter();
    }
    
    @Test
    void testFromEpochTime() {
        
    }
    
    @Test
    void testFromString() {
        LocalDate expected = LocalDate.of(2022, 4, 1);
        
        try {
            LocalDate actual = localDateConverter.fromString("2022/04/01", "yyyy/MM/dd");
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    void testToLocalDate() {
        
    }
    
    @Test
    void testToLocalDateTime() {
        
    }
    
    @Test
    void testToSqlDate() {
        
    }
    
    @Test
    void testToTimeStamp() {
        
    }
    
    @Test
    void testToUtilDate() {
        
    }
}
