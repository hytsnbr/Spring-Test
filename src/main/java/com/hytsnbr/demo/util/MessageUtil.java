package com.hytsnbr.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class MessageUtil {

    public static String getMessage(MessageSource messageSource, final String key) {
        return messageSource.getMessage(key, new String[] {}, Locale.getDefault());
    }

    public static String getMessage(MessageSource messageSource, final String key, String... params) {
        return messageSource.getMessage(key, params, Locale.getDefault());
    }

    public static boolean isValidMessageKey(MessageSource messageSource, final String key) {
        try {
            messageSource.getMessage(key, new Object[] {}, Locale.getDefault());
        } catch (NoSuchMessageException e) {
            log.info("Message Key: {} is not exist.", key);
            return false;
        }

        return true;
    }
}
