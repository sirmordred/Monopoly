import java.util.ArrayList;
import java.util.List;

public class LocationJail extends Location{

    // All instances of Jail will share the same players in jail
    private static List<Player> playersInJail = new ArrayList<>();

    public LocationJail(String name, int locationIndex){
        super(name, locationIndex);
    }

}
