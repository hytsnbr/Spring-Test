package com.hytsnbr.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.api.response.i_steam_user.Game;
import com.hytsnbr.service.SteamService;

@Slf4j
@RestController
@RequestMapping("/steam")
public class SteamIndexController {
    
    private final SteamService steamService;
    
    /**
     * コンストラクタ
     */
    SteamIndexController(SteamService steamService) {
        this.steamService = steamService;
    }
    
    @GetMapping
    public String index() {
        
        return "";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam(name = "userName") String userName) {
        
        if (StringUtils.isBlank(userName)) {
            return "";
        }
        
        List<Game> games = steamService.getUserOwnedGames(userName);
        return "";
    }
}
