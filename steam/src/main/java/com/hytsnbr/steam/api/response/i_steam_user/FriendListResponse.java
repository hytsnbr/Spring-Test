package com.hytsnbr.steam.api.response.i_steam_user;

import lombok.Data;

import java.util.List;

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
