package entities;

import util.Coordinates;
import util.Sprite;

public class Grass extends  Entity {

    public Grass(Coordinates coordinates) {
        super(coordinates, Sprite.GRASS);
    }
}
