package commands.turn;

import entities.Grass;
import service.SimulationMap;

import java.util.List;

public class GrowGrassCommand extends AbstractTurnCommand {
    public GrowGrassCommand(SimulationMap map) {
        super(map);
    }

    @Override
    public void execute() {
        List<Grass> grasses = map.getEntitiesByType(Grass.class);

        for (Grass concreteGrass : grasses) {
            concreteGrass.photosynthesis(map);
        }
    }
}
