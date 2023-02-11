package com.hytsnbr.steam.dao.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.hytsnbr.spring_test.base_common.config.property.ApiKey;
import com.hytsnbr.spring_test.base_common.config.property.ApiProperties;
import com.hytsnbr.spring_test.base_common.exception.api.ApiNoResponseException;
import com.hytsnbr.steam.constant.SteamApiEndpoints;
import com.hytsnbr.steam.dao.IPlayerService;
import com.hytsnbr.steam.dao.SteamApiRepository;
import com.hytsnbr.steam.dto.api.request.i_player_service.AnimatedAvatarRequest;
import com.hytsnbr.steam.dto.api.request.i_player_service.AvatarFrameRequest;
import com.hytsnbr.steam.dto.api.request.i_player_service.BadgesRequest;
import com.hytsnbr.steam.dto.api.request.i_player_service.ClientGetLastPlayedTimesRequest;
import com.hytsnbr.steam.dto.api.request.i_player_service.CommunityBadgeProgressRequest;
import com.hytsnbr.steam.dto.api.request.i_player_service.OwnedGamesRequest;
import com.hytsnbr.steam.dto.api.request.i_player_service.RecentlyPlayedGamesRequest;
import com.hytsnbr.steam.dto.api.response.i_player_service.AnimatedAvatarResponse;
import com.hytsnbr.steam.dto.api.response.i_player_service.AvatarFrameResponse;
import com.hytsnbr.steam.dto.api.response.i_player_service.BadgesResponse;
import com.hytsnbr.steam.dto.api.response.i_player_service.ClientGetLastPlayedTimesResponse;
import com.hytsnbr.steam.dto.api.response.i_player_service.CommunityBadgeProgress;
import com.hytsnbr.steam.dto.api.response.i_player_service.RecentlyPlayedGamesResponse;
import com.hytsnbr.steam.dto.api.response.i_steam_user.OwnedGamesResponse;
import com.hytsnbr.steam.dto.api.response.i_steam_user.OwnedGamesResponse.OwnedGames;

@Repository
public class PlayerServiceRepository extends SteamApiRepository implements IPlayerService {
    
    private final ApiKey apiKey;
    
    /**
     * コンストラクタ
     */
    public PlayerServiceRepository(ApiProperties apiProperties, ApiKey apiKey) {
        super(apiProperties, apiKey);
        
        this.apiKey = apiKey;
    }
    
    public OwnedGames getOwnedGames(String steamId) {
        OwnedGamesRequest request = new OwnedGamesRequest(this.apiKey);
        request.setSteamId(List.of(steamId));
        
        return getOwnedGames(request);
    }
    
    @Override
    public OwnedGames getOwnedGames(OwnedGamesRequest request) {
        OwnedGamesResponse response = getRequest(SteamApiEndpoints.GET_PLAYER_OWNED_GAMES, request,
            OwnedGamesResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response.getOwnedGames();
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public ClientGetLastPlayedTimesResponse clientGetLastPlayedTimes(ClientGetLastPlayedTimesRequest request) {
        ClientGetLastPlayedTimesResponse response = getRequest(SteamApiEndpoints.CLIENT_GET_LAST_PLAYED_TIMES, request,
            ClientGetLastPlayedTimesResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public AnimatedAvatarResponse getAnimatedAvatar(AnimatedAvatarRequest request) {
        AnimatedAvatarResponse response = getRequest(SteamApiEndpoints.GET_ANIMATED_AVATAR, request,
            AnimatedAvatarResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public AvatarFrameResponse getAvatarFrame(AvatarFrameRequest request) {
        AvatarFrameResponse response = getRequest(SteamApiEndpoints.GET_AVATAR_FRAME, request,
            AvatarFrameResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public BadgesResponse getBadges(BadgesRequest request) {
        BadgesResponse response = getRequest(SteamApiEndpoints.GET_BADGES, request,
            BadgesResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public CommunityBadgeProgress getCommunityBadgeProgress(CommunityBadgeProgressRequest request) {
        CommunityBadgeProgress response = getRequest(SteamApiEndpoints.GET_COMMUNITY_BADGE_PROGRESS, request,
            CommunityBadgeProgress.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
    
    @Override
    public RecentlyPlayedGamesResponse getRecentlyPlayedGames(RecentlyPlayedGamesRequest request) {
        RecentlyPlayedGamesResponse response = getRequest(SteamApiEndpoints.GET_RECENTLY_PLAYED_GAMES, request,
            RecentlyPlayedGamesResponse.class
        );
        
        if (Objects.nonNull(response)) {
            return response;
        }
        
        throw new ApiNoResponseException();
    }
}
