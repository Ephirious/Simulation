package util;

import entities.*;

import java.util.HashMap;

public class SpritesConstructor {
    public static Sprites getDefaultSprites() {
        HashMap<Class<? extends Entity>, String> defaultSprites = new HashMap<>();

        defaultSprites.put(Rock.class, "\uD83E\uDEA8");
        defaultSprites.put(Tree.class, "\uD83C\uDF33");
        defaultSprites.put(Grass.class, "\uD83C\uDF31");
        defaultSprites.put(Herbivore.class, "\uD83D\uDC11");
        defaultSprites.put(Predator.class, "\uD83E\uDD81");

        return new Sprites(defaultSprites);
    }
}
