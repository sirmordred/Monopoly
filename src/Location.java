public class Location {

    private String name;
    private int locationIndex = 1;

    public Location(String name, int locationIndex) {
        this.name = name;
        this.locationIndex = locationIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }

    public String toString() {
        return this.name;
    }

}
