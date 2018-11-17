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

    public static void imFeelingLucky(Player player) {
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
                int random = (int)((Math.random() * 10));
                if(random == 5){ //TODO BURA INDEXE GORE DEGISECEK
                    while (random==5){
                        random = (int)((Math.random() * 10));
                    }
                }
                System.out.println("You take a lucky card and your location changed by  :" );//TODO gelen random indexin sehir ismini yazdir
                player.setCurrLocationIndex(random);
                // TODO tekrar luckycard'a veya hapise gelebilir ona göre ayarlamalar yap
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
