package io.github.chriscn.util;

public enum DyeColor {

    BLACK(0),
    RED(1),
    GREEN(2),
    BROWN(3),
    BLUE(4),
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
    WHITE(15);

    private byte data;

    DyeColor(int i) {
        this.data = (byte) i;
    }

    public byte getColor() {
        return this.data;
    }

}
