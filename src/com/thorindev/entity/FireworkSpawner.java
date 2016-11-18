package com.thorindev.entity;

import com.thorindev.util.darwinarrays;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class FireworkSpawner {

    Random random = new Random();
    darwinarrays darwinarrays = new darwinarrays();


    public void spawnFirework(Player player, boolean flicker, Color c1, Color c2, FireworkEffect.Type t1, boolean trail, int p1) {
        Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        FireworkEffect effect = FireworkEffect.builder()
                .flicker(flicker)
                .withColor(c1)
                .withFade(c2)
                .with(t1)
                .trail(trail)
                .build();
        fwm.setPower(p1);

        fw.setFireworkMeta(fwm);
    }

    public void spawnRandomFirework(Player player) {
        Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        FireworkEffect.Type t1 = darwinarrays.getType();
        Color c1 = darwinarrays.getColor();
        Color c2 = darwinarrays.getColor();
        int p1 = darwinarrays.getPower();

        FireworkEffect effect = FireworkEffect.builder()
                .flicker(random.nextBoolean())
                .withColor(c1)
                .withFade(c2)
                .with(t1)
                .trail(random.nextBoolean())
                .build();
        fwm.setPower(p1);

        fw.setFireworkMeta(fwm);

    }

    public void spawnAbsoluteFirework(Location loc, boolean flicker, Color c1, Color c2, FireworkEffect.Type t1, boolean trail, int p1) {
        World w = loc.getWorld();
        Firework fw = (Firework) w.spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        FireworkEffect effect = FireworkEffect.builder()
                .flicker(flicker)
                .withColor(c1)
                .withFade(c2)
                .with(t1)
                .trail(trail)
                .build();
        fwm.setPower(p1);

        fw.setFireworkMeta(fwm);
    }

    public void spawnAbsoluteRandomFirework(Location loc) {
        World w = loc.getWorld();
        Firework fw = (Firework) w.spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        FireworkEffect.Type t1 = darwinarrays.getType();
        Color c1 = darwinarrays.getColor();
        Color c2 = darwinarrays.getColor();
        int p1 = darwinarrays.getPower();

        FireworkEffect effect = FireworkEffect.builder()
                .flicker(random.nextBoolean())
                .withColor(c1)
                .withFade(c2)
                .with(t1)
                .trail(random.nextBoolean())
                .build();
        fwm.setPower(p1);

        fw.setFireworkMeta(fwm);
    }

}