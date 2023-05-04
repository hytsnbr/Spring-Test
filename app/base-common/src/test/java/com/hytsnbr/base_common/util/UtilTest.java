package com.hytsnbr.base_common.util;

import jakarta.validation.constraints.NotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UtilTest {
    
    @Test
    @DisplayName("正数 桁数")
    void numberDigits_Plus() {
        
        int testValue = 12345;
        
        final int expected = 5;
        final int actual = Util.getDigits(testValue);
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("負数 桁数")
    void numberDigits_Minus() {
        
        int testValue = -987654321;
        
        final int expected = 9;
        final int actual = Util.getDigits(testValue);
        
        assertEquals(expected, actual);
    }
    
    @SuppressWarnings("DataFlowIssue")
    @Test
    @DisplayName("Util.getDigits 引数null")
    void numberDigits_Null() {
        assertThrows(NullPointerException.class, () -> Util.getDigits((@NotNull Integer) null));
        assertThrows(NullPointerException.class, () -> Util.getDigits((@NotNull Long) null));
    }
}
