import java.util.*;

public class GameLogic {

    private static List<Player> players = new ArrayList<>();
    private static List<Location> locations = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Scanner scnline = new Scanner(System.in);
        Scanner scnUnused = new Scanner(System.in);
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

            players.add(new Player(name)); // TODO make sure user didnt enter same name which can create problems
        }

        // Create locations and add them to the locations arraylist
        locations.add(new Location("START", 0)); // STARTING LOCATION
        locations.add(new LocationCity("LISBON", 1,
                500, 100, null));
        locations.add(new LocationCity("PERU", 2,
                500, 100, null));
        locations.add(new LocationCity("ATHENS", 3,
                500, 100, null));
        locations.add(new LocationCity("ISTANBUL", 4,
                500, 100, null));
        locations.add(new LocationJail("JAIL", 5)); // JAIL LOCATION
        locations.add(new LocationCity("HONGKONG", 6,
                500, 100, null));
        locations.add(new LocationCity("LONDON", 7,
                500, 100, null));
        locations.add(new LocationTaxAdmin("TAX", 8, 250)); // TAX ADMINISTRATION LOCATION
        locations.add(new LocationCity("MOSCOW", 9,
                500, 100, null));
        locations.add(new LocationCity("TOKYO", 10,
                500, 100, null));

        while(isGameContinue()) {
            for (Player player : players) {
                System.out.println("Player "+player.getName()+"'s turn");
                if(player.isInJail()) {
                    System.out.println(player.getName()+" is in jail.");
                    player.setInJail(false); // for exiting from jail on the next round
                    continue;
                }
                System.out.println("Press any key to roll dice");
                scnUnused.nextLine();
                // player rolls dice
                Dice dice1 = new Dice();
                Dice dice2 = new Dice();
                dice1.generateRandomValFromDice();
                dice2.generateRandomValFromDice();

                int diceResult = Dice.getDiceResult(); // get static dice result
                Dice.setDiceResult(0);
                System.out.println("Dice result: " + diceResult);
                int playerNewLocationIndex = player.getCurrLocationIndex() + diceResult;

                if (playerNewLocationIndex > locations.size()){
                    playerNewLocationIndex = (playerNewLocationIndex % locations.size()) - 1;
                }
                player.setCurrLocationIndex(playerNewLocationIndex);
                int playerLocIndexAfterMove = player.getCurrLocationIndex();
                Location playerLocAfterMove = locations.get(playerLocIndexAfterMove);
                System.out.println("You are now on " + playerLocAfterMove.getName().toUpperCase());

                // TODO (optional) if player passes STARTing location, give some cash to player or not(optional)
                if (playerLocAfterMove instanceof LocationJail) {
                    // TODO OR if location is jail, take player to the jail
                    LocationJail playerLocAfterMove1 = (LocationJail) playerLocAfterMove;
                } else if (playerLocAfterMove instanceof LocationTaxAdmin) {
                    // TODO if location is tax, decrease player's cash (taxing)
                    LocationTaxAdmin playerLocAfterMove1 = (LocationTaxAdmin) playerLocAfterMove;
                } else if (playerLocAfterMove instanceof LocationLuckyCard) {
                    // TODO if location is LuckyCard, call imFeelingLucky() function
                    LocationLuckyCard playerLocAfterMove1 = (LocationLuckyCard) playerLocAfterMove;
                    //LocationLuckyCard.imFeelingLucky(); //TODO control this function in game.
                } else if (playerLocAfterMove instanceof LocationCity){
                    LocationCity playerLocAfterMove1 = (LocationCity) playerLocAfterMove;// TODO Location cannot be cast to LocationCity start block is location
                    if (playerLocAfterMove1.isLocationOwned()) {
                        int rentAmount = playerLocAfterMove1.getRentPrice(); // calculate rent price
                        player.setCash(player.getCash() - rentAmount); // decrease leaseholder player's cash
                        playerLocAfterMove1.getOwner().setCash(playerLocAfterMove1.getOwner().getCash() + rentAmount); // increase owner player's cash
                    } else {
                        Scanner scn2 = new Scanner(System.in);
                        System.out.println("You have: " + player.getCash() + "$ and "
                                + playerLocAfterMove1.getName().toUpperCase()
                                + "'s price: "+ playerLocAfterMove1.getPrice() + "$");
                        System.out.println("Do you want to buy this location? (Y/n):");
                        String userChoice = scn2.nextLine();
                        if (userChoice.equals("Y") || userChoice.equals("y")) {
                            int price = playerLocAfterMove1.getPrice();
                            if (player.getCash() < price){
                                System.out.println("Sorry, You don't have enough money.");
                            } else {
                                player.setCash(player.getCash() - price);
                                playerLocAfterMove1.setOwner(player);
                                System.out.println(player.getName()+" bought location:"+playerLocAfterMove1.getName()+" and remaining money is:"+player.getCash());
                            }

                        }
                    }
                }
                //showPlayerInfo(player); TODO do not show player info for now
                System.out.println("\n**********************\n");
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

    public static void showPlayerInfo(Player player) {
        System.out.println("Player " + player.getName() + " is currently on: " +
                locations.get(player.getCurrLocationIndex()).getName() +
                " and has " + player.getCash() + "$ money");
    }
}
