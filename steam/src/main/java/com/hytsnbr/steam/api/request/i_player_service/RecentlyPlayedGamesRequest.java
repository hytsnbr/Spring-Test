package com.hytsnbr.steam.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.steam.api.request.BaseRequest;

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
