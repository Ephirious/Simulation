package service.path;

import coordinates.Coordinates;
import coordinates.CoordinatesValidator;
import service.SimulationMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class PathFinder {
    protected static final Coordinates START_COORDINATE = null;

    private final Map<Coordinates, Coordinates> stepsFromSourceToTarget;
    protected final SimulationMap map;
    protected final CoordinatesValidator validator;


    public PathFinder(SimulationMap map) {
        this.map = map;
        this.stepsFromSourceToTarget = new HashMap<>();
        validator = new CoordinatesValidator(map);
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
        if (!validator.isValid(source))
            throw new IllegalArgumentException(getClass().getSimpleName() + ": source coordinate is invalid: " + source);
        if (!validator.isValid(target))
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
