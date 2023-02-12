package com.hytsnbr.steam.api.request.i_player_service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.steam.api.request.BaseRequest;

@Getter
@Setter
public class OwnedGamesRequest extends BaseRequest {
    
    @JsonProperty("steamId")
    private List<String> steamId;
    
    @JsonProperty("include_appinfo")
    private boolean includeAppInfo;
    
    @JsonProperty("include_played_free_games")
    private boolean includePlayedFreeGames;
    
    /**
     * コンストラクタ
     */
    public OwnedGamesRequest(ApiKey apiKey) {
        super(apiKey);
    }
    
    public String getIncludeAppInfo() {
        return bool2StrBin(this.includeAppInfo);
    }
    
    public String getIncludePlayedFreeGames() {
        return bool2StrBin(this.includePlayedFreeGames);
    }
    
    public void setSteamId(String steamId) {
        this.steamId = List.of(steamId);
    }
    
    public void setSteamId(List<String> steamIds) {
        this.steamId = steamIds;
    }
}