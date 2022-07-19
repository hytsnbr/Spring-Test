package com.hytsnbr.demo.steam.model.api.i_steam_user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResolveVanityURL {

    private final int successCode = 1;
    private final int failureCode = 42;

    @JsonProperty("response")
    private Response response;

    @Data
    public class Response {

        @JsonProperty("message")
        private String message;

        @JsonProperty("steamid")
        private String steamId;

        @JsonProperty("success")
        private int success;

        public boolean isSuccess() {
            return this.success == successCode;
        }
    }
}
