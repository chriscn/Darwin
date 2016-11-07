package com.thorindev.entity;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class FireworkAPI {

    Random random = new Random();

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
        FireworkEffect.Type t1 = getType();
        Color c1 = getColor();
        Color c2 = getColor();
        int p1 = getPower();

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
        FireworkEffect.Type t1 = getType();
        Color c1 = getColor();
        Color c2 = getColor();
        int p1 = getPower();

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

    private Color getColor() {
        Color c;
        Color[] listOfColors = {
                Color.AQUA,
                Color.BLACK,
                Color.BLUE,
                Color.FUCHSIA,
                Color.GREEN,
                Color.GRAY,
                Color.LIME,
                Color.MAROON,
                Color.NAVY,
                Color.OLIVE,
                Color.ORANGE,
                Color.PURPLE,
                Color.RED,
                Color.SILVER,
                Color.TEAL,
                Color.WHITE,
                Color.YELLOW
        };
        int i = random.nextInt(listOfColors.length);
        c = listOfColors[i];
        return c;
    }

    private FireworkEffect.Type getType() {
        FireworkEffect.Type t;
        FireworkEffect.Type[] listOfTypes = {
                FireworkEffect.Type.BALL,
                FireworkEffect.Type.BALL_LARGE,
                FireworkEffect.Type.BURST,
                FireworkEffect.Type.CREEPER,
                FireworkEffect.Type.STAR,
        };
        int i = random.nextInt(listOfTypes.length);
        t = listOfTypes[i];
        return t;
    }

    private int getPower() {
        return random.nextInt(1-128);
    }

}