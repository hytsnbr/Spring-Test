package com.hytsnbr.steam_tool.dao;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hytsnbr.steam_tool.dto.GetSupportedApiListResponse;

public final class SteamDao {
    
    private static final String URL = "https://api.steampowered.com/ISteamWebAPIUtil/GetSupportedAPIList/v1/?key={key}";
    
    private static final String STEAM_API_KEY = "4B4CA2713423B757D13ADAFE82C94D9D";
    
    private static final RestTemplate restTemplate;
    
    static {
        restTemplate = new RestTemplate();
    }
    
    private SteamDao() {}
    
    public static GetSupportedApiListResponse getSupportedApiList() {
        return restTemplate.getForObject(
            UriComponentsBuilder.fromHttpUrl(URL).build(STEAM_API_KEY),
            GetSupportedApiListResponse.class
        );
    }
}
