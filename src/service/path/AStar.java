package service.path;

import coordinates.Coordinates;
import coordinates.CoordinatesShift;
import entities.Help;
import service.SimulationMap;

import java.util.*;

public class AStar extends PathFinder {
    private static final int COST_FOR_MOVE = 1;

    private final int capacity;
    private final Map<Coordinates, Integer> costsForCoordinates;

    public AStar(SimulationMap map) {
        super(map);

        capacity = (map.getMaxRow() - 1) * (map.getMaxColumn() - 1);
        costsForCoordinates = new HashMap<>();
    }

    @Override
    public List<Coordinates> find(Coordinates source, Coordinates target) {
        validate(source, target);

        Queue<Coordinates> coordinatesToCheck = new PriorityQueue<>(capacity, getComparator(target));

        addStep(source, START_COORDINATE);
        costsForCoordinates.put(source, COST_FOR_MOVE);
        coordinatesToCheck.add(source);

        while (!coordinatesToCheck.isEmpty()) {
            Coordinates current = coordinatesToCheck.poll();

            if (current.equals(target)) {
                break;
            }

            if (map.hasEntity(current) && !current.equals(source) && map.getEntity(current).getClass() != Help.class) {
                continue;
            }

            List<Coordinates> neighboringCoordinates = CoordinatesShift.getNeighboringCoordinates(current);
            neighboringCoordinates.removeIf(checkedCoordinates -> !validator.isValid(checkedCoordinates));

            for (Coordinates neighboring : neighboringCoordinates) {
                int newCost = costsForCoordinates.get(current) + COST_FOR_MOVE;
                if (!costsForCoordinates.containsKey(neighboring) || newCost < costsForCoordinates.get(neighboring)) {
                    costsForCoordinates.put(neighboring, newCost);
                    addStep(neighboring, current);
                    coordinatesToCheck.add(neighboring);
                }
            }
        }

        List<Coordinates> path = parsePath(target);
        clear();

        return path;
    }

    @Override
    protected void clear() {
        super.clear();
        costsForCoordinates.clear();
    }

    private double heuristic(Coordinates source, Coordinates target) {
        double epsilon = 0.001;
        return Math.abs(source.getRow() - target.getRow()) + Math.abs(source.getColumn() - target.getColumn()) * (1 + epsilon);
    }

    private Comparator<Coordinates> getComparator(Coordinates target) {
        return (first, second) -> Double.compare(
                heuristic(first, target) + costsForCoordinates.get(first),
                heuristic(second, target) + costsForCoordinates.get(second)
        );
    }
}
