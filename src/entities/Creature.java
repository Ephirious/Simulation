package entities;

import util.Coordinates;
import util.Speed;
import util.Sprite;

import java.util.List;

public abstract class Creature extends Entity {
    private int healthPoints;
    private final Speed speed;

    public Creature(Coordinates coordinate, Sprite entitySprite, int healthPoints, Speed speed) {
        super(coordinate, entitySprite);
        this.healthPoints = healthPoints;
        this.speed = speed;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void takeDamage(int takenDamage) {
        healthPoints -= takenDamage;
    }

    public List<Coordinates> getPathToNearestEntity() {
        // to do a-star algorithm
        return null;
    }

    public void makeMove() {
        // to do
    }

    abstract public void eat();


}
