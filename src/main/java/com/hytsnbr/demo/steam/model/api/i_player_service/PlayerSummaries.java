package com.hytsnbr.demo.steam.model.api.i_player_service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PlayerSummaries {

    @JsonProperty("response")
    private Response response;

    @Data
    public class Response {

        @JsonProperty("players")
        private List<Player> players;
    }
}