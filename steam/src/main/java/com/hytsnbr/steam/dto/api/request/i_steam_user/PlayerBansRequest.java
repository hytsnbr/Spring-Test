package com.hytsnbr.steam.dto.api.request.i_steam_user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;
import com.hytsnbr.steam.dto.api.request.BaseRequest;

@Getter
@Setter
public class PlayerBansRequest extends BaseRequest {
    
    @JsonIgnore
    private List<String> steamIds;
    
    /**
     * コンストラクタ
     *
     * @param apiKey
     */
    public PlayerBansRequest(ApiKey apiKey) {
        super(apiKey);
    }
    
    @JsonProperty("steamIds")
    public String getSteamIds() {
        return String.join(",", this.steamIds);
    }
}
