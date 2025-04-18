package service;

import java.util.Scanner;

public class Listener implements Runnable {
    private static final char SYMBOL_FOR_PAUSE = 'p';
    private static final char SYMBOL_FOR_CONTINUE = 'c';
    private static final char SYMBOL_FOR_CLOSE = 'q';
    private static final char SYMBOL_FOR_RESTART = 'r';


    private final Simulation simulation;

    public Listener(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (!simulation.isClosed()) {
            if (scanner.hasNext()) {
                String answer = scanner.next().toLowerCase();

                for (int i = 0; i < answer.length(); i++) {
                    switch (answer.charAt(i)) {
                        case SYMBOL_FOR_PAUSE -> simulation.pause();
                        case SYMBOL_FOR_CONTINUE -> simulation.unpause();
                        case SYMBOL_FOR_CLOSE -> simulation.close();
                        case SYMBOL_FOR_RESTART -> simulation.restart();
                    }
                }
            }
        }
    }
}
