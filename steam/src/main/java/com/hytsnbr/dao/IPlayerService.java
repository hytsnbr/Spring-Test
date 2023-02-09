package com.hytsnbr.dao;

import com.hytsnbr.api.request.i_player_service.AnimatedAvatarRequest;
import com.hytsnbr.api.request.i_player_service.AvatarFrameRequest;
import com.hytsnbr.api.request.i_player_service.BadgesRequest;
import com.hytsnbr.api.request.i_player_service.ClientGetLastPlayedTimesRequest;
import com.hytsnbr.api.request.i_player_service.CommunityBadgeProgressRequest;
import com.hytsnbr.api.request.i_player_service.OwnedGamesRequest;
import com.hytsnbr.api.request.i_player_service.RecentlyPlayedGamesRequest;
import com.hytsnbr.api.response.i_player_service.AnimatedAvatarResponse;
import com.hytsnbr.api.response.i_player_service.AvatarFrameResponse;
import com.hytsnbr.api.response.i_player_service.BadgesResponse;
import com.hytsnbr.api.response.i_player_service.ClientGetLastPlayedTimesResponse;
import com.hytsnbr.api.response.i_player_service.CommunityBadgeProgress;
import com.hytsnbr.api.response.i_player_service.RecentlyPlayedGamesResponse;
import com.hytsnbr.api.response.i_steam_user.OwnedGamesResponse.OwnedGames;

public interface IPlayerService {
    
    /**
     * @param request
     *
     * @return
     */
    OwnedGames getOwnedGames(OwnedGamesRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    ClientGetLastPlayedTimesResponse clientGetLastPlayedTimes(ClientGetLastPlayedTimesRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    AnimatedAvatarResponse getAnimatedAvatar(AnimatedAvatarRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    AvatarFrameResponse getAvatarFrame(AvatarFrameRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    BadgesResponse getBadges(BadgesRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    CommunityBadgeProgress getCommunityBadgeProgress(CommunityBadgeProgressRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    RecentlyPlayedGamesResponse getRecentlyPlayedGames(RecentlyPlayedGamesRequest request);
}
