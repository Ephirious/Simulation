package commands.turn;

import coordinates.Coordinates;
import entities.Creature;
import entities.Entity;
import service.SimulationMap;

import java.util.List;

public class MoveCreatureCommand extends AbstractTurnCommand {
    private final Class<? extends Creature> clazz;

    public MoveCreatureCommand(SimulationMap map, Class<? extends Creature> clazz) {
        super(map);
        this.clazz = clazz;
    }

    @Override
    public void execute() {
        List<? extends Creature> herbivores = map.getEntitiesByType(clazz);
        for (Creature movingCreature : herbivores) {
            Coordinates beforeMove = movingCreature.getCoordinates();

            movingCreature.makeMove(map);

            if (!beforeMove.equals(movingCreature.getCoordinates())) {
                reposition(movingCreature, beforeMove, movingCreature.getCoordinates());
            }

            if (!movingCreature.isAlive()) {
                new RemoveEntityCommand(map, movingCreature).execute();
            }
        }
    }

    private void reposition(Entity moving, Coordinates from, Coordinates to) {
        map.remove(from);
        if (map.hasEntity(to)) {
            map.remove(to);
        }
        map.add(to, moving);
    }
}
