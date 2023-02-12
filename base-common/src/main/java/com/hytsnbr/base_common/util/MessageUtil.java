package com.hytsnbr.base_common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

/**
 * メッセージ関連ユーティリティ
 */
@Slf4j
public final class MessageUtil {
    
    private MessageUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * メッセージ文字列取得
     *
     * @param messageSource MessageSourceインスタンス
     * @param key           メッセージキー
     *
     * @return メッセージ文字列
     */
    public static String getMessage(MessageSource messageSource, final String key) {
        return messageSource.getMessage(key, new String[]{}, Locale.getDefault());
    }
    
    /**
     * メッセージ文字列取得
     *
     * @param messageSource MessageSourceインスタンス
     * @param key           メッセージキー
     * @param params        メッセージパラメータ
     *
     * @return メッセージ文字列
     */
    public static String getMessage(MessageSource messageSource, final String key, String... params) {
        return messageSource.getMessage(key, params, Locale.getDefault());
    }
    
    /**
     * メッセージキーが有効かチェック
     *
     * @param messageSource MessageSourceインスタンス
     * @param key           メッセージキー
     *
     * @return メッセージキーに対応するメッセージ文字列が定義されていればtrue
     */
    public static boolean isValidMessageKey(MessageSource messageSource, final String key) {
        try {
            messageSource.getMessage(key, new Object[]{}, Locale.getDefault());
        } catch (NoSuchMessageException e) {
            log.info("Message Key: {} is not exist.", key);
            return false;
        }
        
        return true;
    }
}
