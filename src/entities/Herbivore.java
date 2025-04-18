package entities;

import coordinates.Coordinates;
import service.SimulationMap;
import util.Speed;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int healthpoints, Speed speed) {
        super(coordinates, healthpoints, speed);
    }

    @Override
    public void makeMove(SimulationMap map) {
        findNearestPath(map, Grass.class);
        super.makeMove(map);
    }

    @Override
    public void eat(SimulationMap map) {
        int hpForGrass = 10;
        increaseHealthPoints(hpForGrass);
        setCoordinates(pathToTarget.removeLast());
    }
}
