package com.hytsnbr.steam.dto.api.request.i_steam_user;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.steam.dto.api.request.BaseRequest;

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