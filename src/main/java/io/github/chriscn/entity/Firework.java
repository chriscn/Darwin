package io.github.chriscn.entity;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Player;

import java.util.Random;

public class Firework {

    Random random = new Random();

    /**
     * @name spawnFirework - spawns a firework at player with given types and colors.
     * @param player The player you would like to spawn it at
     * @param flicker If you want the firework to flicker
     * @param c1 The first firework colour
     * @param c2 The second firework colour
     * @param t1 The firework type
     * @param trail If you want the firework to have a trail
     * @param p1 The amount of power
     */
    public void spawnFirework(Player player, boolean flicker, Color c1, Color c2, FireworkEffect.Type t1, boolean trail, int p1) {

    }

    /**
     * @name spawnRandomFirework - spawns a completely random firework at the player given.
     * @param player
     */
    public void spawnRandomFirework(Player player) {
        spawnFirework(player, randomBoolean(), getFWColor(), getFWColor(), getFWType(), randomBoolean(), getFWPower());
    }

    public Color getFWColor() {
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
                Color.YELLOW,
        };
        int i = random.nextInt(listOfColors.length);
        c = listOfColors[i];
        return c;
    }

    public FireworkEffect.Type getFWType() {
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

    public int getFWPower() {
        return random.nextInt(128);
    }

    public boolean randomBoolean() {
        return random.nextBoolean();
    }

}
