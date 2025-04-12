package coordinates;

import service.SimulationMap;

public class CoordinatesValidator {
    private final int maxRow;
    private final int maxColumn;

    public CoordinatesValidator(SimulationMap map) {
        this.maxRow = map.getMaxRow();
        this.maxColumn = map.getMaxColumn();
    }

    public boolean isValid(Coordinates validationCoordinates) {
        int row = validationCoordinates.getRow();
        int col = validationCoordinates.getColumn();

        return (row >= 0 && row < maxRow) && (col >= 0 && col < maxColumn);
    }
}
