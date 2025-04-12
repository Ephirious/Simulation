package util;

public enum Sprite {
    ROCK("\uD83E\uDEA8"),
    TREE("\uD83C\uDF33"),
    GRASS("\uD83C\uDF31"),
    HERBIVORE("\uD83D\uDC11"),
    PREDATOR("\uD83E\uDD81"),
    EMPTY("▫\uFE0F"),
    PATH("🟢");

    private final String sprite;

    Sprite(String sprite) {
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }
}
