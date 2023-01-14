package com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Game {
    
    @JsonProperty("appid")
    private int appId;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("playtime_2weeks")
    private int playtime2Weeks;
    
    @JsonProperty("playtime_forever")
    private int playtimeForever;
    
    @JsonProperty("img_icon_url")
    private String imgIconUrl;
    
    @JsonProperty("img_logo_url")
    private String imgLogoUrl;
    
    @JsonProperty("playtime_windows_forever")
    private int playtimeWindowsForever;
    
    @JsonProperty("playtime_mac_forever")
    private int playtimeMacForever;
    
    @JsonProperty("playtime_linux_forever")
    private int playtimeLinuxForever;
    
    @JsonProperty("rtime_last_played")
    private long rtimeLastPlayed;
    
    @JsonProperty("has_community_visible_stats")
    private boolean hasCommunityVisibleStats;
}
