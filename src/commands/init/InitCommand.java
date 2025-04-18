package commands.init;

import commands.Command;
import commands.place.*;
import service.SimulationMap;
import util.Damage;
import util.Speed;

public class InitCommand implements Command {
    private final SimulationMap map;

    private final int countRocks;
    private final int countTrees;
    private final int countGrasses;
    private final int countHerbivores;
    private final int countPredators;

    public InitCommand(SimulationMap map) {
        this.map = map;

        this.countRocks = 20;
        this.countTrees = 20;
        this.countGrasses = 40;
        this.countHerbivores = 15;
        this.countPredators = 5;

        int amountOfSpace = map.getWidth() * map.getHeight();
        int requestedCountEntities = countRocks + countTrees + countGrasses + countHerbivores + countPredators;

        if (requestedCountEntities > amountOfSpace) {
            throw new IllegalArgumentException("InitCommand: not enough space for requested entities");
        }
    }

    @Override
    public void execute() {
        Command placeCommand;
        final int CREATURES_HEALTHPOINTS = 100;

        placeCommand = new PlaceSeveralEntitiesCommand(map, countRocks, new PlaceRockCommand(map));
        placeCommand.execute();

        placeCommand = new PlaceSeveralEntitiesCommand(map, countTrees, new PlaceTreeCommand(map));
        placeCommand.execute();

        placeCommand = new PlaceSeveralEntitiesCommand(map, countGrasses, new PlaceGrassCommand(map));
        placeCommand.execute();

        placeCommand = new PlaceSeveralEntitiesCommand(
                map,
                countHerbivores,
                new PlaceHerbivoreCommand(map, CREATURES_HEALTHPOINTS, Speed.getRandomSpeed())
        );
        placeCommand.execute();

        placeCommand = new PlaceSeveralEntitiesCommand(
                map,
                countPredators,
                new PlacePredatorCommand(map, CREATURES_HEALTHPOINTS, Speed.getRandomSpeed(), Damage.getRandomDamage())
        );
        placeCommand.execute();

    }
}
