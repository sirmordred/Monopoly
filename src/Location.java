public class Location {

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    private String name;
    private int price;
    private int rentPrice;
    private Player owner = null;
    private int locationIndex = 0; // TODO 1 is for START

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }

    public boolean isLocationOwned() { // if this property has owner (so owner variable is not NULL) return true
        return this.owner != null;
    }

    public void setOwner(Player ownerPlayer) {
        this.owner = ownerPlayer;
    }

    public Player getOwner() {
        return owner;
    }

    public String toString() {
        return this.name;
    }

}
