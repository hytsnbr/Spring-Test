package com.hytsnbr.spring_test.app.steam.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.hytsnbr.spring_test.base_common.config.property.ApiKey;
import com.hytsnbr.spring_test.base_common.config.property.ApiProperties;
import com.hytsnbr.spring_test.base_common.dao.BaseApiRepository;
import com.hytsnbr.spring_test.base_common.util.Util;

public class SteamApiRepository extends BaseApiRepository {
    
    private final ApiKey apiKey;
    
    /**
     * コンストラクタ
     */
    public SteamApiRepository(ApiProperties apiProperties, ApiKey apiKey) {
        super(apiProperties);
        this.apiKey = apiKey;
    }
    
    public <T> T getRequest(String url, Map<String, String> params, Class<T> responseType) {
        ResponseEntity<T> responseEntity;
        String requestUrl = "";
        if (Objects.isNull(params)) {
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("key", apiKey.getSteam());
            requestUrl = this.createUrlWithQueryParams(url, queryParams);
        } else {
            requestUrl = this.createUrlWithQueryParams(url, params);
        }
        responseEntity = super.get(requestUrl, null, new HashMap<>(), responseType);
        
        return responseEntity.getBody();
    }
    
    public <T> T getRequest(String url, Object params, Class<T> responseType) {
        Map<String, Object> queryParams = Util.objectConvertQueryParam(params);
        String requestUrl = this.createUrlWithQueryParams(url, queryParams);
        ResponseEntity<T> responseEntity = super.get(requestUrl, null, new HashMap<>(), responseType);
        return responseEntity.getBody();
    }
    
    public <T> T postRequest(String url, Map<String, String> params, Class<T> responseType) {
        ResponseEntity<T> responseEntity = super.post(url, null, params, responseType);
        return responseEntity.getBody();
    }
    
    public <T> T postRequest(String url, Object params, Class<T> responseType) {
        ResponseEntity<T> responseEntity = super.post(url, null, params, responseType);
        return responseEntity.getBody();
    }
    
    private String createUrlWithQueryParams(String baseUrl, Map<String, ?> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);
        for (Map.Entry<String, ?> param : queryParams.entrySet()) {
            builder.queryParam(param.getKey(), param.getValue());
        }
        return builder.toUriString();
    }
}