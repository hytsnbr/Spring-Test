package com.hytsnbr.base_common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilTest {
    
    @Test
    @DisplayName("正数 絶対値")
    void numberDigits_Plus() {
        
        int testValue = 12345;
        
        final int expected = 5;
        final int actual = Util.getDigits(testValue);
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("負数 絶対値")
    void numberDigits_Minus() {
        
        int testValue = -987654321;
        
        final int expected = 9;
        final int actual = Util.getDigits(testValue);
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Util.getDigits 引数null")
    void numberDigits_Null() {
        assertThrows(NullPointerException.class, () -> Util.getDigits(null));
    }
}
