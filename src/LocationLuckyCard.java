public class LocationLuckyCard extends Location {


    public LocationLuckyCard(String name, int locationIndex) {
        super(name, locationIndex);
    }

    public static void imFeelingLucky(Player player) {
        int ret = (int)((Math.random() * 2));
        switch (ret) {
            case 0:
                // TODO call function to add/remove cash from Player's current cash
                // quantity will be randomly selected
                break;
            case 1:
                System.out.println("Lucky card : You are in jail now.");
                player.setInJail(true);
                break;
            case 2:
                // TODO call function to move Player lcoation by random number
                break;
            default:
                //
                break;
        }
    }
}
