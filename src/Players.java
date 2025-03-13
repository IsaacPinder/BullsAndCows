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
                if (dataToLoad.length == 6) {
                    //loading in all the variables values in the file
                    String username = dataToLoad[0];
                    int numberOfBulls = Integer.parseInt(dataToLoad[1]);
                    int numberOfCows = Integer.parseInt(dataToLoad[2]);
                    int numCharTotal = Integer.parseInt(dataToLoad[3]);
                    int codesAttempted = Integer.parseInt(dataToLoad[4]);
                    int codesDeciphered = Integer.parseInt(dataToLoad[5]);
                    // Create a new Player object with loaded data and add it to the arraylist allPlayers
                    allPlayers.add(new Player(username, numberOfBulls, numberOfCows, numCharTotal, codesAttempted, codesDeciphered));
                }
            }
        } catch (IOException e) {
            //handles issue of not being able to read and then load
            System.out.println("Error reading the file: " + e.getMessage());
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
                        p.getCodesDeciphered());
                // Move to the next line after writiing all the players data
                writeFile.newLine();
            }
            // print statement to show the write was done properly
            System.out.println("Players saved successfully.");
        } catch (IOException e) {
            // error message when program unable to save the players data
            System.out.println("Error saving players: " + e.getMessage());
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


}
