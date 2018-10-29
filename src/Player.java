import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int cash = 1500;
    private List<Location> ownedLocations = new ArrayList<>();; // TODO delete
    private boolean isInJail = false;
    private Location location = null;

    public Location getLocation() {
        return location;
    }

    public void setLocation(int newLocationIndex) {
        this.location.setLocationIndex(newLocationIndex);
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public List<Location> getOwnedLocations() {
        return ownedLocations;
    }

    public void setOwnedLocations(List<Location> ownedLocations) {
        this.ownedLocations = ownedLocations;
    }

    public boolean isInJail() {
        return isInJail;
    }

    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }

    @Override
    public String toString() {
        return "Player: " + this.name + "is currently on: " + this.location +
                " and has " + this.cash + "$ money";
    }
}