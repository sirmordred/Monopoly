import java.util.ArrayList;
import java.util.List;

public class LocationJail extends Location{

    public static List<Integer> getJailLocations() {
        return jailLocations;
    }

    private static List<Integer> jailLocations = new ArrayList<>();

    public LocationJail(String name, int locationIndex){
        super(name, locationIndex);
        jailLocations.add(locationIndex); // Save multiple jail's location in one instance(static)
    }
}
