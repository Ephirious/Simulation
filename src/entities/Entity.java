package entities;

import util.Coordinates;
import util.Sprite;

public abstract class Entity {
    private Coordinates coordinate;
    private final Sprite entitySprite;

    public Entity(Coordinates coordinate, Sprite entitySprite) {
        this.coordinate = coordinate;
        this.entitySprite = entitySprite;
    }

    public String getSprite() {
        return entitySprite.getSprite();
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }
}
