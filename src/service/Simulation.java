package service;

import commands.CommandManager;
import commands.init.InitCommand;
import commands.turn.GrowGrassCommand;
import commands.turn.InfoBoardUpdateCommand;
import commands.turn.MoveCreatureCommand;
import entities.Herbivore;
import entities.Predator;
import util.SpritesConstructor;

public class Simulation {
    private final CommandManager manager;
    private final SimulationMap map;
    private final SimulationRenderer renderer;
    private final InfoBoard board;
    private final Thread listenThread;

    private volatile boolean isPaused = false;
    private volatile boolean isClosed = false;


    public Simulation() {
        final int MAP_ROW = 20;
        final int MAP_COLUMN = 20;

        this.listenThread = new Thread(new Listener(this));
        this.listenThread.setDaemon(true);
        this.manager = new CommandManager();
        this.map = new SimulationMap(MAP_ROW, MAP_COLUMN);
        this.board = new InfoBoard();
        this.renderer = new SimulationRenderer(map, SpritesConstructor.getDefaultSprites(), board);
    }

    public void startSimulation() {
        listenThread.start();
        initSimulation();
        while (!isClosed) {
            startSimulationLoop();
        }
    }

    public void restart() {
        map.clear();
        board.reset();
        manager.clearQueue();
        initSimulation();
        isPaused = false;
    }

    public void unpause() {
        isPaused = false;
    }

    public void pause() {
        isPaused = true;
    }

    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    private void initSimulation() {
        manager.addCommand(new InitCommand(map));
        manager.executeOne();
    }

    private void startSimulationLoop() {
        while (!isClosed && !isPaused) {
            manager.addCommand(new InfoBoardUpdateCommand(map, board));
            manager.executeOne();

            renderer.render();

            manager.addCommand(new MoveCreatureCommand(map, Herbivore.class));
            manager.addCommand(new MoveCreatureCommand(map, Predator.class));
            manager.addCommand(new GrowGrassCommand(map));

            manager.executeAll();

            simulationSleep();
        }
    }

    private void simulationSleep() {
        int SLEEP_DURATION_IN_MILLIS = 2000;
        try {
            Thread.sleep(SLEEP_DURATION_IN_MILLIS);
        } catch (InterruptedException e) {
            throw new RuntimeException("The simulation thread was interrupt");
        }
    }

}