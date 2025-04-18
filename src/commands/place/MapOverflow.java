package commands.place;

public class MapOverflow extends RuntimeException {
    public MapOverflow(String message) {
        super(message);
    }
}
