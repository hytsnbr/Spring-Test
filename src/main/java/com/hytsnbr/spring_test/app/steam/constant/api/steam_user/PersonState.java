package com.hytsnbr.spring_test.app.steam.constant.api.steam_user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PersonState {
    
    /**
     * OFFLINE
     */
    OFFLINE(0),
    /**
     * ONLINE
     */
    ONLINE(1),
    /**
     * BUSY
     */
    BUSY(2),
    /**
     * AWAY
     */
    AWAY(3),
    /**
     * SNOOZE
     */
    SNOOZE(4),
    /**
     * LOOKING_TO_TRADE
     */
    LOOKING_TO_TRADE(5),
    /**
     * LOOKING_TO_PLAY
     */
    LOOKING_TO_PLAY(6);
    
    final int value;
}