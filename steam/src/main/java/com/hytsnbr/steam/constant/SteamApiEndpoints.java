package com.hytsnbr.steam.constant;

/**
 * Steam API Endpoints
 */
public final class SteamApiEndpoints {
    
    public static final String I_STEAM_USER = "https://api.steampowered.com/ISteamUser";
    
    //-----------------------------------------------------------------------------------------
    
    public static final String I_PLAYER_SERVICE = "https://api.steampowered.com/IPlayerService";
    
    public static final String GET_STEAM_ID = "https://api.steampowered.com/ISteamUser/ResolveVanityURL/v1/";
    
    //-----------------------------------------------------------------------------------------
    
    public static final String GET_PLAYER_SUMMARIES = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/";
    
    public static final String GET_PLAYER_OWNED_GAMES = "https://api.steampowered.com/IPlayerService/GetOwnedGames/v1/";
    
    public static final String GET_FRIEND_LIST = "https://api.steampowered.com/ISteamUser/GetFriendList/v1/";
    
    public static final String GET_PLAYER_BANS = "https://api.steampowered.com/ISteamUser/GetPlayerBans/v1/";
    
    //-----------------------------------------------------------------------------------------
    
    public static final String CLIENT_GET_LAST_PLAYED_TIMES = "https://api.steampowered.com/IPlayerService/ClientGetLastPlayedTimes/v1/";
    
    public static final String GET_RECENTLY_PLAYED_GAMES = "https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1/";
    
    public static final String GET_ANIMATED_AVATAR = "https://api.steampowered.com/IPlayerService/GetAnimatedAvatar/v1/";
    
    public static final String GET_AVATAR_FRAME = "https://api.steampowered.com/IPlayerService/GetAvatarFrame/v1/";
    
    public static final String GET_BADGES = "https://api.steampowered.com/IPlayerService/GetBadges/v1/";
    
    public static final String GET_COMMUNITY_BADGE_PROGRESS = "https://api.steampowered.com/IPlayerService/GetCommunityBadgeProgress/v1/";
    
    /**
     * コンストラクタ
     */
    private SteamApiEndpoints() {
        throw new IllegalStateException("Utility class");
    }
}
