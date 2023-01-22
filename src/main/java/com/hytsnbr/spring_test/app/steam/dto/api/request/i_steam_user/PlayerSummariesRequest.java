package com.hytsnbr.spring_test.app.steam.dto.api.request.i_steam_user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.app.steam.dto.api.request.BaseRequest;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;

@Getter
@Setter
public class PlayerSummariesRequest extends BaseRequest {
    
    @JsonIgnore
    private List<String> steamIds;
    
    /**
     * コンストラクタ
     */
    public PlayerSummariesRequest(ApiKey apiKey) {
        super(apiKey);
    }
    
    @JsonProperty("steamIds")
    public String getSteamIds() {
        return String.join(",", this.steamIds);
    }
}