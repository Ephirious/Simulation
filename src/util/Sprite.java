package util;

public enum Sprite {
    ROCK(""),
    TREE(""),
    GRASS(""),
    HERBIVORE(""),
    PREDATOR("");

    private String sprite;

    Sprite(String sprite) {
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }
}
