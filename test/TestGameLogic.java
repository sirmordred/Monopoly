import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestGameLogic {

    Player testPlayer1;
    Player testPlayer2;
    List<Player> testPlayers;
    List<Location> testLocations;
    GameLogic testGameLogic;

    @Before
    public void setUp() {
        testGameLogic = new GameLogic();

        testPlayer1 = new Player("Busra");
        testPlayer2 = new Player("Alperen");

        testLocations = new ArrayList<>();
        testPlayers = new ArrayList<>();

        testPlayers.add(testPlayer1);
        testPlayers.add(testPlayer2);

        // fill testLocations with locations
        testLocations.add(new Location("START", 0));
        testLocations.add(new LocationCity("OLD KENT ROAD", 1,
                60, 10, null));

        testLocations.add(new LocationLuckyCard("CHANCE",2));

        testLocations.add(new LocationCity("WHITECHAPEL", 3,
                60, 10, null));

        testLocations.add(new LocationTaxAdmin("INCOME TAX", 4, 200)); // TAX ADMINISTRATION LOCATION

        testLocations.add(new LocationCity("KINGS CROSS ", 5,
                200, 40, null));

        testLocations.add(new LocationCity("THE ANGEL ISLINGTON", 6,
                100, 20, null));

        testLocations.add(new LocationLuckyCard("CHANCE",7));

        testLocations.add(new LocationCity("EUSTON ROAD", 8,
                100, 20, null));
        testLocations.add(new LocationCity("PENTONVILLE ROAD", 9,
                120, 25, null));
        testLocations.add(new LocationJail("JAIL", 10, 0));// JAIL LOCATION

        testLocations.add(new LocationCity("PALL MALL", 11,
                140, 30, null));
        testLocations.add(new LocationTaxAdmin("ELECTRIC COMPANY", 12, 150)); // TAX ADMINISTRATION LOCATION

        testLocations.add(new LocationCity("WHITEHALL", 13,
                140, 30, null));
        testLocations.add(new LocationCity("NORTHUMBERLAND AVENUE", 14,
                160, 35, null));
        testLocations.add(new LocationCity("MARLEYBONE STATION", 15,
                200, 40, null));
        testLocations.add(new LocationCity("BOW STREET", 16,
                180, 35, null));
        testLocations.add(new LocationLuckyCard("CHANCE",17));

        testLocations.add(new LocationCity("MARLBROROUGH STREET", 18,
                180, 35, null));
        testLocations.add(new LocationCity("VINE STREET", 19,
                200, 40, null));
        testLocations.add(new LocationTaxAdmin("FREE PARKING", 20, 0)); // BURADA HICBISEY OLMAMASI DOGRU

        testLocations.add(new LocationCity("STRANT", 21,
                220, 45, null));
        testLocations.add(new LocationLuckyCard("CHANCE",22));

        testLocations.add(new LocationCity("FLEET STREET", 23,
                220, 45, null));
        testLocations.add(new LocationCity("TRAFALGAR SQUARE", 24,
                240, 50, null));
        testLocations.add(new LocationCity("FENCHURCH STREET STATION", 25,
                200, 40, null));
        testLocations.add(new LocationCity("LEICESTER SQUARE", 26,
                260, 55, null));
        testLocations.add(new LocationCity("COVENTRY STREET", 27,
                260, 55, null));
        testLocations.add(new LocationTaxAdmin("WATER WORKS", 28, 150));
        testLocations.add(new LocationCity("PICCADILLY", 29,
                280, 60, null));


        testLocations.add(new LocationJail("GO TO JAIL", 30, 1));


        testLocations.add(new LocationCity("REGENT STREET", 31,
                300, 65, null));
        testLocations.add(new LocationCity("OXFORD STREET", 32,
                300, 65, null));

        testLocations.add(new LocationLuckyCard("CHANCE",33));

        testLocations.add(new LocationCity("BOND STREET", 34,
                320, 70, null));

        testLocations.add(new LocationCity("LIVERPOOL STREET STATION", 35,
                200, 40, null));

        testLocations.add(new LocationLuckyCard("CHANCE",36));

        testLocations.add(new LocationCity("PARKLANE", 37,
                350, 75, null));
        testLocations.add(new LocationTaxAdmin("SUPER TAX", 38, 100));
        testLocations.add(new LocationCity("MAYFAIR", 39,
                400, 80, null));

        testPlayer1.setCash(-450); // make him in debt
        LocationCity testCity = (LocationCity)  testLocations.get(39); // get "MAYFAIR" which price is 400
        //set testPlayer1 as "MAYFAIR"'s owner
        testPlayer1.getOwnedLocations().add(testCity);
        testCity.setOwner(testPlayer1);
    }

    @Test
    public void testHasThisName(){
        List<Player> testPlayerList = new ArrayList<>();

        testPlayerList.add(new Player("Ahmet"));
        testPlayerList.add(new Player("Mehmet"));
        testPlayerList.add(new Player("Veli"));

        assertEquals(true,testGameLogic.hasThisName(testPlayerList,"Ahmet"));
    }

    @Test
    public void testIsGameContinue() {
        //make operation
        boolean testGameResult = testGameLogic.isGameContinue(testPlayers, testLocations);
        /* testPlayer1 will be eliminated even if his "MAYFAIR" gets foreclosed,
         because money he will earn from selling "MAYFAIR" is 400$
         while he is -450$ in debt
         so testPlayer2 will won the game !!! */

        assertEquals(false, testGameResult);
    }
}
