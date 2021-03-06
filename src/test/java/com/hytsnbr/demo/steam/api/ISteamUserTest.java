package com.hytsnbr.demo.steam.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hytsnbr.demo.app.steam.repository.api.ISteamUser;
import com.hytsnbr.demo.app.steam.repository.api.impl.ISteamUserImpl;
import com.hytsnbr.demo.config.property.ApiKey;
import com.hytsnbr.demo.config.property.ApiProperties;

@SpringBootTest
class ISteamUserTest {

    @Autowired
    ApiProperties apiProperties;

    @Autowired
    ApiKey apiKey;

    private ISteamUser iSteamUser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        this.iSteamUser = new ISteamUserImpl(apiProperties, apiKey);
    }

    @Test
    @DisplayName("SteamIDを取得")
    void SteamIDを取得() {
        String expected = "76561198795659001";
        String actual = iSteamUser.resolveVanityURL("hytsnbr10519").getResponse().getSteamId();

        assertEquals(expected, actual);
    }

    @Test
    void test() {
    }
}