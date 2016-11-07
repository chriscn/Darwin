package com.thorindev.player;

import org.bukkit.entity.Player;

public class PlayerMisc {

    public void killPlayer(Player player) {
        if(player.getHealth() == 0) {
            //already dead?
        } else {
            player.setHealth(0);
        }
    }

}
