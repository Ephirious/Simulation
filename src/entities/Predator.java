package entities;

import coordinates.Coordinates;
import util.Damage;

public class Predator extends Creature {
    private final Damage damage;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        this.damage = Damage.getRandomDamage();
    }
}
