package com.hytsnbr.demo.steam.model.api.i_steam_user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Game {

    @JsonProperty("appid")
    private int appId;

    @JsonProperty("name")
    private String name;

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
}
