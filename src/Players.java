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


    // takes in a name and returns associated player or an error msg and null
    public Player findPlayer(String name) {
        for (int i = 0; i < allPlayers.size(); i++) {
            Player currentPlayer = allPlayers.get(i);

            if (currentPlayer.getName().equals(name)) {
                return allPlayers.get(i);
            }
        }
        System.out.println("Player does not exist");
        return null;
    }


}