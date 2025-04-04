package entities;

import util.Coordinates;
import util.Sprite;

public class Rock extends Entity {

    public Rock(Coordinates coordinates) {
        super(coordinates, Sprite.ROCK);
    }
}
