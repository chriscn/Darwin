package com.thorindev.player;

import org.bukkit.entity.Player;

public class PlayerSurvival {

    public void healPlayer(Player player) {
        player.setHealth(20);
    }

    public void killPlayer(Player player) {
        player.setHealth(0);
    }

    public void feedPlayer(Player player) {
        player.setFoodLevel(15);
    }

    public void starvePlayer(Player player) {
        player.setFoodLevel(0);
    }

}
