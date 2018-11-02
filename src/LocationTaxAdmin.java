import java.util.ArrayList;
import java.util.List;

public class LocationTaxAdmin extends Location {

    // All instances of Tax Administration will share the same players in Tax Administration
    private static List<Player> listOfPlayersInTaxAdmin = new ArrayList<>();
    private int taxPrice;

    public LocationTaxAdmin(String name, int locationIndex, int taxPrice) {
        super(name, locationIndex);
        this.taxPrice = taxPrice;
    }

    public static List<Player> getListOfPlayersInTaxAdmin() {
        return listOfPlayersInTaxAdmin;
    }

    public int getTaxPrice() {
        return taxPrice;
    }
}
