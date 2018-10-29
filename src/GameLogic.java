import java.util.*;

public class GameLogic {

    private static List<Player> players = new ArrayList<>();
    private static List<Location> locations = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Enter the number of players you want :");

        Scanner scn = new Scanner(System.in);

        int playerNum = scn.nextInt();
        // TODO add limit 2..4

        for(int i = 1; i < playerNum+1; i++) {
            // TODO show "enter Player1 name dialog to use to choose
            players.add(new Player("i" + i));
        }

        //TODO create locations
        HashMap<Integer, String> locationMap = new HashMap<>();
        locationMap.put(1,"START");
        locationMap.put(2,"LISBON");
        locationMap.put(3,"PERU");
        locationMap.put(4,"ATHENS");
        locationMap.put(5,"ISTANBUL");
        locationMap.put(6,"JAIL");
        locationMap.put(7,"HONGKONG");
        locationMap.put(8,"LONDON");
        locationMap.put(9,"TAX");
        locationMap.put(10,"MOSCOW");
        locationMap.put(11,"TOKYO");

        for (Map.Entry eachLocation : locationMap.entrySet()) {
            Location loc = new Location((String) eachLocation.getValue());
            loc.setLocationIndex((int) eachLocation.getKey());
            locations.add(loc);
        }

        // TODO
        while(isGameContinue()) {
            for (Player player : players) {
                // TODO add check if user is not in Jail
                // player rolls dice
                int diceResult = Dice.getRandomFromFirstDice() + Dice.getRandomFromSecondDice();
                System.out.println("Dice result: " + diceResult);
                // TODO check indexes (outofbonds, eg 11 + 4)
                player.setLocation(player.getLocation().getLocationIndex() + diceResult);

                // if location is owned by another player, pay the rent
                // TODO OR if location is tax, decrease player's cash (taxing)
                // TODO OR if location is jail, take player to the jail
                // TODO OR show option dialog to user if he/she want to buy property or not
                if (player.getLocation().isLocationOwned()) {
                    int rentAmount = player.getLocation().getRentPrice(); // calculate rent price
                    player.setCash(player.getCash() - rentAmount); // decrease leaseholder player's cash
                    player.getLocation().getOwner().setCash(player.getLocation().getOwner().getCash() + rentAmount); // increase owner player's cash
                } else {
                    Scanner scn2 = new Scanner(System.in);
                    System.out.println("Do you want to buy this location? (Y/n):");
                    System.out.println("Price:"+ player.getLocation().getPrice());
                    String userChoice = scn2.nextLine();
                    if (userChoice.equals("Y") || userChoice.equals("y")) {
                        int price = player.getLocation().getPrice();
                        player.setCash(player.getCash() - price);
                        player.getLocation().setOwner(player);
                    }
                }
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
}
