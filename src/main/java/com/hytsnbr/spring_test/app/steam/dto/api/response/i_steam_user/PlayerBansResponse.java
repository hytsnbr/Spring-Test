package com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class PlayerBansResponse {
    
    @JsonProperty("players")
    private Player players;
    
    @Data
    public static class Player {
        
        @JsonProperty("SteamId")
        private String steamId;
        
        @JsonProperty("CommunityBanned")
        private boolean communityBanned;
        
        @JsonProperty("VACBanned")
        private boolean vacBanned;
        
        @JsonProperty("NumberOfVACBans")
        private int numberOfVacBans;
        
        @JsonProperty("DaysSinceLastBan")
        private int daysSinceLastBan;
        
        @JsonProperty("NumberOfGameBans")
        private int numberOfGameBans;
        
        @JsonProperty("EconomyBan")
        private String economyBan;
    }
}
