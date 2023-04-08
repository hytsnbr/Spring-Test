package com.hytsnbr.steam.dto.api.response.i_steam_user;

import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class OwnedGamesResponse {
    
    @JsonProperty("response")
    private OwnedGames ownedGames;
    
    @Data
    public static class OwnedGames {
        
        @JsonProperty("game_count")
        private int gameCount;
        
        @JsonProperty("games")
        private List<Game> games;
    }
}
