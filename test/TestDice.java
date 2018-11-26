import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void testDiceResult() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        
        boolean diceResultIsInRange = true;
        for(int i=0; i<1000; i++) { // roll dice 1000 times
            dice1.generateRandomValFromDice();
            dice2.generateRandomValFromDice();
            int diceResult = Dice.getDiceResult();
            if (diceResult < 2 || diceResult > 12) { // 1 + 1 condition(which equals 2) and 6 + 6 condition(which equals 12)
                diceResultIsInRange = false;
            }
            Dice.setDiceResult(0); // reset dice result after every iteration
        }
        assertEquals(true,diceResultIsInRange);
    }

}
