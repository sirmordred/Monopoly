import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestGameLogic {

    Player testPlayer1;
    Player testPlayer2;
    List<Player> testPlayers;
    GameLogic testGameLogic;

    @Before
    public void setUp() {
        testGameLogic = new GameLogic();

        testPlayer1 = new Player("Busra");
        testPlayer2 = new Player("Alperen");

        testPlayers = new ArrayList<>();

        testPlayers.add(testPlayer1);
        testPlayers.add(testPlayer2);

        testPlayer1.setCash(-450); // make him in debt
        LocationCity testCity = new LocationCity("MAYFAIR", 39,
                400, 80, null); // get "MAYFAIR" which price is 400
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
        boolean testGameResult = testGameLogic.isGameContinue(testPlayers);
        /* testPlayer1 will be eliminated even if his "MAYFAIR" gets foreclosed,
         because money he will earn from selling "MAYFAIR" is 400$
         while he is -450$ in debt
         so testPlayer2 will won the game !!! */

        assertEquals(false, testGameResult);
    }
}
