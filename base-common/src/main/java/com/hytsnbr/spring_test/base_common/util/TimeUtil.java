package com.hytsnbr.spring_test.base_common.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

/**
 * 時間関連ユーティリティ
 */
public final class TimeUtil {
    
    private TimeUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * システム日付から年度を取得
     */
    public static int getNendo() {
        return getNendo(LocalDate.now());
    }
    
    /**
     * 指定日付から年度を取得
     */
    public static int getNendo(java.util.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        Month month = Month.of(calendar.get(Calendar.MONTH) + 1);
        return switch (month) {
            case JANUARY, FEBRUARY, MARCH -> calendar.get(Calendar.YEAR) - 1;
            default -> calendar.get(Calendar.YEAR);
        };
    }
    
    /**
     * 指定日付から年度を取得
     */
    public static int getNendo(LocalDate localDate) {
        return localDate.plusMonths(-3).getYear();
    }
}