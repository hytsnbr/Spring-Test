package com.hytsnbr.demo.app.steam.repository.api;

import java.util.List;

import com.hytsnbr.demo.app.steam.model.api.i_player_service.PlayerSummaries;
import com.hytsnbr.demo.app.steam.model.api.i_steam_user.ResolveVanityURL;

public interface ISteamUser {

    ResolveVanityURL resolveVanityURL(final String userName);

    PlayerSummaries getPlayerSummary(String steamId);

    PlayerSummaries getPlayerSummaries(List<String> steamIds);
}
