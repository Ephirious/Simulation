package service.path;

import coordinates.Coordinates;
import service.SimulationMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class PathFinder {
    protected static final Coordinates START_COORDINATE = null;

    private final Map<Coordinates, Coordinates> stepsFromSourceToTarget;
    protected final SimulationMap map;


    public PathFinder(SimulationMap map) {
        this.map = map;
        this.stepsFromSourceToTarget = new HashMap<>();
    }

    public abstract List<Coordinates> find(Coordinates source, Coordinates target);

    protected List<Coordinates> parsePath(Coordinates target) {
        List<Coordinates> parsedPath = new LinkedList<>();

        while (stepsFromSourceToTarget.get(target) != START_COORDINATE) {
            parsedPath.add(target);
            target = stepsFromSourceToTarget.get(target);
        }

        return parsedPath.reversed();
    }

    protected void validate(Coordinates source, Coordinates target) {
        if (!map.isValid(source))
            throw new IllegalArgumentException(getClass().getSimpleName() + ": source coordinate is invalid: " + source);
        if (!map.isValid(target))
            throw new IllegalArgumentException(getClass().getSimpleName() + ": target coordinate is invalid: " + target);
    }

    protected void addStep(Coordinates from, Coordinates to) {
        stepsFromSourceToTarget.put(from, to);
    }

    protected boolean isVisited(Coordinates coordinates) {
        return stepsFromSourceToTarget.containsKey(coordinates);
    }

    protected void clear() {
        stepsFromSourceToTarget.clear();
    }
}
