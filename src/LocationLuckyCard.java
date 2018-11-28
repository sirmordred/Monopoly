import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LocationLuckyCard extends Location {

    private int prices[] = {-500,-400,-300,-200,-100,100,200,300,400,500};
    private static List<Integer> luckyCardLocations = new ArrayList<>(); // Save multiple luckycard's location in one instance(static)

    public LocationLuckyCard(String name, int locationIndex) {
        super(name, locationIndex);
        luckyCardLocations.add(locationIndex);
    }

    public static List<Integer> getLuckyCardLocations() {
        return luckyCardLocations;
    }

    public void imFeelingLucky(Player player, List<Location> locations) {
        int ret = (int)((Math.random() * 2));
        switch (ret) {
            case 0:
                luckyChangeCash(player);
                break;
            case 1:
                luckyTakePlayerToTheJail(player);
                break;
            case 2:
                luckyTakePlayerToAnotherLocation(player, locations, false);
                break;
                default:
                    break;
        }
    }

    public void luckyChangeCash(Player player) {
        int rndIndex = new Random().nextInt(prices.length);
        int rndPrice = prices[rndIndex];
        if(rndPrice < 0) {
            System.out.println("You take a lucky card and your cash has been decreased by "
                    + rndPrice + "$");
        } else {
            System.out.println("You take a lucky card and your cash has been increased by "
                    + rndPrice + "$");
        }
        player.setCash(player.getCash()+rndPrice);
    }

    public void luckyTakePlayerToTheJail(Player player) {
        System.out.println("Lucky card : You are in jail now.");
        player.setInJail(true);
        player.setCurrLocationIndex(LocationJail.jailLocationIndex);
    }

    public void luckyTakePlayerToAnotherLocation(Player player, List<Location> locations, boolean isTest) {
        int goToJailLocation = LocationJail.goToJailLocationIndex;
        List<Integer> luckyCardLocations = LocationLuckyCard.getLuckyCardLocations();
        int random;
        do {
            random = (int)((Math.random() * locations.size()));
        } while ((goToJailLocation == random)
                || luckyCardLocations.contains(random)); // do not allow to take player into another jail or luckycard location which can create infinite loop
        System.out.println("You take a lucky card and you are now on: "
                + locations.get(random).getName());
        player.setCurrLocationIndex(random);

        // Make necessary actions on new location

        Location playerLocAfterMove = locations.get(random);
        System.out.println("You are now on " + playerLocAfterMove.getName().toUpperCase());

        if (!isTest) {
            if (playerLocAfterMove instanceof LocationTaxAdmin) {
                LocationTaxAdmin playerLocAfterMove2 = (LocationTaxAdmin) playerLocAfterMove;
                player.setCash(player.getCash()-playerLocAfterMove2.getTaxPrice());
                System.out.println(player.getName()+" paid " + playerLocAfterMove2.getTaxPrice()
                        +"$ You now have "+ player.getCash());
            } else if (playerLocAfterMove instanceof LocationCity){
                LocationCity playerLocAfterMove1 = (LocationCity) playerLocAfterMove;
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
                            player.getOwnedLocations().add(playerLocAfterMove1);
                            System.out.println(player.getName()+" bought location:"+playerLocAfterMove1.getName()+" and remaining money is:"+player.getCash());
                        }

                    }
                }
            }
        }
    }
}
