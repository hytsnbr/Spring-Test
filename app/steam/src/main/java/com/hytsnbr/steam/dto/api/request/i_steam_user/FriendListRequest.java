package com.hytsnbr.steam.dto.api.request.i_steam_user;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.steam.dto.api.request.BaseRequest;

@Getter
@Setter
public class FriendListRequest extends BaseRequest {
    
    @JsonProperty("steamid")
    private String steamId;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("relationship")
    private String relationship;
    
    /**
     * コンストラクタ
     */
    public FriendListRequest(ApiKey apiKey) {
        super(apiKey);
    }
}
