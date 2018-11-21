public class LocationCity extends Location implements Comparable{

    private int price;
    private int rentPrice;
    private Player owner;

    public LocationCity(String name, int locationIndex,
                        int price, int rentPrice, Player owner) {
        super(name,locationIndex);
        this.price = price;
        this.rentPrice = rentPrice;
        this.owner = owner;
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isLocationOwned() { // if this property has owner (so owner variable is not NULL) return true
        return this.owner != null;
    }


    @Override
    public int compareTo(Object o) {
        return String.valueOf(this.price).compareTo(String.valueOf(((LocationCity) o).price));
    }
}
