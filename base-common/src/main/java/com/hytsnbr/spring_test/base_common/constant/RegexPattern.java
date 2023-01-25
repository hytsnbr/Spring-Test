package com.hytsnbr.spring_test.base_common.constant;

public final class RegexPattern {
    
    public static final String ZIPCODE = "^\\d{3}\\-?\\d{4}$";
    
    private RegexPattern() {
        throw new IllegalStateException("Utility class");
    }
}
