package com.hytsnbr.spring_test.app.steam.dao;

import com.hytsnbr.spring_test.app.steam.dto.api.request.i_player_service.*;
import com.hytsnbr.spring_test.app.steam.dto.api.response.i_player_service.*;
import com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user.OwnedGamesResponse.OwnedGames;

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
