package coordinates;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesShift {
    public static List<Coordinates> getNeighboringCoordinates(Coordinates currentCoordinate) {
        List<Coordinates> neighboringCoordinates = new ArrayList<>();

        int row = currentCoordinate.getRow();
        int col = currentCoordinate.getColumn();

        neighboringCoordinates.add(new Coordinates(row + 1, col));
        neighboringCoordinates.add(new Coordinates(row - 1, col));
        neighboringCoordinates.add(new Coordinates(row, col + 1));
        neighboringCoordinates.add(new Coordinates(row, col - 1));

        return neighboringCoordinates;
    }
}
