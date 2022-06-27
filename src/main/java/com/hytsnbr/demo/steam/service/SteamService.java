package com.hytsnbr.demo.steam.service;

import java.util.List;

import com.hytsnbr.demo.steam.model.api.i_steam_user.Game;

public interface SteamService {

    String getSteamId(String steamUserName);

    List<Game> getUserOwnedGames(String steamUserName);
}