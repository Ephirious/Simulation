package util;

import java.util.Random;

public enum Speed {
    SLOW(1),
    MEDIUM(2),
    FAST(3);

    private static final Random speedRandomizer = new Random();

    private final int speed;

    Speed(int speed) {
        this.speed = speed;
    }

    public static Speed getRandomSpeed() {
        return values()[speedRandomizer.nextInt(Speed.values().length)];
    }

    public int getSpeed() {
        return speed;
    }
}
