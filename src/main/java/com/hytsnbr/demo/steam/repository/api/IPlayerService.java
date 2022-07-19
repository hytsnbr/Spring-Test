package com.hytsnbr.demo.steam.repository.api;

import com.hytsnbr.demo.steam.model.api.i_steam_user.OwnedGames;

public interface IPlayerService {

    OwnedGames getOwnedGames(String steamId);

    OwnedGames getOwnedGames(String steamId, boolean isIncludeAppInfo, boolean isIncludePlayedFreeGames);

    OwnedGames clientGetLastPlayedTimes();

    // void getRecentlyPlayedGames(String steamId);
}
