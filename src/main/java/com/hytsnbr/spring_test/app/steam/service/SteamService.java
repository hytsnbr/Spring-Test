package com.hytsnbr.spring_test.app.steam.service;

import java.util.List;

import com.hytsnbr.spring_test.app.steam.dto.api.response.i_steam_user.Game;

public interface SteamService {
    
    String getSteamId(String steamUserName);
    
    List<Game> getUserOwnedGames(String steamUserName);
}