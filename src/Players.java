import java.util.*  ;
public class Players {
    ArrayList<Player> allPlayers = new ArrayList<>();
    String playersFile;

    Players(){
        // uses playersfile to read in and create allplayers arraylist
    }

    void addPlayer(Player p) {
        allPlayers.add(p);
    }

    void savePlayers() {
     // write to file
    }

    public Player findPlayer(Player p) {
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i) == p) {
                return allPlayers.get(i);
            }
        }
        System.out.println("Player does not exist");
        return null;
    }


}