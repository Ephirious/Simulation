package entities;

import commands.place.PlaceGrassCommand;
import coordinates.Coordinates;
import coordinates.CoordinatesShift;
import service.SimulationMap;

import java.util.List;
import java.util.Random;

public class Grass extends Entity {
    private static final Random photosynthesisRandomizer = new Random();

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    public void photosynthesis(SimulationMap map) {
        int mapSize = map.getWidth() * map.getHeight();
        double photosynthesisChance = 1 - ((double) map.getNumberOfEntities() / mapSize) - 0.5;

        if (photosynthesisRandomizer.nextDouble(1) < photosynthesisChance) {
            List<Coordinates> shifts = CoordinatesShift.getNeighboringCoordinates(getCoordinates());
            shifts.removeIf(coordinates -> map.hasEntity(coordinates) || !map.isValid(coordinates));

            if (!shifts.isEmpty()) {
                new PlaceGrassCommand(map, shifts.getFirst()).execute();
            }
        }
    }
}
