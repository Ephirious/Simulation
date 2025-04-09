package entities;

import util.Coordinates;
import util.Damage;
import util.Speed;
import util.Sprite;

public class Predator extends Creature {
    private final Damage damage;

    public Predator(Coordinates coordinate, int healthPoints, Speed speed, Damage damage) {
        super(coordinate, Sprite.PREDATOR, healthPoints, speed);
        this.damage = damage;
    }

    @Override
    public void eat() {
        // to do
    }
}