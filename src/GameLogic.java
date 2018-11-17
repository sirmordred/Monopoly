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
        locations.add(new Location("START", 0)); // STARTING LOCATION //+200 DOLAR TODO
        locations.add(new LocationCity("OLD KENT ROAD", 1,
                60, 10, null));

        locations.add(new LocationCity("OLD KENT ROAD", 2,
                60, 10, null));//TODO LUCKY CARD FOR THIS INDEX

        locations.add(new LocationCity("WHITECHAPEL", 3,
                60, 10, null));

        locations.add(new LocationTaxAdmin("INCOME TAX", 4, 200)); // TAX ADMINISTRATION LOCATION

        locations.add(new LocationCity("KINGS CROSS ", 5,
                200, 40, null));

        locations.add(new LocationCity("THE ANGEL ISLINGTON", 6,
                100, 20, null));

        locations.add(new LocationCity("OLD KENT ROAD", 7,
                60, 10, null));//TODO LUCKY CARD FOR THIS INDEX TOO

        locations.add(new LocationCity("EUSTON ROAD", 8,
                100, 20, null));
        locations.add(new LocationCity("PENTONVILLE ROAD", 9,
                120, 25, null));
        locations.add(new LocationJail("JAIL", 10)); // JAIL LOCATION //TODO LUCKY CARD JAIL INDEXINI DEGIS

        locations.add(new LocationCity("PALL MALL", 11,
                140, 30, null));
        locations.add(new LocationTaxAdmin("ELECTRIC COMPANY", 12, 150)); // TAX ADMINISTRATION LOCATION

        locations.add(new LocationCity("WHITEHALL", 13,
                140, 30, null));
        locations.add(new LocationCity("NORTHUMBERLAND AVENUE", 14,
                160, 35, null));
        locations.add(new LocationCity("MARLEYBONE STATION", 15,
                200, 40, null));
        locations.add(new LocationCity("BOW STREET", 16,
                180, 35, null));
        locations.add(new LocationCity("OLD KENT ROAD", 17,
                60, 10, null));//TODO LUCKY CARD FOR THIS INDEX TOO

        locations.add(new LocationCity("MARLBROROUGH STREET", 18,
                180, 35, null));
        locations.add(new LocationCity("VINE STREET", 19,
                200, 40, null));
        locations.add(new LocationTaxAdmin("FREE PARKING", 20, 0)); // BURADA HICBISEY OLMAMASI DOGRU

        locations.add(new LocationCity("STRANT", 21,
                220, 45, null));
        locations.add(new LocationCity("OLD KENT ROAD", 22,
                60, 10, null));//TODO LUCKY CARD FOR THIS INDEX TOO

        locations.add(new LocationCity("FLEET STREET", 23,
                220, 45, null));
        locations.add(new LocationCity("TRAFALGAR SQUARE", 24,
                240, 50, null));
        locations.add(new LocationCity("FENCHURCH STREET STATION", 25,
                200, 40, null));
        locations.add(new LocationCity("LEICESTER SQUARE", 26,
                260, 55, null));
        locations.add(new LocationCity("COVENTRY STREET", 27,
                260, 55, null));
        locations.add(new LocationTaxAdmin("WATER WORKS", 28, 150));
        locations.add(new LocationCity("PICCADILLY", 29,
                280, 60, null));


        locations.add(new LocationCity("GO TO JAIL", 30,
                260, 55, null));//TODO BURAYA GELINCE 10.INDEXE YANI JAILE GONDERECEK


        locations.add(new LocationCity("REGENT STREET", 31,
                300, 65, null));
        locations.add(new LocationCity("OXFORD STREET", 32,
                300, 65, null));

        locations.add(new LocationCity("OLD KENT ROAD", 33,
                60, 10, null));//TODO LUCKY CARD FOR THIS INDEX TOO

        locations.add(new LocationCity("BOND STREET", 34,
                320, 70, null));

        locations.add(new LocationCity("LIVERPOOL STREET STATION", 35,
                200, 40, null));

        locations.add(new LocationCity("OLD KENT ROAD", 36,
                60, 10, null));//TODO LUCKY CARD FOR THIS INDEX TOO

        locations.add(new LocationCity("PARKLANE", 37,
                350, 75, null));
        locations.add(new LocationTaxAdmin("SUPER TAX", 38, 100));
        locations.add(new LocationCity("MAYFAIR", 39,
                400, 80, null));



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


    private static boolean isGameContinue() {
        for (Player player : players) {
            if (player.getCash() <= 0) {
                System.out.println("Player " + player.getName() + " is bankrupted so eliminated");
                players.remove(player); // TODO check if "removing element from list while iterating on the list" can create problems? or not? (like outofbonds exception)
            }
        }
        if(players.size() == 1) {
            Player winnerPlayer = players.get(0); // TODO check if the last player's(so winner's) index is really 0 ???
            System.out.println("Congratulation!!! Game is over, Player "
                    + winnerPlayer.getName() + " won the game !!!");
            return false;
        } else {
            return true;
        }

    }

    private static void showPlayerInfo(Player player) {
        System.out.println("Player " + player.getName() + " is currently on: " +
                locations.get(player.getCurrLocationIndex()).getName() +
                " and has " + player.getCash() + "$ money");
    }
}
