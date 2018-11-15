public class LocationLuckyCard extends Location {


    public LocationLuckyCard(String name, int locationIndex) {
        super(name, locationIndex);
    }

    public static void imFeelingLucky(Player player) {
        int ret = (int)((Math.random() * 3));
        switch (ret) {
            case 0:
                int random1 = (int )(Math.random() * 400 + 100);
                System.out.println("You take a lucky card and your cash decrease "+random1);
                player.setCash(player.getCash()+random1);
                // quantity will be randomly selected
                break;
            case 1:
                System.out.println("Lucky card : You are in jail now.");
                player.setInJail(true);
                break;
            case 2:
                int random = (int)((Math.random() * 10));
                if(random == 5){
                    while (random==5){
                        random = (int)((Math.random() * 10));
                    }
                }
                System.out.println("You take a lucky card and your location changed by  :" );//TODO gelen random indexin sehir ismini yazdir
                player.setCurrLocationIndex(random);
                break;

            case 3:

                int random2 = (int )(Math.random() * 400 + 100);
                System.out.println("You take a lucky card and your cash decrease "+random2);
                if((player.getCash()-random2)<0){
                    player.setCash(0);
                }
                else {
                    player.setCash(player.getCash() - random2);
                }

            default:
                //
                break;
        }
    }
}
