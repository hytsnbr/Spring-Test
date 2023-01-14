package com.hytsnbr.spring_test.app.steam.dto.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.app.steam.dto.api.request.BaseRequest;
import com.hytsnbr.spring_test.config.property.ApiKey;

@Getter
@Setter
public class AnimatedAvatarRequest extends BaseRequest {
    
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
    public AnimatedAvatarRequest(ApiKey apiKey) {
        super(apiKey);
    }
}
