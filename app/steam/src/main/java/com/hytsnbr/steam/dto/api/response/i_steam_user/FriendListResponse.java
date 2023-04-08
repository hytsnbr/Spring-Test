package com.hytsnbr.steam.dto.api.response.i_steam_user;

import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class FriendListResponse {
    
    @JsonProperty("friendslist")
    private FriendsList friendsList;
    
    @Data
    public static class FriendsList {
        
        @JsonProperty("friends")
        private List<Friend> friends;
    }
    
    @Data
    public static class Friend {
        
        @JsonProperty("steamid")
        private String steamId;
        
        @JsonProperty("relationship")
        private String relationship;
        
        @JsonProperty("friend_since")
        private long friendSince;
    }
}
