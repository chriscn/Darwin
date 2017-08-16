package io.github.chriscn.entity;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class DFirework {

    Random random = new Random();

    /**
     * @name spawnFirework - spawns a firework at the location with given types and colors.
     * @param loc
     * @param flicker
     * @param c1
     * @param c2
     * @param t1
     * @param trail
     * @param p1
     */
    public void spawnFirework(Location loc, boolean flicker, Color c1, Color c2, FireworkEffect.Type t1, boolean trail, int p1) {
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
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
        spawnFirework(player.getLocation(), flicker, c1, c2, t1, trail, p1);
    }

    /**
     * @name spawnRandomFirework - spawns a completely random firework at the player given.
     * @param player The player you would like to spawn it at
     */
    public void spawnRandomFirework(Player player) {
        spawnFirework(player, randomBoolean(), getFWColor(), getFWColor(), getFWType(), randomBoolean(), getFWPower());
    }

    /**
     * @name spawnRandomFirework - spawns a completely random firework at the location given.
     * @param loc
     */
    public void spawnRandomFirework(Location loc) {
        spawnFirework(loc, randomBoolean(), getFWColor(), getFWColor(), getFWType(), randomBoolean(), getFWPower());
    }

    public Color getFWColor() {
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
        return listOfColors[random.nextInt(listOfColors.length)];
    }

    public FireworkEffect.Type getFWType() {
        FireworkEffect.Type[] listOfTypes = {
                FireworkEffect.Type.BALL,
                FireworkEffect.Type.BALL_LARGE,
                FireworkEffect.Type.BURST,
                FireworkEffect.Type.CREEPER,
                FireworkEffect.Type.STAR,
        };
        return listOfTypes[random.nextInt(listOfTypes.length)];
    }

    public int getFWPower() {
        return random.nextInt(128);
    }

    public boolean randomBoolean() {
        return random.nextBoolean();
    }

}
