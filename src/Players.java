import java.util.*;
import java.io.*;
public class Players {
    ArrayList<Player> allPlayers = new ArrayList<>();
    String playersFile = "players.txt";


    Players() {
        loadPlayersFromFile();
    }
// loads players details from the file
    private void loadPlayersFromFile() {
        // BufferedReader is closes after loading all the data from the playersFile into the arraylist allPlayers
        try (BufferedReader buffer = new BufferedReader(new FileReader(playersFile))) {
            // variable to store each line from the file
            String line;
            // Read each line from the file until the end of file
            while ((line = buffer.readLine()) != null) {
                // splitting up the line by using commas to store the player data
                String[] dataToLoad = line.split(",");
                // Ensure line has correct amount of values
                if (dataToLoad.length == 8) {
                    //loading in all the variables values in the file
                    String username = dataToLoad[0];
                    int numberOfBulls = Integer.parseInt(dataToLoad[1]);
                    int numberOfCows = Integer.parseInt(dataToLoad[2]);
                    int numCharTotal = Integer.parseInt(dataToLoad[3]);
                    int codesAttempted = Integer.parseInt(dataToLoad[4]);
                    int codesDeciphered = Integer.parseInt(dataToLoad[5]);
                    String savedCode = dataToLoad[6];
                    boolean saveCodeIsNum = Boolean.parseBoolean(dataToLoad[7]);


                    // Create a new Player object with loaded data and add it to the arraylist allPlayers
                    allPlayers.add(new Player(username, numberOfBulls, numberOfCows, numCharTotal, codesAttempted, codesDeciphered,savedCode,saveCodeIsNum));
                }
            }
        } catch (IOException e) {
            //handles issue of not being able to read and then load
            throw new RuntimeException("Error: players File not found.");

        }
    }

    void addPlayer(Player p) {
        allPlayers.add(p);
    }
// write player details to the file
    void savePlayers() {
        // bufferwriter does a write operation to the file and closes once buffer is filled or writer is closed
        try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(playersFile))) {
            // Loops through each player in the arraylist allplayers
            for (Player p : allPlayers) {
                // Write player's data in a line like name,bulls,cows,charstotal,codesattempts,codesdeciphered
                writeFile.write(p.getName() + "," +
                        p.getBulls() + "," +
                        p.getCows() + "," +
                        p.getNumCharTotal() + "," +
                        p.getCodesAttempted() + "," +
                        p.getCodesDeciphered() + "," +
                        p.getSavedCode() + "," +
                        p.getSavedCodeIsNum());
                // Move to the next line after writiing all the players data
                writeFile.newLine();
            }
            // print statement to show the write was done properly
            System.out.println("Players saved successfully to file.");
        } catch (IOException e) {
            // error message when program unable to save the players data
            throw new RuntimeException("Error: players File not found.");
        }
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


    void topTen(){
     int count = 0;
        for (int i = 0; i < allPlayers.size() && i < 10; i++) {

           System.out.println((i + 1)  + " name : " + allPlayers.get(i).getName() + " codes deciphered: " + allPlayers.get(i).getCodesDeciphered());
           count ++;
        }

        for (int i = count; i < 10 ; i++) {
            System.out.println((i + 1) + " name :        codes deciphered: ");
        }

        System.out.println();

    }

   int getArraySize(){
      return  allPlayers.size();
   }

   Player getPlayer(int i){
        return allPlayers.get(i);
   }


}
