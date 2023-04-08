package com.hytsnbr.steam.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hytsnbr.base_common.config.property.ApiKey;
import com.hytsnbr.base_common.config.property.ApiProperties;
import com.hytsnbr.steam.dao.impl.PlayerServiceRepository;

@SpringBootTest
public class IPlayerServiceTest {
    
    private static AutoCloseable closeable;
    
    @Autowired
    ApiProperties apiProperties;
    
    @Autowired
    ApiKey apiKey;
    
    private PlayerServiceRepository playerServiceRepository;
    
    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        
        this.playerServiceRepository = new PlayerServiceRepository(apiProperties, apiKey);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }
    
    @Test
    void getOwnedGames() {
        // TODO
    }
    
    @Test
    void clientGetLastPlayedTimes() {
        // TODO
    }
    
    @Test
    void getAnimatedAvatar() {
        // TODO
    }
    
    @Test
    void getAvatarFrame() {
        // TODO
    }
    
    @Test
    void getBadges() {
        // TODO
    }
    
    @Test
    void getCommunityBadgeProgress() {
        // TODO
    }
    
    @Test
    void getRecentlyPlayedGames() {
        // TODO
    }
}
