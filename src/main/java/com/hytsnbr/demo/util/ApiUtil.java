package com.hytsnbr.demo.util;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public final class ApiUtil {

    private ApiUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T get(String url, Map<String, Object> params, Map<String, Object> headers,
            Class<T> responseType) {

        RestTemplate restTemplate = createRestTemplate();

        try {
            ResponseEntity<T> responseEntity = restTemplate.exchange(
                    UriComponentsBuilder.fromUriString(url).build(params),
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    responseType);

            if (isSuccess(responseEntity.getStatusCode())) {
                throw new RuntimeException(); // TODO
            }

            return responseEntity.getBody();
        } catch (RestClientException e) {
            // TODO
        }

        return null;
    }

    public static <T> T post(String url, Object request, Map<String, Object> headers, Class<T> responseType) {

        RestTemplate restTemplate = createRestTemplate();

        try {
            ResponseEntity<T> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    // TODO
                    null,
                    responseType);

            if (isSuccess(responseEntity.getStatusCode())) {
                throw new RuntimeException(); // TODO
            }

            return responseEntity.getBody();
        } catch (RestClientException e) {
            // TODO
        }

        return null;
    }

    /**
     * HTTPヘッダー作成
     * 
     * @param headers 設定するヘッダー名と値の Map
     * @return HttpHeaders 生成した HttpHeaders
     */
    private static HttpHeaders createHttpHeaders(Map<String, Object> headers) {
        // TODO: 処理実装
        return new HttpHeaders();
    }

    /**
     * RestTemplate 作成
     * 
     * @return RestTemplate
     */
    private static RestTemplate createRestTemplate() {
        // TODO: 処理実装
        return new RestTemplate();
    }

    /**
     * 成功判定
     * 
     * @param httpStatus レスポンスの HTTP ステータス
     * @return 200: OK の場合 true
     */
    public static boolean isSuccess(HttpStatus httpStatus) {
        return httpStatus == HttpStatus.OK;
    }

    /**
     * 失敗判定
     * 
     * @param httpStatus レスポンスの HTTP ステータス
     * @return 200: OK 以外の場合 true
     */
    public static boolean isFailure(HttpStatus httpStatus) {
        return httpStatus != HttpStatus.OK;
    }
}
