import java.util.ArrayList;
import java.util.List;

public class LocationJail extends Location{

    public int getType() {
        return type;
    }

    private int type;
    public static int goToJailLocationIndex;
    public static int jailLocationIndex;

    public LocationJail(String name, int locationIndex, int type){
        super(name, locationIndex);
        this.type = type;
        if (type == 0) { // it means this Jail block
            jailLocationIndex = locationIndex;
        } else { // it means this goToJail block
            goToJailLocationIndex = locationIndex;
        }
    }
}
