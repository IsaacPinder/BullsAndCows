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
    // sort array list by codesDeciphered
    void sortPlayers() {
        int size = allPlayers.size();
        int i;
        int j;
        Player temp;
        boolean swapped;
        //using bubble sort for the structure
        for (i = 0; i < size - 1; i++) {
            swapped = false;
            for (j = 0; j < size - i - 1; j++) {
                //and using the if statement
                if (allPlayers.get(j).getCodesDeciphered() < allPlayers.get(j + 1).getCodesDeciphered()) {
                    // Swap arr[j] and arr[j+1] just like regular bubble just with the allplayers
                    temp = allPlayers.get(j);
                    allPlayers.set(j, allPlayers.get(j + 1));
                    allPlayers.set(j + 1, temp);
                    swapped = true;
                }
            }
            //this is just so if no 2 elements are swapped we can end incase we have a pre sorted list or we at the end
            if (swapped == false)
                break;
         }
    }

}