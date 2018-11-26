import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void testDiceResult() {

        for(int i=0;i<=1000;i++) {
            Dice dice1 = new Dice();
            Dice dice2 = new Dice();
            dice1.generateRandomValFromDice();
            dice2.generateRandomValFromDice();
            int diceResult = Dice.getDiceResult();
            if (diceResult >= 2 && diceResult <= 12) {
                //System.out.println("True");
            }
            else{
                System.out.println("False");
            }
            Dice.setDiceResult(0);
        }
    }

}