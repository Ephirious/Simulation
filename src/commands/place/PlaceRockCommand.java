package commands.place;

import commands.Command;
import coordinates.Coordinates;
import entities.Rock;
import service.SimulationMap;

public class PlaceRockCommand extends AbstractPlaceCommand implements Command {
    public PlaceRockCommand(SimulationMap map) {
        super(map);
    }

    @Override
    public void execute() {
        Coordinates free = getFreeCoordinates();
        add(free, new Rock(free));
    }
}
