package entities;

import util.Coordinates;
import util.Speed;
import util.Sprite;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinate, int healthPoints, Speed speed) {
        super(coordinate, Sprite.HERBIVORE, healthPoints, speed);
    }

    @Override
    public void eat() {
        // to do
    }
}
