package com.hytsnbr.spring_test.app.steam.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Steam APIユーティリティ
 */
public final class SteamApiUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(SteamApiUtil.class);
    
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
     * レスポンス取り出し
     *
     * @param rawResponse  生のレスポンスボディ
     * @param responseType 取り出したレスポンス文字列のマッピング先クラス
     *
     * @return 変換したレスポンスオブジェクト
     */
    public static <T> T getResponse(String rawResponse, Class<T> responseType) {
        try {
            // Steam API のレスポンスは共通して "response" の中に入っている
            JsonNode jsonNode = mapper.readTree(rawResponse);
            return mapper.readValue(jsonNode.get("response").toString(), responseType);
        } catch (JsonProcessingException e) {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
}