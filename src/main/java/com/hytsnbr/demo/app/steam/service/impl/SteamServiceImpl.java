package com.hytsnbr.demo.app.steam.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hytsnbr.demo.app.steam.model.api.i_steam_user.Game;
import com.hytsnbr.demo.app.steam.model.api.i_steam_user.OwnedGames;
import com.hytsnbr.demo.app.steam.model.api.i_steam_user.ResolveVanityURL;
import com.hytsnbr.demo.app.steam.repository.api.IPlayerService;
import com.hytsnbr.demo.app.steam.repository.api.ISteamUser;
import com.hytsnbr.demo.app.steam.service.SteamService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SteamServiceImpl implements SteamService {

    private final ISteamUser iSteamUser;
    private final IPlayerService iPlayerService;

    /**
     * コンストラクタ
     */
    public SteamServiceImpl(ISteamUser iSteamUser, IPlayerService iPlayerService) {
        this.iSteamUser = iSteamUser;
        this.iPlayerService = iPlayerService;
    }

    @Override
    public String getSteamId(String steamUserName) {

        if (StringUtils.isBlank(steamUserName)) {
            throw new IllegalArgumentException("Steamユーザー名が空です");
        }

        ResolveVanityURL result = iSteamUser.resolveVanityURL(
                steamUserName);
        if (result.getResponse().isSuccess()) {
            return result.getResponse().getSteamId();
        } else {
            return "";
        }
    }

    @Override
    public List<Game> getUserOwnedGames(String steamUserName) {

        if (StringUtils.isBlank(steamUserName)) {
            throw new IllegalArgumentException("Steamユーザー名が空です");
        }

        ResolveVanityURL resolveVanityURL = iSteamUser.resolveVanityURL(steamUserName);
        if (!resolveVanityURL.getResponse().isSuccess()) {
            return List.of();
        }

        String steamId = resolveVanityURL.getResponse().getSteamId();
        OwnedGames result = iPlayerService.getOwnedGames(steamId);
        log.info("所持ゲーム数：{}", result.getResponse().getGameCount());

        return result.getResponse().getGames();
    }
}