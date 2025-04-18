package commands.turn;

import commands.Command;
import entities.Grass;
import entities.Herbivore;
import entities.Predator;
import service.InfoBoard;
import service.SimulationMap;

public class InfoBoardUpdateCommand implements Command {
    private final SimulationMap map;
    private final InfoBoard board;

    public InfoBoardUpdateCommand(SimulationMap map, InfoBoard board) {
        this.map = map;
        this.board = board;
    }

    @Override
    public void execute() {
        int countGrasses = map.getEntitiesByType(Grass.class).size();
        int countHerbivores = map.getEntitiesByType(Herbivore.class).size();
        int countPredators = map.getEntitiesByType(Predator.class).size();

        board.update(countGrasses, countHerbivores, countPredators);
        board.increaseTurn();
    }
}
