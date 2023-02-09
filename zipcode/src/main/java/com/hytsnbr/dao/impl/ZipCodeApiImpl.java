package com.hytsnbr.dao.impl;

import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import com.hytsnbr.api.ZipcodeRequest;
import com.hytsnbr.api.ZipcodeResponse;
import com.hytsnbr.dao.ZipCodeApi;
import com.hytsnbr.spring_test.base_common.config.property.ApiProperties;
import com.hytsnbr.spring_test.base_common.constant.RegexPattern;
import com.hytsnbr.spring_test.base_common.dao.BaseApiRepository;
import com.hytsnbr.spring_test.base_common.exception.CollectionOversizeException;
import com.hytsnbr.spring_test.base_common.exception.api.ApiCallFailedException;
import com.hytsnbr.spring_test.base_common.exception.api.ApiNoResponseException;

@Slf4j
@Repository
public class ZipCodeApiImpl extends BaseApiRepository implements ZipCodeApi {
    
    /**
     * エンドポイント
     */
    private static final String URL = "https://zipcloud.ibsnet.co.jp/api/search";
    
    private static final String ZIPCODE = "zipcode";
    
    private static final String CALLBACK = "callback";
    
    private static final String LIMIT = "limit";
    
    private static final int SEARCH_LIMIT = 5;
    
    /**
     * コンストラクタ
     */
    public ZipCodeApiImpl(ApiProperties apiProperties) {
        super(apiProperties);
    }
    
    @Override
    public String getAddress(int zipcode) throws RestClientException {
        return this.getAddress(String.valueOf(zipcode));
    }
    
    @Override
    public String getAddress(@Pattern(regexp = RegexPattern.ZIPCODE) String zipcode) throws RestClientException {
        var requestParams = ZipcodeRequest.builder()
                                          .zipcode(zipcode)
                                          .build();
        ResponseEntity<ZipcodeResponse> response = super.get(URL, null, requestParams, ZipcodeResponse.class);
        
        ZipcodeResponse apiResponse = response.getBody();
        log.info("[ZipCodeApiLogic] Response Value: {}", apiResponse);
        
        // レスポンス 空チェック
        if (Objects.isNull(apiResponse)) {
            throw new ApiNoResponseException();
        }
        
        HttpStatus httpStatus = HttpStatus.resolve(apiResponse.getStatus());
        
        return switch (httpStatus) {
            case OK -> {
                if (CollectionUtils.isNotEmpty(apiResponse.getResults())) {
                    // TODO: ヒットした住所が2件以上はエラーにする？
                    yield apiResponse.getResults()
                                     .get(0)
                                     .getAddress();
                } else {
                    throw new ApiNoResponseException();
                }
            }
            case BAD_REQUEST ->
                // 入力パラメータエラー
                // TODO: パラメータエラー系のメッセージを例外にして返す
                throw new HttpClientErrorException(
                    HttpStatus.valueOf(apiResponse.getStatus()),
                    apiResponse.getMassage()
                );
            case INTERNAL_SERVER_ERROR ->
                // API内部エラー
                // TODO: パラメータエラー系のメッセージを例外にして返す
                throw new HttpServerErrorException(
                    HttpStatus.valueOf(apiResponse.getStatus()),
                    apiResponse.getMassage()
                );
            default -> throw new ApiCallFailedException();
        };
    }
    
    @Override
    public List<String> getAddresses(int[] zipcodes) {
        
        if (zipcodes.length > SEARCH_LIMIT) {
            throw new CollectionOversizeException("一度に検索できるのは5件までです");
        }
        
        List<ZipcodeRequest> requestList = new ArrayList<>();
        for (int zipcode : zipcodes) {
            var request = ZipcodeRequest.builder()
                                        .zipcode(String.valueOf(zipcode))
                                        .build();
            requestList.add(request);
        }
        
        return null; // FIXME: stub
    }
    
    @Override
    public List<String> getAddresses(List<String> zipcodes) {
        
        if (zipcodes.size() > SEARCH_LIMIT) {
            throw new CollectionOversizeException("一度に検索できるのは5件までです");
        }
        
        // リクエスト作成
        List<ZipcodeRequest> requestList = zipcodes
            .stream()
            .map(zipcode -> ZipcodeRequest.builder()
                                          .zipcode(zipcode)
                                          .build())
            .toList();
        
        return null; // FIXME: stub
    }
}
