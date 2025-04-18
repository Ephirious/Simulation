package service;

import coordinates.Coordinates;
import util.Sprites;

public class SimulationRenderer {
    private final SimulationMap renderingMap;
    private final Sprites spritesForEntity;
    private final InfoBoard board;

    public SimulationRenderer(SimulationMap renderingMap, Sprites spritesForEntity, InfoBoard board) {
        this.renderingMap = renderingMap;
        this.spritesForEntity = spritesForEntity;
        this.board = board;
    }

    public void render() {
        renderBoard();
        renderControlRules();
        renderMap();
    }

    private void renderMap() {
        String currentSprite;
        String spriteForVoid = "▫️";

        for (int row = 0; row < renderingMap.getWidth(); row++) {
            for (int column = 0; column < renderingMap.getHeight(); column++) {
                Coordinates currentCoordinates = new Coordinates(row, column);

                if (renderingMap.hasEntity(currentCoordinates)) {
                    currentSprite = spritesForEntity.getSprite(renderingMap.get(currentCoordinates).getClass());
                } else {
                    currentSprite = spriteForVoid;
                }

                System.out.print(currentSprite);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void renderBoard() {
        System.out.println("Turn - " + board.getCountTurns());
        System.out.println("Number of grasses - " + board.getCountGrasses());
        System.out.println("Number of herbivores - " + board.getCountHerbivores());
        System.out.println("Number of predators - " + board.getCountPredators());
    }

    private void renderControlRules() {
        System.out.println("Control keys: (p - pause; c - continue; r - restart; q - quit) + ENTER");
    }
}
