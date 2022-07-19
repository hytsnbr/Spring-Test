package com.hytsnbr.demo.app.zipcode.repository.impl;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.hytsnbr.demo.app.zipcode.model.api.ZipcodeRequest;
import com.hytsnbr.demo.app.zipcode.model.api.ZipcodeResponse;
import com.hytsnbr.demo.app.zipcode.repository.ZipCodeApi;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import com.hytsnbr.demo.config.property.ApiProperties;
import com.hytsnbr.demo.constant.RegexPattern;
import com.hytsnbr.demo.exception.api.ApiCallFailedException;
import com.hytsnbr.demo.exception.api.ApiNoResponseException;
import com.hytsnbr.demo.repository.ApiBaseLogic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ZipCodeApiImpl extends ApiBaseLogic implements ZipCodeApi {

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
        ZipcodeRequest requestParams = ZipcodeRequest.builder()
                .zipcode(zipcode)
                .build();
        ZipcodeResponse response = this.exchange(requestParams);

        return response.getResults()
                .get(0)
                .getAddress();
    }

    // @Override
    // public List<String> getAddresses(int[] zipcodes) throws Exception {

    // if (zipcodes.length > SEARCH_LIMIT) {
    // throw new CollectionOversizeException();
    // }

    // List<ApiRequest> requestList = Arrays.asList(zipcodes)
    // .stream()
    // .map(zipcode -> {
    // return new ApiRequest(zipcode);
    // })
    // .collection(Collectors.toList());

    // for (ApiRequest request : requestList) {

    // }
    // }

    // @Override
    // public List<String> getAddresses(List<Integer> zipcodes) throws Exception {

    // if (zipcodes.size() > SEARCH_LIMIT) {
    // throw new CollectionOversizeException();
    // }

    // List<ApiRequest> requestList = zipcodes
    // .stream()
    // .map(zipcode -> {
    // return new ApiRequest(zipcode);
    // })
    // .collection(Collectors.toList());
    // }

    // @Override
    // public List<String> getAddresses(List<String> zipcodes) throws Exception {

    // if (zipcodes.size() > SEARCH_LIMIT) {
    // throw new CollectionOversizeException();
    // }

    // // リクエスト作成
    // List<ApiRequest> requestList = zipcodes
    // .stream()
    // .map(zipcode -> {
    // return new ApiRequest(zipcode);
    // })
    // .collection(Collectors.toList());
    // }

    /**
     * API 呼び出し
     */
    private ZipcodeResponse exchange(ZipcodeRequest requestParams) {

        log.info("[ZipCodeApiLogic] Request Parameters: {}", requestParams.toString());

        final String url = this.buildQueryUrl(requestParams);
        log.info("[ZipCodeApiLogic] Request URL: {}", url);

        RequestEntity<Void> request = RequestEntity.get(url, requestParams)
                .build();

        ResponseEntity<ZipcodeResponse> response = restTemplate().exchange(request, ZipcodeResponse.class);
        if (!Objects.equals(response.getStatusCode(), HttpStatus.OK)) {
            throw new ApiCallFailedException("HTTP ステータス 200 以外のレスポンスが返却されました");
        }

        ZipcodeResponse apiResponse = response.getBody();
        log.info("[ZipCodeApiLogic] Response Value: {}", apiResponse);

        // レスポンス 空チェック
        if (apiResponse.getStatus() == HttpStatus.OK.value()) {
            if (CollectionUtils.isNotEmpty(apiResponse.getResults())) {
                return apiResponse;
            }

            throw new ApiNoResponseException("レスポンスが空です");
        }

        // 入力パラメータエラー
        if (apiResponse.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            throw new HttpClientErrorException(
                    HttpStatus.valueOf(apiResponse.getStatus()),
                    apiResponse.getMassage());
        }
        // API内部エラー
        if (apiResponse.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            throw new HttpServerErrorException(
                    HttpStatus.valueOf(apiResponse.getStatus()),
                    apiResponse.getMassage());
        }

        throw new ApiCallFailedException("API呼び出しでエラーが発生しました");
    }

    /**
     * リクエストURL作成
     */
    private String buildQueryUrl(ZipcodeRequest requestParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        return builder
                .queryParam("zipcode", requestParams.getZipcode())
                .queryParam("limit", requestParams.getLimit())
                .toUriString();
    }
}
