package commands.place;

import commands.Command;
import coordinates.Coordinates;
import entities.Grass;
import service.SimulationMap;

public class PlaceGrassCommand extends AbstractPlaceCommand implements Command {
    private final Coordinates placingCoordinates;

    public PlaceGrassCommand(SimulationMap map) {
        super(map);
        this.placingCoordinates = null;
    }

    public PlaceGrassCommand(SimulationMap map, Coordinates placingCoordinates) {
        super(map);
        this.placingCoordinates = placingCoordinates;
    }

    @Override
    public void execute() {
        Coordinates free = placingCoordinates;
        if (free == null)
            free = getFreeCoordinates();
        add(free, new Grass(free));
    }
}
