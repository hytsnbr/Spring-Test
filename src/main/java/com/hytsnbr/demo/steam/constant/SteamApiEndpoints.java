package com.hytsnbr.demo.steam.constant;

/**
 * Steam API Endpoints
 */
public final class SteamApiEndpoints {

    public static final String GET_STEAM_ID = "https://api.steampowered.com/ISteamUser/ResolveVanityURL/v1/?key={key}&vanityurl={userName}";
    public static final String GET_PLAYER_SUMMARIES = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/?key={key}&steamids={steamids}";
    public static final String GET_PLAYER_OWNED_GAMES = "https://api.steampowered.com/IPlayerService/GetOwnedGames/v1/?key={key}&steamid={steamId}&include_appinfo={include_appinfo}&include_played_free_games={include_played_free_games}";
    public static final String CLIENT_GET_LAST_PLAYED_TIMES = "https://api.steampowered.com/IPlayerService/ClientGetLastPlayedTimes/v1/?key={key}";
    public static final String GET_RECENTLY_PLAYED_GAMES = "https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1/?key={key}&steamid={steamId}";

    private SteamApiEndpoints() {
        throw new IllegalStateException("Utility class");
    }
}
