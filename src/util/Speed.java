package util;

import java.util.Random;

public enum Speed {
    SLOW(1),
    MEDIUM(2),
    FAST(3);

    private final int speed;

    private static final Random speedRandomizer = new Random();


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
