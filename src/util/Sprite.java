package entities;

public enum Sprite {
    ROCK("\uD83E\uDEA8"),
    GRASS("\uD83C\uDF31"),
    TREE("\uD83C\uDF33"),
    PREDATOR("\uD83D\uDC3A"),
    HERBIVORE("\uD83D\uDC25");

    private final String sprite;

    Sprite(String sprite) {
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }
}
