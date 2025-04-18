package commands.place;

import commands.Command;
import coordinates.Coordinates;
import entities.Entity;
import service.SimulationMap;

import java.util.Random;

public abstract class AbstractPlaceCommand implements Command {
    private static final Random coordinatesRandomizer = new Random();

    private final SimulationMap map;

    public AbstractPlaceCommand(SimulationMap map) {
        this.map = map;
    }

    protected void add(Coordinates coordinates, Entity entity) {
        map.add(coordinates, entity);
    }

    protected Coordinates getFreeCoordinates() {
        if (map.getNumberOfEntities() >=  map.getWidth() * map.getHeight()) {
            throw new MapOverflow("AbstractCommandPlace: map overflow and it already has " + map.getNumberOfEntities() + " entities");
        }

        int origin = 0;

        Coordinates coordinates;
        do {
            coordinates = new Coordinates(
                    coordinatesRandomizer.nextInt(origin, map.getWidth()),
                    coordinatesRandomizer.nextInt(origin, map.getWidth())
            );
        } while (map.hasEntity(coordinates));

        return coordinates;
    }
}
