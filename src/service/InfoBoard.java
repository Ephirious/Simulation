package service;

public class InfoBoard {
    private int countTurns;
    private int countGrasses;
    private int countHerbivores;
    private int countPredators;

    public InfoBoard() {

    }

    public void update(int countGrasses, int countHerbivores, int countPredators) {
        this.countGrasses = countGrasses;
        this.countHerbivores = countHerbivores;
        this.countPredators = countPredators;
    }

    public void reset() {
        countTurns = 0;
        countGrasses = 0;
        countHerbivores = 0;
        countPredators = 0;
    }

    public void increaseTurn() {
        countTurns++;
    }

    public int getCountTurns() {
        return countTurns;
    }

    public int getCountGrasses() {
        return countGrasses;
    }

    public int getCountHerbivores() {
        return countHerbivores;
    }

    public int getCountPredators() {
        return countPredators;
    }
}
