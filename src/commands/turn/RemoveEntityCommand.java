package commands.turn;

import entities.Entity;
import service.SimulationMap;

public class RemoveEntityCommand extends AbstractTurnCommand {
    private final Entity removingEntity;

    public RemoveEntityCommand(SimulationMap map, Entity removingEntity) {
        super(map);
        this.removingEntity = removingEntity;
    }

    @Override
    public void execute() {
        if (!map.hasEntity(removingEntity.getCoordinates()))
            throw new IllegalArgumentException("RemoveEntityCommand: map hasn't next entity " + removingEntity);
        map.remove(removingEntity.getCoordinates());
    }
}
