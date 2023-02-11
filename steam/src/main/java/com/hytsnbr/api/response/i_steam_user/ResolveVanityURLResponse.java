package com.hytsnbr.api.response.i_steam_user;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class ResolveVanityURLResponse {
    
    @JsonProperty("response")
    private ResolveVanityURL resolveVanityURL;
    
    @Data
    public static class ResolveVanityURL {
        
        @JsonIgnore
        private final int successCode = 1;
        
        @JsonIgnore
        private final int failureCode = 42;
        
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
