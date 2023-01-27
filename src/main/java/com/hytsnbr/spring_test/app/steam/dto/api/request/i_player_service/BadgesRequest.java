package com.hytsnbr.spring_test.app.steam.dto.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.app.steam.dto.api.request.BaseRequest;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;

@Getter
@Setter
public class BadgesRequest extends BaseRequest {
    
    @JsonProperty("steamid")
    private String steamId;
    
    /**
     * コンストラクタ
     *
     * @param apiKey
     */
    public BadgesRequest(ApiKey apiKey) {
        super(apiKey);
    }
}
