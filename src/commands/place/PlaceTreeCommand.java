package commands.place;

import commands.Command;
import coordinates.Coordinates;
import entities.Tree;
import service.SimulationMap;

public class PlaceTreeCommand extends AbstractPlaceCommand implements Command {
    public PlaceTreeCommand(SimulationMap map) {
        super(map);
    }

    @Override
    public void execute() {
        Coordinates free = getFreeCoordinates();
        add(free, new Tree(free));
    }
}
