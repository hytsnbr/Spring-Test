package com.hytsnbr.spring_test.app.steam.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hytsnbr.spring_test.app.steam.dao.impl.PlayerServiceRepository;
import com.hytsnbr.spring_test.config.property.ApiKey;
import com.hytsnbr.spring_test.config.property.ApiProperties;

@SpringBootTest
public class IPlayerServiceTest {
    
    @Autowired
    ApiProperties apiProperties;
    
    @Autowired
    ApiKey apiKey;
    
    private PlayerServiceRepository playerServiceRepository;
    
    private AutoCloseable closeable;
    
    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        
        this.playerServiceRepository = new PlayerServiceRepository(apiProperties, apiKey);
    }
    
    @BeforeAll
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
