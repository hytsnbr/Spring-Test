package com.hytsnbr.demo.app.steam.repository.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hytsnbr.demo.app.steam.constant.SteamApiEndpoints;
import com.hytsnbr.demo.app.steam.model.api.i_player_service.PlayerSummaries;
import com.hytsnbr.demo.app.steam.model.api.i_steam_user.ResolveVanityURL;
import com.hytsnbr.demo.app.steam.repository.api.ISteamUser;
import com.hytsnbr.demo.config.property.ApiKey;
import com.hytsnbr.demo.config.property.ApiProperties;
import com.hytsnbr.demo.repository.ApiBaseLogic;

@Repository
public class ISteamUserImpl extends ApiBaseLogic implements ISteamUser {

    private final ApiKey apiKey;

    /**
     * コンストラクタ
     */
    public ISteamUserImpl(ApiProperties apiProperties, ApiKey apiKey) {
        super(apiProperties);

        this.apiKey = apiKey;
    }

    @Override
    public ResolveVanityURL resolveVanityURL(String userName) throws IllegalArgumentException {

        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey.getSteam());
        params.put("userName", userName);

        return restTemplate().getForObject(
                SteamApiEndpoints.GET_STEAM_ID,
                ResolveVanityURL.class,
                params);
    }

    @Override
    public PlayerSummaries getPlayerSummary(String steamId) {
        return getPlayerSummaries(List.of(steamId));
    }

    @Override
    public PlayerSummaries getPlayerSummaries(List<String> steamIds) {

        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey.getSteam());
        params.put("steamIds", String.join(",", steamIds));

        restTemplate().getForObject(
                SteamApiEndpoints.GET_PLAYER_SUMMARIES,
                ResolveVanityURL.class,
                params);

        return restTemplate().getForObject(
                SteamApiEndpoints.GET_PLAYER_SUMMARIES,
                PlayerSummaries.class,
                params);
    }
}
