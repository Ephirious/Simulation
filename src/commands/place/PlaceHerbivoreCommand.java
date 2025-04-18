package commands.place;

import commands.Command;
import coordinates.Coordinates;
import entities.Herbivore;
import service.SimulationMap;
import util.Speed;

public class PlaceHerbivoreCommand extends AbstractPlaceCommand implements Command {
    private final int healthPoints;
    private final Speed speed;

    public PlaceHerbivoreCommand(SimulationMap map, int healthPoints, Speed speed) {
        super(map);
        this.healthPoints = healthPoints;
        this.speed = speed;
    }

    @Override
    public void execute() {
        Coordinates free = getFreeCoordinates();
        add(free, new Herbivore(free, healthPoints, speed));
    }
}
