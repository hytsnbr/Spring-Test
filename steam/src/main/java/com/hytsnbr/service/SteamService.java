package com.hytsnbr.service;

import java.util.List;

import com.hytsnbr.api.response.i_steam_user.Game;

public interface SteamService {
    
    String getSteamId(String steamUserName);
    
    List<Game> getUserOwnedGames(String steamUserName);
}