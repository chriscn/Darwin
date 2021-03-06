package com.thorindev.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class Vanish implements Listener {

    private ArrayList<Player> vanished = new ArrayList<Player>();

    public Vanish() {
        Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager().getPlugins()[0]);
    }

    public void VanishPlayer(Player player) {
        for (Player toHide : Bukkit.getServer().getOnlinePlayers()) {
            toHide.hidePlayer(player);
        }
        vanished.add(player);
    }

    public void unVanishPlayer(Player player) {
        for (Player toShow : Bukkit.getServer().getOnlinePlayers()) {
            toShow.showPlayer(player);
        }
        vanished.remove(player);
    }

    @EventHandler
    public void onPlayerJoinVanish(PlayerJoinEvent event) {
        for(Player player : vanished) {
            event.getPlayer().hidePlayer(player);
        }
    }

    @EventHandler
    public void onPlayerQuitVanish(PlayerQuitEvent event) {
        if(vanished.contains(event.getPlayer())) {
            vanished.remove(event.getPlayer());
        }
    }

    public ArrayList getVanish() {
        ArrayList<Player> vanish = new ArrayList<>();
        for(Player player : vanished) {
            vanish.add(player);
        }
        return vanish;
    }

}