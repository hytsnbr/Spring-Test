package com.hytsnbr.api.response.i_player_service;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.base_common.util.date.DateUtil;

@Data
public class PlayerSummariesResponse {
    
    @JsonProperty("players")
    private List<Player> players;
    
    @Data
    public static class Player {
        
        @JsonProperty("steamid")
        private String steamId;
        
        @JsonProperty("communityVisibilityState")
        private int communityVisibilityState;
        
        @JsonProperty("profileState")
        private int profileState;
        
        @JsonProperty("personName")
        private String personName;
        
        @JsonProperty("commentPermission")
        private int commentPermission;
        
        @JsonProperty("profileUrl")
        private String profileUrl;
        
        @JsonProperty("avatar")
        private String avatar;
        
        @JsonProperty("avatarMedium")
        private String avatarMedium;
        
        @JsonProperty("avatarFull")
        private String avatarFull;
        
        @JsonProperty("avatarHash")
        private String avatarHash;
        
        @JsonProperty("lastLogoff")
        private long lastLogoff;
        
        @JsonProperty("personAState")
        private int personAState;
        
        @JsonProperty("realName")
        private String realName;
        
        @JsonProperty("primaryClanId")
        private String primaryClanId;
        
        @JsonProperty("timeCreated")
        private long timeCreated;
        
        @JsonProperty("personAStateFlags")
        private int personAStateFlags;
        
        @JsonProperty("gameId")
        private int gameId;
        
        @JsonProperty("gameServerIp")
        private String gameServerIp;
        
        @JsonProperty("gameExtraInfo")
        private String gameExtraInfo;
        
        @JsonProperty("locCountryCode")
        private String locCountryCode;
        
        @JsonProperty("locStateCode")
        private String locStateCode;
        
        @JsonProperty("locCityId")
        private int locCityId;
        
        public LocalDate getLastLogoff() {
            return DateUtil.localDate().fromEpochTime(this.lastLogoff);
        }
        
        public LocalDate getTimeCreated() {
            return DateUtil.localDate().fromEpochTime(this.timeCreated);
        }
    }
}