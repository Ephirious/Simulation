package service;

import coordinates.Coordinates;
import entities.Entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SimulationMap {
    private final int width;
    private final int height;
    private final Map<Coordinates, Entity> entities;

    public SimulationMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getNumberOfEntities() {
        return entities.size();
    }

    public boolean hasEntity(Coordinates coordinates) {
        return entities.containsKey(coordinates);
    }

    public void add(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public Entity get(Coordinates coordinates) {
        verifyKey(coordinates);
        return entities.get(coordinates);
    }

    public void remove(Coordinates coordinates) {
        verifyKey(coordinates);
        entities.remove(coordinates);
    }

    public void clear() {
        entities.clear();
    }

    public <T extends Entity> List<T> getEntitiesByType(Class<T> clazz) {
        List<T> result = new LinkedList<>();

        for (Coordinates currentCoordinates : entities.keySet()) {
            Entity currentEntity = entities.get(currentCoordinates);
            if (currentEntity.getClass() == clazz) {
                result.add(((T) currentEntity));
            }
        }

        return result;
    }

    public boolean isValid(Coordinates validationCoordinates) {
        int row = validationCoordinates.getRow();
        int col = validationCoordinates.getColumn();

        return (row >= 0 && row < width) && (col >= 0 && col < height);
    }

    private void verifyKey(Coordinates coordinates) {
        if (!entities.containsKey(coordinates))
            throw new IllegalArgumentException("SimulationMap: hasn't entity by coordinates " + coordinates);
    }
}