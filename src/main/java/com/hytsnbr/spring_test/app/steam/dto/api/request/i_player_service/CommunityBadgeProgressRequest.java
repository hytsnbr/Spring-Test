package com.hytsnbr.spring_test.app.steam.dto.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.app.steam.dto.api.request.BaseRequest;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;

@Getter
@Setter
public class CommunityBadgeProgressRequest extends BaseRequest {
    
    @JsonProperty("steamid")
    private String steamId;
    
    @JsonProperty("badgeid")
    private String badgeId;
    
    /**
     * コンストラクタ
     *
     * @param apiKey
     */
    public CommunityBadgeProgressRequest(ApiKey apiKey) {
        super(apiKey);
    }
}
