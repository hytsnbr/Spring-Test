package com.hytsnbr.steam.dao;

import java.util.Collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.base_common.config.property.ApiProperties;
import com.hytsnbr.steam.api.request.i_steam_user.FriendListRequest;
import com.hytsnbr.steam.api.request.i_steam_user.PlayerBansRequest;
import com.hytsnbr.steam.api.request.i_steam_user.PlayerSummariesRequest;
import com.hytsnbr.steam.api.request.i_steam_user.ResolveVanityURLRequest;
import com.hytsnbr.steam.dao.impl.SteamUserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class ISteamUserTest {
    
    private static AutoCloseable closeable;
    
    @Autowired
    ApiProperties apiProperties;
    
    @Autowired
    ApiKey apiKey;
    
    private SteamUserRepository steamUserRepository;
    
    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        
        this.steamUserRepository = new SteamUserRepository(apiProperties, apiKey);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }
    
    @Test
    @DisplayName("SteamIDを取得_成功")
    void getSteamId_Success() {
        final String expected = "76561198795659001";
        
        ResolveVanityURLRequest request = new ResolveVanityURLRequest(apiKey);
        request.setUserName("hytsnbr10519");
        final String actual = steamUserRepository.resolveVanityURL(request).getSteamId();
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("SteamIDを取得_失敗")
    void getSteamId_Fail() {
        final String expected = "76561198795659001";
        
        ResolveVanityURLRequest request = new ResolveVanityURLRequest(apiKey);
        request.setUserName("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        final String actual = steamUserRepository.resolveVanityURL(request).getSteamId();
        
        assertNotEquals(expected, actual);
    }
    
    @Test
    void getFriendsList() {
        final String testSteamId = "76561198795659001";
        
        FriendListRequest request = new FriendListRequest(apiKey);
        request.setSteamId(testSteamId);
        final var actual = steamUserRepository.getFriendList(request);
        
        System.out.println();
    }
    
    @Test
    void getPlayerSummaries() {
        final String testSteamId = "76561198795659001";
        
        PlayerSummariesRequest request = new PlayerSummariesRequest(apiKey);
        request.setSteamIds(Collections.singletonList(testSteamId));
        final var actual = steamUserRepository.getPlayerSummaries(request);
        
        System.out.println();
    }
    
    @Test
    void getPlayerBans() {
        
        PlayerBansRequest request = new PlayerBansRequest(apiKey);
        //        request.
    }
}