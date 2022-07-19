package com.hytsnbr.demo.app.steam.controller;

import java.util.List;

import com.hytsnbr.demo.app.steam.model.api.i_steam_user.Game;
import com.hytsnbr.demo.app.steam.service.SteamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/steam")
public class SteamIndexController {

    // ===== View =====//
    private static final String VIEW_INDEX = "steam/index";

    private final SteamService steamService;

    /**
     * コンストラクタ
     */
    SteamIndexController(SteamService steamService) {
        this.steamService = steamService;
    }

    @GetMapping
    public String index(Model model) {

        return VIEW_INDEX;
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "userName") String userName, Model model) {

        if (StringUtils.isBlank(userName)) {
            return VIEW_INDEX;
        }

        List<Game> games = steamService.getUserOwnedGames(userName);
        model.addAttribute("games", games);

        return VIEW_INDEX;
    }
}
