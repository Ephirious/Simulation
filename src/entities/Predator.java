package entities;

import coordinates.Coordinates;
import service.SimulationMap;
import util.Damage;
import util.Speed;

public class Predator extends Creature {
    private final Damage damage;

    public Predator(Coordinates coordinates, int healthpoints, Speed speed, Damage damage) {
        super(coordinates, healthpoints, speed);
        this.damage = damage;
    }

    @Override
    public void makeMove(SimulationMap map) {
        findNearestPath(map, Herbivore.class);
        super.makeMove(map);
    }

    @Override
    public void eat(SimulationMap map) {
        int damage = this.damage.getDamageWithinBoundaries();

        Creature damagedEntity = ((Creature) map.get(pathToTarget.removeLast()));
        damagedEntity.decreaseHealthPoints(damage);

        increaseHealthPoints(damage);

        if (!damagedEntity.isAlive()) {
            setCoordinates(damagedEntity.getCoordinates());
        }
    }
}
