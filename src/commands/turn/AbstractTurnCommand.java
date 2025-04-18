package commands.turn;

import commands.Command;
import service.SimulationMap;

public abstract class AbstractTurnCommand implements Command {
    protected final SimulationMap map;

    public AbstractTurnCommand(SimulationMap map) {
        this.map = map;
    }
}
