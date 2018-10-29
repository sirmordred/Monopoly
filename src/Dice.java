public class Dice {

    public static int getRandomFromFirstDice() {
        return (int) ((Math.random() * 5) + 1);
    }

    public static int getRandomFromSecondDice() {
        return (int) ((Math.random() * 5) + 1);
    }
}
