import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocationLuckyCard extends Location {

    private static int prices[] = {-500,-400,-300,-200,-100,100,200,300,400,500};
    private static List<Integer> luckyCardLocations = new ArrayList<>(); // Save multiple luckycard's location in one instance(static)

    public LocationLuckyCard(String name, int locationIndex) {
        super(name, locationIndex);
        luckyCardLocations.add(locationIndex);
    }

    public static List<Integer> getLuckyCardLocations() {
        return luckyCardLocations;
    }

    public static void imFeelingLucky(Player player, List<Location> locations) {
        int ret = (int)((Math.random() * 2));
        switch (ret) {
            case 0:
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
                break;
            case 1:
                System.out.println("Lucky card : You are in jail now.");
                player.setInJail(true);
                player.setCurrLocationIndex(5);
                break;
            case 2:
                List<Integer> jailLocations = LocationJail.getJailLocations();
                List<Integer> luckyCardLocations = LocationLuckyCard.getLuckyCardLocations();
                int random;
                do {
                    random = (int)((Math.random() * locations.size()));
                } while (jailLocations.contains(random)
                        || luckyCardLocations.contains(random)); // do not allow to take player into another jail or luckycard location which can create infinite loop
                System.out.println("You take a lucky card and you are now on: "
                        + locations.get(random).getName());
                player.setCurrLocationIndex(random);
                break;
/* TODO disabled for now (olasılıkların balansını ayarla)
            case 3:

                int random2 = (int )(Math.random() * 400 + 100);
                System.out.println("You take a lucky card and your cash decrease "+random2);
                if((player.getCash()-random2)<0){
                    player.setCash(0);
                }
                else {
                    player.setCash(player.getCash() - random2);
                }
*/
            default:
                break;
        }
    }
}
