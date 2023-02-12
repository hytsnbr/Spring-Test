package com.hytsnbr.steam.dto.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.steam.dto.api.request.BaseRequest;

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
