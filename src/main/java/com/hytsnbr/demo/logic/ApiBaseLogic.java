package com.hytsnbr.demo.logic;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import com.hytsnbr.demo.exception.api.ApiCallFailedException;
import com.hytsnbr.demo.property.ApiProperties;
import com.hytsnbr.demo.property.ApiProperties.Timeout;

/**
 * API関連 基底クラス
 */
@Slf4j
public class ApiBaseLogic {

    /**
     * 成功HTTPステータス
     */
    static final HttpStatus[] SUCCESS_CODE = {
            HttpStatus.OK
    };

    /**
     * APIプロパティ
     */
    final ApiProperties apiProperties;

    /**
     * コンストラクタ
     */
    public ApiBaseLogic(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    protected <T> T get(final String baseUrl, Map<String, ?> queryParams, Class<T> responseType)
            throws ApiCallFailedException {
        return this.restTemplate()
                .getForObject(baseUrl, responseType, queryParams);
    }

    protected <T> T post(final String baseUrl, Map<String, ?> queryParams, Class<T> responseType)
            throws ApiCallFailedException {
        return this.restTemplate()
                .postForObject(baseUrl, String.class, responseType, queryParams);
    }

    protected RestTemplate restTemplate() {
        Timeout timeoutConfig = this.apiProperties.getTimeout();

        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds((timeoutConfig.getConnection())))
                .setReadTimeout(Duration.ofSeconds(timeoutConfig.getRead()))
                .build();
    }

    protected boolean isSuccess(int httpStatus) {
        return Arrays.stream(SUCCESS_CODE)
                .allMatch(e -> e.value() == httpStatus);
    }

    protected boolean isSuccess(HttpStatus httpStatus) {
        return isSuccess(httpStatus.value());
    }

    protected boolean isFailure(int httpStatus) {
        return !isSuccess(httpStatus);
    }

    protected boolean isFailure(HttpStatus httpStatus) {
        return !isSuccess(httpStatus);
    }
}