package com.thorindev.util;

public enum CustomDyeColor {

    BLACK(0), //ink sack
    RED(1),
    GREEN(2),
    BROWN(3),
    BLUE(4), //lapis lazuli
    PURPLE(5),
    CYAN(6),
    LIGHT_GRAY(7),
    GRAY(8),
    PINK(9),
    LIME(10),
    YELLOW(11),
    LIGHT_BLUE(12),
    MAGENTA(13),
    ORANGE(14),
    WHITE(15); //bonemeal

    private byte data;
    CustomDyeColor(int i){
        this.data = (byte) i;
    }

    public byte getData(){
        return this.data;
    }

}
