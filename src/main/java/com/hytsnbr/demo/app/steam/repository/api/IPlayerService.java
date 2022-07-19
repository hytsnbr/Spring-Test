package com.hytsnbr.demo.app.steam.repository.api;

import com.hytsnbr.demo.app.steam.model.api.i_steam_user.OwnedGames;

public interface IPlayerService {

    OwnedGames getOwnedGames(String steamId);

    OwnedGames getOwnedGames(String steamId, boolean isIncludeAppInfo, boolean isIncludePlayedFreeGames);

    OwnedGames clientGetLastPlayedTimes();

    // void getRecentlyPlayedGames(String steamId);
}
