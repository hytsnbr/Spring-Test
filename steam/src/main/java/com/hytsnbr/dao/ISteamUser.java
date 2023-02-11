package com.hytsnbr.dao;

import com.hytsnbr.api.request.i_steam_user.FriendListRequest;
import com.hytsnbr.api.request.i_steam_user.PlayerBansRequest;
import com.hytsnbr.api.request.i_steam_user.PlayerSummariesRequest;
import com.hytsnbr.api.request.i_steam_user.ResolveVanityURLRequest;
import com.hytsnbr.api.response.i_player_service.PlayerSummariesResponse;
import com.hytsnbr.api.response.i_steam_user.FriendListResponse;
import com.hytsnbr.api.response.i_steam_user.PlayerBansResponse;
import com.hytsnbr.api.response.i_steam_user.ResolveVanityURLResponse.ResolveVanityURL;

public interface ISteamUser {
    
    /**
     * Steam ID 取得
     *
     * @param request
     *
     * @return
     */
    ResolveVanityURL resolveVanityURL(ResolveVanityURLRequest request);
    
    /**
     * ユーザー情報取得
     *
     * @param request
     *
     * @return
     */
    PlayerSummariesResponse getPlayerSummaries(PlayerSummariesRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    FriendListResponse getFriendList(FriendListRequest request);
    
    /**
     * @param request
     *
     * @return
     */
    PlayerBansResponse getPlayerBans(PlayerBansRequest request);
}
