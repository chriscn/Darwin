package io.github.chriscn.entity;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

import java.util.Random;

public class Firework {

    Random random = new Random();

    

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

}
