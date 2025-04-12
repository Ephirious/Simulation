package entities;

import coordinates.Coordinates;
import util.Speed;

public abstract class Creature extends Entity {
    private static final int MAX_HEALTHPOINTS = 100;

    private int healthpoints;
    private final Speed speed;

    public Creature(Coordinates coordinates) {
        super(coordinates);
        this.healthpoints = MAX_HEALTHPOINTS;
        this.speed = Speed.getRandomSpeed();
    }

    public boolean isAlive() {
        return healthpoints > 0;
    }

    public void takeDamage(int takenDamage) {
        healthpoints -= takenDamage;
    }

    public void makeMove() {
        // to do
    }
}
