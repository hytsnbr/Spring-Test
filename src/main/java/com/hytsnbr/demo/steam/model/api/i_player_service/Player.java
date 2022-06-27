package com.hytsnbr.demo.steam.model.api.i_player_service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Player {

    @JsonProperty("steamid")
    String steamId;

    @JsonProperty("communityVisibilityState")
    int communityVisibilityState;

    @JsonProperty("profileState")
    int profileState;

    @JsonProperty("personName")
    String personName;

    @JsonProperty("commentPermission")
    int commentPermission;

    @JsonProperty("profileUrl")
    String profileUrl;

    @JsonProperty("avatar")
    String avatar;

    @JsonProperty("avatarMedium")
    String avatarMedium;

    @JsonProperty("avatarFull")
    String avatarFull;

    @JsonProperty("avatarHash")
    String avatarHash;

    @JsonProperty("lastLogoff")
    long lastLogoff;

    @JsonProperty("personAState")
    int personAState;

    @JsonProperty("realName")
    String realName;

    @JsonProperty("primaryClanId")
    String primaryClanId;

    @JsonProperty("timeCreated")
    long timeCreated;

    @JsonProperty("personAStateFlags")
    int personAStateFlags;

    @JsonProperty("gameId")
    int gameId;

    @JsonProperty("gameServerIp")
    String gameServerIp;

    @JsonProperty("gameExtraInfo")
    String gameExtraInfo;

    @JsonProperty("locCountryCode")
    String locCountryCode;

    @JsonProperty("locStateCode")
    String locStateCode;

    @JsonProperty("locCityId")
    int locCityId;

    public LocalDate getLastLogoff() {
        return Instant.ofEpochSecond(this.lastLogoff)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public LocalDate getTimeCreated() {
        return Instant.ofEpochSecond(this.lastLogoff)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}