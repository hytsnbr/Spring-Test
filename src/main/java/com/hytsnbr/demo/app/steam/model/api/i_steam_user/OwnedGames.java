package com.hytsnbr.demo.app.steam.model.api.i_steam_user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OwnedGames {

    @JsonProperty("response")
    private Response response;

    @Data
    public class Response {

        @JsonProperty("game_count")
        private int gameCount;

        @JsonProperty("games")
        private List<Game> games;
    }
}
