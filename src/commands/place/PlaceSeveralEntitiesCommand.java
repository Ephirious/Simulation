package commands.place;

import commands.Command;
import service.SimulationMap;

public class PlaceSeveralEntitiesCommand implements Command {
    private final SimulationMap map;
    private final int count;
    private final AbstractPlaceCommand command;

    public PlaceSeveralEntitiesCommand(SimulationMap map, int count, AbstractPlaceCommand command) {
        this.map = map;
        this.count = count;
        this.command = command;
    }

    @Override
    public void execute() {
        for (int i = 0; i < count; i++) {
            command.execute();
        }
    }
}
