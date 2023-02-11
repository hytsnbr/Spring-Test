package com.hytsnbr.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.api.request.BaseRequest;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;

@Getter
@Setter
public class RecentlyPlayedGamesRequest extends BaseRequest {
    
    @JsonProperty("steamid")
    private String steamId;
    
    @JsonProperty("count")
    private int count = 0;
    
    /**
     * コンストラクタ
     *
     * @param apiKey
     */
    public RecentlyPlayedGamesRequest(ApiKey apiKey) {
        super(apiKey);
    }
}
