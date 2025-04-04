package entities;

import util.Coordinates;
import util.Sprite;

public abstract class Entity {
    private final Coordinates coordinates;
    private final Sprite sprite;

    public Entity(Coordinates coordinates, Sprite sprite) {
        this.coordinates = coordinates;
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite.getSprite();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
