import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestGameLogic {

    @Test
    public void testHasThisName(){
        List<Player> testPlayerList = new ArrayList<>();

        testPlayerList.add(new Player("Ahmet"));
        testPlayerList.add(new Player("Mehmet"));
        testPlayerList.add(new Player("Veli"));

        assertEquals(true,GameLogic.hasThisName(testPlayerList,"Ahmet"));
    }
}
