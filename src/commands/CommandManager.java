package commands;

import java.util.Deque;
import java.util.LinkedList;

public class CommandManager {
    private final Deque<Command> commandQueue;

    public CommandManager() {
        this.commandQueue = new LinkedList<>();
    }

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeOne() {
        commandQueue.removeFirst().execute();
    }

    public void executeAll() {
        while (!commandQueue.isEmpty()) {
            commandQueue.removeFirst().execute();
        }
    }

    public void clearQueue() {
        commandQueue.clear();
    }
}
