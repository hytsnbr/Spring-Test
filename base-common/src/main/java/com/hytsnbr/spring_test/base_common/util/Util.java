package com.hytsnbr.spring_test.base_common.util;

import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 汎用ユーティリティ
 */
public final class Util {
    
    private static final Logger logger = LoggerFactory.getLogger(Util.class);
    
    static ObjectMapper mapper;
    
    /*
     * static イニシャライザ
     */
    static {
        mapper = new ObjectMapper();
    }
    
    private Util() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * 整数値 桁数取得
     *
     * @param number 整数値
     *
     * @return 桁数
     */
    public static int getDigits(@NotNull Integer number) {
        Objects.requireNonNull(number);
        
        return String.valueOf(Math.abs(number)).length();
    }
    
    /**
     * Object => Map
     *
     * @param targetObject target object
     *
     * @return Map
     */
    public static Map<String, Object> objectConvertQueryParam(Object targetObject) {
        String jsonStr;
        try {
            jsonStr = mapper.writeValueAsString(targetObject);
            return mapper.readValue(jsonStr, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            logger.error("", e);
            throw new RuntimeException("Can not convert object to map.");
        }
    }
}
