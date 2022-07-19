package com.hytsnbr.demo.constant;

import org.springframework.stereotype.Component;

@Component
public final class RegexPattern {

    public static final String ZIPCODE = "^\\d{3}\\-?\\d{4}$";

    private RegexPattern() {
        throw new IllegalStateException("Utility class");
    }
}
