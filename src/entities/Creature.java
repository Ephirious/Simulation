package entities;

import coordinates.Coordinates;
import coordinates.CoordinatesShift;
import service.SimulationMap;
import service.path.AStar;
import service.path.PathFinder;
import util.Speed;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Creature extends Entity {
    private static final int HP_LOSS_FOR_MOVE = 5;
    private static final int MAX_HP = 100;

    private int healthpoints;
    private final Speed speed;

    protected List<Coordinates> pathToTarget;

    public Creature(Coordinates coordinates, int healthpoints, Speed speed) {
        super(coordinates);
        this.healthpoints = healthpoints;
        this.speed = speed;
    }

    public boolean isAlive() {
        return healthpoints > 0;
    }

    public void makeMove(SimulationMap map) {
        if (!pathToTarget.isEmpty()) {
            int countSteps = (pathToTarget.size() <= speed.getSpeed()) ? pathToTarget.size() - 1 : speed.getSpeed();
            for (int i = 0; i < countSteps; i++) {
                setCoordinates(pathToTarget.removeFirst());
            }
            if (pathToTarget.size() == 1)
                eat(map);
        } else {
            makeRandomMove(map);
        }
        healthpoints -= HP_LOSS_FOR_MOVE;
    }

    public abstract void eat(SimulationMap map);

    protected void findNearestPath(SimulationMap map, Class<? extends Entity> clazz) {
        int minPathSize = map.getWidth() * map.getHeight();
        List<? extends Entity> targetsAtMap = map.getEntitiesByType(clazz);
        List<Coordinates> resultPath = new LinkedList<>();
        PathFinder finder = new AStar(map);

        for (Entity target : targetsAtMap) {
            List<Coordinates> path = finder.find(getCoordinates(), target.getCoordinates());

            if (!path.isEmpty() && path.size() < minPathSize) {
                minPathSize = path.size();
                resultPath = path;
            }
        }

        pathToTarget = resultPath;
    }

    protected void makeRandomMove(SimulationMap map) {
        Random coordinatesRandomizer = new Random();
        List<Coordinates> shifts = CoordinatesShift.getNeighboringCoordinates(getCoordinates());
        shifts.removeIf(coordinates -> map.hasEntity(coordinates) || !map.isValid(coordinates));

        if (!shifts.isEmpty()) {
            setCoordinates(shifts.get(coordinatesRandomizer.nextInt(shifts.size())));
        }
    }

    protected int getHealthpoints() {
        return healthpoints;
    }

    protected void increaseHealthPoints(int value) {
        healthpoints += value;
        if (healthpoints > MAX_HP)
            healthpoints = MAX_HP;
    }

    protected void decreaseHealthPoints(int value) {
        healthpoints -= value;
    }
}