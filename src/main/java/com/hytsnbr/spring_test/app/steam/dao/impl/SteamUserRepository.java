package com.hytsnbr.spring_test.app.steam.dao.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.hytsnbr.spring_test.app.steam.constant.SteamApiEndpoints;
import com.hytsnbr.spring_test.app.steam.dao.ISteamUser;
import com.hytsnbr.spring_test.app.steam.dao.SteamApiRepository;
import com.hytsnbr.spring_test.app.steam.dto.api.request.i_steam_user.FriendListRequest;
import com.hytsnbr.spring_test.app.steam.dto.api.request.i_steam_user.PlayerBansRequest;
import com.hytsnbr.spring_test.app.steam.dto.api.request.i_steam_user.PlayerSummariesRequest;
import com.hytsnbr.spring_test.app.steam.dto.api.request.i_steam_user.ResolveVanityURLRequest;
import com.hytsnbr.spring_test.app.steam.dto.api.response.i_player_service.PlayerSummariesResponse;
import com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user.FriendListResponse;
import com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user.PlayerBansResponse;
import com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user.ResolveVanityURLResponse;
import com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user.ResolveVanityURLResponse.ResolveVanityURL;
import com.hytsnbr.spring_test.config.property.ApiKey;
import com.hytsnbr.spring_test.config.property.ApiProperties;
import com.hytsnbr.spring_test.exception.api.ApiNoResponseException;

@Repository
public class SteamUserRepository extends SteamApiRepository implements ISteamUser {
    
    private final ApiKey apiKey;
    
    /**
     * コンストラクタ
     */
    public SteamUserRepository(ApiProperties apiProperties, ApiKey apiKey) {
        super(apiProperties, apiKey);
        
        this.apiKey = apiKey;
    }
    
    @Override
    public ResolveVanityURL resolveVanityURL(ResolveVanityURLRequest request) {
        ResolveVanityURLResponse response = getRequest(SteamApiEndpoints.GET_STEAM_ID, request,
            ResolveVanityURLResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response.getResolveVanityURL();
        }
        
        throw new ApiNoResponseException();
    }
    
    public PlayerSummariesResponse getPlayerSummary(String steamId) {
        PlayerSummariesRequest request = new PlayerSummariesRequest(this.apiKey);
        request.setSteamIds(List.of(steamId));
        
        return getPlayerSummaries(request);
    }
    
    @Override
    public PlayerSummariesResponse getPlayerSummaries(PlayerSummariesRequest request) {
        PlayerSummariesResponse response = getRequest(SteamApiEndpoints.GET_PLAYER_SUMMARIES, request,
            PlayerSummariesResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public FriendListResponse getFriendList(FriendListRequest request) {
        FriendListResponse response = getRequest(SteamApiEndpoints.GET_FRIEND_LIST, request,
            FriendListResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public PlayerBansResponse getPlayerBans(PlayerBansRequest request) {
        PlayerBansResponse response = getRequest(SteamApiEndpoints.GET_PLAYER_BANS, request,
            PlayerBansResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
}
