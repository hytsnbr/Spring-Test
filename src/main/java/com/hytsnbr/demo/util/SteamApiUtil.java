package com.hytsnbr.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class SteamApiUtil {

    static ObjectMapper mapper;

    /*
     * static イニシャライザ
     */
    static {
        mapper = new ObjectMapper();
    }

    private SteamApiUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 
     */
    public static <T> T getResponse(String rawResponse, Class<T> responseType) throws JsonProcessingException {

        // Steam API のレスポンスは共通して "response" の中に入っている
        JsonNode jsonNode = mapper.readTree(rawResponse);
        T result = mapper.readValue(jsonNode.get("response")
                .toString(), responseType);

        return result;
    }
}