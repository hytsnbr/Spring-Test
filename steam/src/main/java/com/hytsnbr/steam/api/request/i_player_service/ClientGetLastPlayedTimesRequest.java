package com.hytsnbr.steam.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.steam.api.request.BaseRequest;

@Getter
@Setter
public class ClientGetLastPlayedTimesRequest extends BaseRequest {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("min_last_played")
    private Long minLasPlayed;
    
    /**
     * コンストラクタ
     *
     * @param apiKey
     */
    public ClientGetLastPlayedTimesRequest(ApiKey apiKey) {
        super(apiKey);
    }
}
