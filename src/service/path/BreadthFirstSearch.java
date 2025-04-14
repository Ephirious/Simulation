package service.path;

import coordinates.Coordinates;
import coordinates.CoordinatesShift;
import service.SimulationMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch extends PathFinder {
    private final Queue<Coordinates> coordinatesToCheck;

    public BreadthFirstSearch(SimulationMap map) {
        super(map);
        coordinatesToCheck = new LinkedList<>();
    }

    @Override
    public List<Coordinates> find(Coordinates source, Coordinates target) {
        validate(source, target);

        coordinatesToCheck.add(source);
        addStep(source, START_COORDINATE);

        while (!coordinatesToCheck.isEmpty()) {
            Coordinates current = coordinatesToCheck.poll();

            if (current.equals(target))
                break;

            if (map.hasEntity(current) && !current.equals(source))
                continue;

            List<Coordinates> neighboringCoordinates = CoordinatesShift.getNeighboringCoordinates(current);
            neighboringCoordinates.removeIf(coordinates -> !validator.isValid(coordinates));

            for (Coordinates neighboring : neighboringCoordinates)
                if (!isVisited(neighboring)) {
                    coordinatesToCheck.add(neighboring);
                    addStep(neighboring, current);
                }
        }

        List<Coordinates> path = parsePath(target);
        clear();

        return path;
    }

    @Override
    protected void clear() {
        super.clear();
        coordinatesToCheck.clear();
    }
}
