package com.hytsnbr.base_common.util;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

/**
 * API関連ユーティリティ
 */
public final class ApiUtil {
    
    private ApiUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * 成功判定
     *
     * @param httpStatusCode  HTTPステータスコード
     * @param successfulCodes 成功とするHTTPステータスコード
     */
    public static boolean isSuccess(int httpStatusCode, int... successfulCodes) {
        return Arrays.stream(successfulCodes).anyMatch(code -> code == httpStatusCode);
    }
    
    /**
     * 成功判定
     *
     * @param httpStatus             {@link org.springframework.http.HttpStatus HttpStatus }
     * @param successfulHttpStatuses {@link org.springframework.http.HttpStatus HttpStatus }
     */
    public static boolean isSuccess(HttpStatus httpStatus, HttpStatus... successfulHttpStatuses) {
        return isSuccess(
            httpStatus.value(),
            Arrays.stream(successfulHttpStatuses).mapToInt(HttpStatus::value).toArray()
        );
    }
    
    /**
     * 成功判定
     *
     * @param httpStatusCode            {@link org.springframework.http.HttpStatusCode HttpStatus }
     * @param successfulHttpStatusCodes {@link org.springframework.http.HttpStatusCode HttpStatus }
     */
    public static boolean isSuccess(HttpStatusCode httpStatusCode, HttpStatusCode... successfulHttpStatusCodes) {
        return isSuccess(
            httpStatusCode.value(),
            Arrays.stream(successfulHttpStatusCodes).mapToInt(HttpStatusCode::value).toArray()
        );
    }
    
    /**
     * 失敗判定
     *
     * @param httpStatusCode HTTPステータスコード
     * @param failureCodes   失敗とするHTTPステータスコード
     */
    public static boolean isFailure(int httpStatusCode, int... failureCodes) {
        return Arrays.stream(failureCodes).anyMatch(code -> code == httpStatusCode);
    }
    
    /**
     * 失敗判定
     *
     * @param httpStatus        {@link org.springframework.http.HttpStatus HttpStatus }
     * @param failureHttpStatus {@link org.springframework.http.HttpStatus HttpStatus }
     */
    public static boolean isFailure(HttpStatus httpStatus, HttpStatus... failureHttpStatus) {
        return isFailure(
            httpStatus.value(),
            Arrays.stream(failureHttpStatus).mapToInt(HttpStatus::value).toArray()
        );
    }
    
    /**
     * 失敗判定
     *
     * @param httpStatusCode         {@link org.springframework.http.HttpStatusCode HttpStatus }
     * @param failureHttpStatusCodes {@link org.springframework.http.HttpStatusCode HttpStatus }
     */
    public static boolean isFailure(HttpStatusCode httpStatusCode, HttpStatusCode... failureHttpStatusCodes) {
        return isFailure(
            httpStatusCode.value(),
            Arrays.stream(failureHttpStatusCodes).mapToInt(HttpStatusCode::value).toArray()
        );
    }
}
