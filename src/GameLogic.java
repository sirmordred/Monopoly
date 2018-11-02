import java.util.*;

public class GameLogic {

    private static List<Player> players = new ArrayList<>();
    private static List<Location> locations = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Scanner scnline = new Scanner(System.in);
        int totalPlayerNum;

        do{
            System.out.println("Enter the number of players you want :");
            totalPlayerNum=scn.nextInt();
            if (totalPlayerNum<2 || totalPlayerNum>4){
                System.out.println("Error: Player number must between 2..4");
            }
        } while (totalPlayerNum<2 || totalPlayerNum>4);


        for(int i = 1; i < totalPlayerNum+1; i++) {
            System.out.println("Enter Player"+i +" name: " );
            String name = scnline.nextLine();

            players.add(new Player(name + i));
        }

        // Create locations and add them to the locations arraylist
        locations.add(new Location("START", 0));
        locations.add(new Location("LISBON", 1));
        locations.add(new Location("PERU", 2));
        locations.add(new Location("ATHENS", 3));
        locations.add(new Location("ISTANBUL", 4));
        locations.add(new Location("JAIL", 5));
        locations.add(new Location("HONGKONG", 6));
        locations.add(new Location("LONDON", 7));
        locations.add(new Location("TAX", 8));
        locations.add(new Location("MOSCOW", 9));
        locations.add(new Location("TOKYO", 10));

        while(isGameContinue()) {
            for (Player player : players) {
                if(player.isInJail()){
                    continue;
                }
                // player rolls dice
                int diceResult = Dice.  getRandomFromFirstDice() + Dice.getRandomFromSecondDice();
                System.out.println("Dice result: " + diceResult);
                // TODO check indexes (outofbonds, eg 11 + 4)
                int playerNewLocationIndex = player.getCurrLocationIndex() + diceResult;
                if (playerNewLocationIndex > locations.size()){
                    playerNewLocationIndex=(playerNewLocationIndex % locations.size())-1;
                }
                player.setCurrLocationIndex(playerNewLocationIndex);
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
