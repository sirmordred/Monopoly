import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int cash = 1500;
    private List<Location> ownedLocations = new ArrayList<>();
    private boolean isInJail = false;
    private int currLocationIndex = 0; // TODO 0 is for START

    public Player(String name) {
        this.name = name;
    }

    public int getCurrLocationIndex() {
        return currLocationIndex;
    }

    public void setCurrLocationIndex(int currLocationIndex) {
        this.currLocationIndex = currLocationIndex;
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
}