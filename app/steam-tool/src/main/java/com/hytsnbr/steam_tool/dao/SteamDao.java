package com.hytsnbr.steam_tool.dao;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hytsnbr.steam_tool.dto.GetSupportedApiListResponse;

public final class SteamDao {
    
    private static final String URL = "https://api.steampowered.com/ISteamWebAPIUtil/GetSupportedAPIList/v1/?key={key}";
    
    private static final RestTemplate restTemplate;
    
    static {
        restTemplate = new RestTemplate();
    }
    
    private SteamDao() {
        throw new IllegalStateException("Utility class");
    }
    
    public static GetSupportedApiListResponse getSupportedApiList(String apiKey) {
        return restTemplate.getForObject(
            UriComponentsBuilder.fromHttpUrl(URL).build(apiKey),
            GetSupportedApiListResponse.class
        );
    }
}
