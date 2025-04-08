package util;

import java.util.Objects;

public class Coordinates {
    private final int posX;
    private final int posY;

    public static final int MIN_X = 0; //always null
    public static final int MIN_Y = 0;
    public static final int MAX_X = 10;
    public static final int MAX_Y = 10;


    public Coordinates(int posX, int posY) {
        this.posX = getCorrectCoordinate(posX, MIN_X, MAX_X);
        this.posY = getCorrectCoordinate(posY, MIN_Y, MAX_Y);
    }

    private int getCorrectCoordinate(int position, int minimum, int maximum) {
        return (position > maximum) ? (position % maximum) : (maximum + position) % maximum;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates that)) return false;
        return posX == that.posX && posY == that.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }
}
