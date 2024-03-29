package com.hytsnbr.base_common.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeUtilTest {
    
    @Test
    @DisplayName("年度取得 引数LocalDate 4月")
    void getNendo_from_LocalDate_4月() {
        
        LocalDate date = LocalDate.of(2022, 4, 1);
        
        final int expected = 2022;
        final int actual = TimeUtil.getNendo(date);
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("年度取得 引数LocalDate 3月")
    void getNendo_from_LocalDate_3月() {
        
        LocalDate date = LocalDate.of(2022, 3, 31);
        
        final int expected = 2021;
        final int actual = TimeUtil.getNendo(date);
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("年度取得 引数UtilDate 4月")
    void getNendo_from_UtilDate_4月() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date date = new Date(calendar.getTimeInMillis());
        
        final int expected = 2022;
        final int actual = TimeUtil.getNendo(date);
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("年度取得 引数UtilDate 3月")
    void getNendo_from_UtilDate_3月() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        Date date = new Date(calendar.getTimeInMillis());
        
        final int expected = 2021;
        final int actual = TimeUtil.getNendo(date);
        
        assertEquals(expected, actual);
    }
}
