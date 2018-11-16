import java.util.ArrayList;
import java.util.List;

public class LocationJail extends Location{

    // All instances of Jail will share the same players in jail
    private static List<Player> playersInJail = new ArrayList<>(); // TODO delete if it is unused/unimportant but keep it for now

    public static List<Integer> getJailLocations() {
        return jailLocations;
    }

    private static List<Integer> jailLocations = new ArrayList<>();

    public LocationJail(String name, int locationIndex){
        super(name, locationIndex);
        jailLocations.add(locationIndex); // Save multiple jail's location in one instance(static)
    }
}
