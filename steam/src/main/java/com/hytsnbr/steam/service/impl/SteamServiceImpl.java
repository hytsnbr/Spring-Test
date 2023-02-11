package com.hytsnbr.steam.service.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hytsnbr.spring_test.base_common.config.property.ApiKey;
import com.hytsnbr.steam.dao.IPlayerService;
import com.hytsnbr.steam.dao.ISteamUser;
import com.hytsnbr.steam.dto.api.request.i_player_service.OwnedGamesRequest;
import com.hytsnbr.steam.dto.api.request.i_steam_user.ResolveVanityURLRequest;
import com.hytsnbr.steam.dto.api.response.i_steam_user.Game;
import com.hytsnbr.steam.dto.api.response.i_steam_user.OwnedGamesResponse.OwnedGames;
import com.hytsnbr.steam.dto.api.response.i_steam_user.ResolveVanityURLResponse.ResolveVanityURL;
import com.hytsnbr.steam.service.SteamService;

@Slf4j
@Service
public class SteamServiceImpl implements SteamService {
    
    private final ApiKey apiKey;
    
    private final ISteamUser iSteamUser;
    
    private final IPlayerService iPlayerService;
    
    /**
     * コンストラクタ
     */
    public SteamServiceImpl(ApiKey apiKey, ISteamUser iSteamUser, IPlayerService iPlayerService) {
        this.apiKey = apiKey;
        this.iSteamUser = iSteamUser;
        this.iPlayerService = iPlayerService;
    }
    
    @Override
    public String getSteamId(String steamUserName) {
        
        if (StringUtils.isBlank(steamUserName)) {
            throw new IllegalArgumentException("Steamユーザー名が空です");
        }
        
        ResolveVanityURLRequest request = new ResolveVanityURLRequest(apiKey);
        request.setUserName(steamUserName);
        
        ResolveVanityURL result = iSteamUser.resolveVanityURL(request);
        if (result.isSuccess()) {
            return result.getSteamId();
        } else {
            return "";
        }
    }
    
    @Override
    public List<Game> getUserOwnedGames(String steamUserName) {
        
        if (StringUtils.isBlank(steamUserName)) {
            throw new IllegalArgumentException("Steamユーザー名が空です");
        }
        
        ResolveVanityURLRequest resolveVanityURLRequest = new ResolveVanityURLRequest(apiKey);
        resolveVanityURLRequest.setUserName(steamUserName);
        
        ResolveVanityURL resolveVanityURL = iSteamUser.resolveVanityURL(resolveVanityURLRequest);
        if (!resolveVanityURL.isSuccess()) {
            return List.of();
        }
        
        OwnedGamesRequest ownedGamesRequest = new OwnedGamesRequest(apiKey);
        ownedGamesRequest.setSteamId(resolveVanityURL.getSteamId());
        
        OwnedGames result = iPlayerService.getOwnedGames(ownedGamesRequest);
        log.info("所持ゲーム数：{}", result.getGameCount());
        
        return result.getGames();
    }
}