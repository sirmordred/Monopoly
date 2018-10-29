import java.util.*;

public class GameLogic {

    private static List<Player> players = new ArrayList<>();
    private static List<Location> locations = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Enter the number of players you want :");

        Scanner scn = new Scanner(System.in);

        int totalPlayerNum = scn.nextInt();
        // TODO add limit 2..4

        for(int i = 1; i < totalPlayerNum+1; i++) {
            // TODO show "enter Player1 name dialog to use to choose
            players.add(new Player("i" + i));
        }

        // Create locations and add them to the locations arraylist
        locations.add(new Location("START", 1));
        locations.add(new Location("LISBON", 2));
        locations.add(new Location("PERU", 3));
        locations.add(new Location("ATHENS", 4));
        locations.add(new Location("ISTANBUL", 5));
        locations.add(new Location("JAIL", 6));
        locations.add(new Location("HONGKONG", 7));
        locations.add(new Location("LONDON", 8));
        locations.add(new Location("TAX", 9));
        locations.add(new Location("MOSCOW", 10));
        locations.add(new Location("TOKYO", 11));

        while(isGameContinue()) {
            for (Player player : players) {
                // TODO add check if user is not in Jail
                // player rolls dice
                int diceResult = Dice.getRandomFromFirstDice() + Dice.getRandomFromSecondDice();
                System.out.println("Dice result: " + diceResult);
                // TODO check indexes (outofbonds, eg 11 + 4)
                player.setCurrLocationIndex(player.getCurrLocationIndex() + diceResult);
                int playerLocIndexAfterMove = player.getCurrLocationIndex();
                Location playerLocAfterMove = locations.get(playerLocIndexAfterMove);

                // if location is owned by another player, pay the rent
                // TODO OR if location is tax, decrease player's cash (taxing)
                // TODO OR if location is jail, take player to the jail
                // TODO OR show option dialog to user if he/she want to buy property or not
                if (playerLocAfterMove.isLocationOwned()) {
                    int rentAmount = playerLocAfterMove.getRentPrice(); // calculate rent price
                    player.setCash(player.getCash() - rentAmount); // decrease leaseholder player's cash
                    playerLocAfterMove.getOwner().setCash(playerLocAfterMove.getOwner().getCash() + rentAmount); // increase owner player's cash
                } else {
                    Scanner scn2 = new Scanner(System.in);
                    System.out.println("Do you want to buy this location? (Y/n):");
                    System.out.println("Price:"+ playerLocAfterMove.getPrice());
                    String userChoice = scn2.nextLine();
                    if (userChoice.equals("Y") || userChoice.equals("y")) {
                        int price = playerLocAfterMove.getPrice();
                        player.setCash(player.getCash() - price);
                        playerLocAfterMove.setOwner(player);
                    }
                }
                // TODO after every turn, print Player's info by calling showPlayerInfo(Player player)
            }
        }


    }


    public static boolean isGameContinue() {
        for (Player player : players) {
            if (player.getCash() <= 0) {
                return false;
            }
        }
        return true;
    }

    public String showPlayerInfo(Player player) {
        return "Player " + player.getName() + " is currently on: " +
                locations.get(player.getCurrLocationIndex()).getName() +
                " and has " + player.getCash() + "$ money";
    }
}
