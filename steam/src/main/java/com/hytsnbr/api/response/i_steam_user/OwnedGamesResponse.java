package com.hytsnbr.api.response.i_steam_user;

import lombok.Data;

import java.util.List;

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
