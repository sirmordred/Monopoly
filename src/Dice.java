public class Dice {

    public static int getDiceResult() {
        return diceResult;
    }

    public static void setDiceResult(int diceResult) {
        Dice.diceResult = diceResult;
    }

    // All instances of Dice will share the same diceResult object
    private static int diceResult = 0;

    public Dice() {
        // empty constructor
    }

    public void generateRandomValFromDice() {
        diceResult += (int) ((Math.random() * 5) + 1);
    }
}
