package com.hytsnbr.demo.steam.repository.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hytsnbr.demo.logic.ApiBaseLogic;
import com.hytsnbr.demo.property.ApiKey;
import com.hytsnbr.demo.property.ApiProperties;
import com.hytsnbr.demo.steam.constant.SteamApiEndpoints;
import com.hytsnbr.demo.steam.model.api.i_steam_user.OwnedGames;
import com.hytsnbr.demo.steam.repository.api.IPlayerService;

@Repository
public class IPlayerServiceImpl extends ApiBaseLogic implements IPlayerService {

    private final ApiKey apiKey;

    /**
     * コンストラクタ
     */
    public IPlayerServiceImpl(ApiProperties apiProperties, ApiKey apiKey) {
        super(apiProperties);

        this.apiKey = apiKey;
    }

    @Override
    public OwnedGames getOwnedGames(String steamId) {
        return getOwnedGames(steamId, false, false);
    }

    @Override
    public OwnedGames getOwnedGames(
            String steamId,
            boolean isIncludeAppInfo,
            boolean isIncludePlayedFreeGames) {

        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey.getSteam());
        params.put("steamId", steamId);
        params.put("include_appinfo", isIncludeAppInfo ? "1" : "0");
        params.put("include_played_free_games", isIncludePlayedFreeGames ? "1" : "0");

        return restTemplate().getForObject(
                SteamApiEndpoints.GET_PLAYER_OWNED_GAMES,
                OwnedGames.class,
                params);
    }

    @Override
    public OwnedGames clientGetLastPlayedTimes() {

        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey.getSteam());

        return restTemplate().getForObject(
                SteamApiEndpoints.CLIENT_GET_LAST_PLAYED_TIMES,
                OwnedGames.class,
                params);
    }
}
