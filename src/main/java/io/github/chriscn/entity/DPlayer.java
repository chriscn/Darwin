package io.github.chriscn.entity;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class DPlayer implements Listener {

    public DPlayer() {
        Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager().getPlugins()[0]);
    }
}
