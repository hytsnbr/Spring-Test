package com.hytsnbr.steam.dto.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;
import com.hytsnbr.steam.dto.api.request.BaseRequest;

@Getter
@Setter
public class AvatarFrameRequest extends BaseRequest {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("steamid")
    private String steamId;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("language")
    private String language;
    
    /**
     * コンストラクタ
     *
     * @param apiKey
     */
    public AvatarFrameRequest(ApiKey apiKey) {
        super(apiKey);
    }
}
