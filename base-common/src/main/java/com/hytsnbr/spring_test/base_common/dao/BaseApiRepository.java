package com.hytsnbr.spring_test.base_common.dao;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.hytsnbr.spring_test.base_common.config.property.ApiProperties;
import com.hytsnbr.spring_test.base_common.exception.api.ApiCallFailedException;
import com.hytsnbr.spring_test.base_common.util.Util;

/**
 * API関連 基底クラス
 */
public class BaseApiRepository {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /** APIプロパティ */
    private final ApiProperties apiProperties;
    
    /** コンストラクタ */
    public BaseApiRepository(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }
    
    /**
     * GET
     *
     * @param baseUrl
     * @param httpHeaders
     * @param queryParams
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> get(
        String baseUrl, Map<String, String> httpHeaders,
        Map<String, ?> queryParams, Class<T> responseType
    ) throws ApiCallFailedException {
        RequestEntity<?> requestEntity = RequestEntity
            .method(HttpMethod.GET, baseUrl, queryParams)
            .headers(this.createHttpHeaders(httpHeaders))
            .build();
        
        return exchange(requestEntity, responseType);
    }
    
    /**
     * GET
     *
     * @param baseUrl
     * @param httpHeaders
     * @param queryParams
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> get(
        String baseUrl, Map<String, String> httpHeaders, Object queryParams,
        Class<T> responseType
    ) throws ApiCallFailedException {
        return this.get(baseUrl, httpHeaders, this.convertObject2QueryParams(queryParams), responseType);
    }
    
    /**
     * POST
     *
     * @param url
     * @param httpHeaders
     * @param requestBody
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> post(
        String url, Map<String, String> httpHeaders,
        Map<String, Object> requestBody, Class<T> responseType
    ) throws ApiCallFailedException {
        RequestEntity<?> requestEntity = RequestEntity
            .method(HttpMethod.POST, url)
            .headers(this.createHttpHeaders(httpHeaders))
            .body(requestBody);
        
        return exchange(requestEntity, responseType);
    }
    
    /**
     * POST
     *
     * @param url
     * @param httpHeaders
     * @param requestBody
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> post(
        String url, Map<String, String> httpHeaders, Object requestBody,
        Class<T> responseType
    ) throws ApiCallFailedException {
        RequestEntity<?> requestEntity = RequestEntity
            .method(HttpMethod.POST, url)
            .headers(this.createHttpHeaders(httpHeaders))
            .body(requestBody);
        
        return exchange(requestEntity, responseType);
    }
    
    /**
     * PUT
     *
     * @param url
     * @param httpHeaders
     * @param requestBody
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> put(
        String url, Map<String, String> httpHeaders,
        Map<String, Object> requestBody, Class<T> responseType
    ) throws ApiCallFailedException {
        RequestEntity<?> requestEntity = RequestEntity
            .method(HttpMethod.PUT, url)
            .headers(this.createHttpHeaders(httpHeaders))
            .body(requestBody);
        
        return exchange(requestEntity, responseType);
    }
    
    /**
     * PUT
     *
     * @param url
     * @param httpHeaders
     * @param requestBody
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> put(
        String url, Map<String, String> httpHeaders, Object requestBody,
        Class<T> responseType
    ) throws ApiCallFailedException {
        RequestEntity<?> requestEntity = RequestEntity
            .method(HttpMethod.PUT, url)
            .headers(this.createHttpHeaders(httpHeaders))
            .body(requestBody);
        
        return exchange(requestEntity, responseType);
    }
    
    /**
     * DELETE
     *
     * @param url
     * @param httpHeaders
     * @param requestBody
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> delete(
        String url, Map<String, String> httpHeaders,
        Map<String, Object> requestBody, Class<T> responseType
    ) throws ApiCallFailedException {
        RequestEntity<?> requestEntity = RequestEntity
            .method(HttpMethod.DELETE, url)
            .headers(this.createHttpHeaders(httpHeaders))
            .body(requestBody);
        
        return exchange(requestEntity, responseType);
    }
    
    /**
     * DELETE
     *
     * @param url
     * @param httpHeaders
     * @param requestBody
     * @param responseType
     * @param <T>
     *
     * @return
     *
     * @throws ApiCallFailedException
     */
    protected <T> ResponseEntity<T> delete(
        String url, Map<String, String> httpHeaders, Object requestBody,
        Class<T> responseType
    ) throws ApiCallFailedException {
        RequestEntity<?> requestEntity = RequestEntity
            .method(HttpMethod.DELETE, url)
            .headers(this.createHttpHeaders(httpHeaders))
            .body(requestBody);
        
        return exchange(requestEntity, responseType);
    }
    
    /**
     * API処理 共通部
     * <p>HTTPステータス 400 or 500 系列のエラー処理も行う
     *
     * @param requestEntity リクエストエンティティ
     * @param responseType  レスポンスボディのクラスオブジェクト
     *
     * @return レスポンスエンティティ
     */
    private <T1, T2> ResponseEntity<T2> exchange(RequestEntity<T1> requestEntity, Class<T2> responseType) {
        
        logger.info("RequestEntity: {}", requestEntity);
        logger.info("ResponseType: {}", responseType);
        
        // TODO: APIエラーの種別ごとにメッセージを設定する
        try {
            return this.restTemplate().exchange(requestEntity, responseType);
        } catch (HttpClientErrorException e) {
            // HTTPステータスコード 4xx エラー
            logger.error(e.getMessage(), e);
        } catch (HttpServerErrorException e) {
            // HTTPステータスコード 5xxエラー
            logger.error(e.getMessage(), e);
        } catch (UnknownHttpStatusCodeException e) {
            // 未知のHTTPステータスコードエラー
            // RFC2616に定義されないコードが送られた場合の例外
            logger.error(e.getMessage(), e);
        } catch (ResourceAccessException e) {
            // I/O系エラー
            logger.error(e.getMessage(), e);
        } catch (RestClientException e) {
            // 上記以外のRestTemplate関連の例外
            logger.error(e.getMessage(), e);
        }
        
        throw new ApiCallFailedException("API Request has failed.");
    }
    
    /**
     * RestTemplate 作成
     * <p>RestTemplate に関する設定はここで行う
     */
    private RestTemplate restTemplate() {
        ApiProperties.Timeout timeoutConfig = this.apiProperties.getTimeout();
        
        return new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofSeconds((timeoutConfig.getConnection())))
            .setReadTimeout(Duration.ofSeconds(timeoutConfig.getRead()))
            .build();
    }
    
    /**
     * HttpHeaders 作成
     * <p>少なくとも{@code Content-Type}は設定される
     */
    private HttpHeaders createHttpHeaders(Map<String, String> values) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        if (Objects.nonNull(values)) {
            headers.setAll(values);
        }
        
        return headers;
    }
    
    /**
     * オブジェクトをクエリパラメータに変換
     *
     * @param obj 変換対象のオブジェクトインスタンス
     *
     * @return クエリパラメータ
     */
    private Map<String, Object> convertObject2QueryParams(Object obj) {
        return new HashMap<>(Util.objectConvertQueryParam(obj));
    }
}