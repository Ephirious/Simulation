package commands.place;

import commands.Command;
import coordinates.Coordinates;
import entities.Predator;
import service.SimulationMap;
import util.Damage;
import util.Speed;

public class PlacePredatorCommand extends AbstractPlaceCommand implements Command {
    private final int healthPoints;
    private final Speed speed;
    private final Damage damage;

    public PlacePredatorCommand(SimulationMap map, int healthPoints, Speed speed, Damage damage) {
        super(map);
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.damage = damage;
    }

    @Override
    public void execute() {
        Coordinates free = getFreeCoordinates();
        add(free, new Predator(free, healthPoints, speed, damage));
    }
}
