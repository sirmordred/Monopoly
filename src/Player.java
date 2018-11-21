import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int cash = 1500;
    private List<LocationCity> ownedLocations = new ArrayList<>();
    private boolean isInJail = false;
    private int currLocationIndex = 0;

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

    public List<LocationCity> getOwnedLocations() {
        return ownedLocations;
    }

    public boolean isInJail() {
        return isInJail;
    }

    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }
}