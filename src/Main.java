import java.util.*  ;

import java.util.*  ;
public class Main {
    public static void main(String[] args) {

        boolean gameModeNum;
        boolean done = false;

        // arr will be populated from read in file
        Players PlayersArr = new Players();

        // define so in scope for if-else and while
        Player currentPlayer = null;

        // Temp Players added to array
       /* Player JohnDoe = new Player("John Doe", 8, 10, 16, 2,2,"Empty",false);
        Player JaneDoe = new Player("Jane Doe", 16, 5, 24, 5,2,"1234",true);
        PlayersArr.addPlayer(JohnDoe);
        PlayersArr.addPlayer(JaneDoe);
*/

        // take in name
        System.out.println("Enter your player name to load details\n");
        String input = new java.util.Scanner(System.in).nextLine();

        // if player does not exist then create new player
        if (PlayersArr.findPlayer(input) == null) {
            System.out.println("Creating new player");
             currentPlayer = new Player(input, 0, 0, 0, 0,0,"Empty",false);
            PlayersArr.addPlayer(currentPlayer);
        }
        else {
             currentPlayer = PlayersArr.findPlayer(input);
        }

        // print found players details
        System.out.println("Welcome " + currentPlayer.getName());


        while (!done) {

            System.out.println("Enter a Number to do operation\n 0:quit \n 1:start-game Numbers-Mode \n 2:start-game Letters-Mode\n 3:view-statistics \n 4:load-saved-code \n 5:view top ten");

            input = new java.util.Scanner(System.in).nextLine();

            switch (input) {
                case "0":
                    done = true;
                    break;
                case "1":
                    gameModeNum = true;
                    Game NumGame = new Game(currentPlayer, gameModeNum);
                    NumGame.playGame();
                    break;
                case "2":
                    gameModeNum = false;
                    Game LetGame = new Game(currentPlayer, gameModeNum);
                    LetGame.playGame();
                    break;
                case "3":


                    // default values for stats when no game has been played
                    float cowAcc = 0;
                    float bullAcc = 0;
                    float succRate = 0;

                    if(currentPlayer.getCodesAttempted() == 0){
                        System.out.println("You havent played any games");
                    }
                    else {


                        // if the player has played a game(num total chars >0) then calculate bull/cow accuracy as percent
                        if (currentPlayer.numCharTotal > 0) {
                            bullAcc = ((float) currentPlayer.getBulls() / currentPlayer.getNumCharTotal()) * 100;
                            cowAcc = ((float) currentPlayer.getCows() / currentPlayer.getNumCharTotal()) * 100;
                            succRate = ((float) currentPlayer.getCodesDeciphered() / currentPlayer.getCodesAttempted()) * 100;
                        }

                        System.out.println("Codes Attempt :" + currentPlayer.getCodesAttempted() + " Codes Deciphered :"
                                + currentPlayer.getCodesDeciphered() + " TotalBulls :" + currentPlayer.getBulls() +
                                " TotalCows :" + currentPlayer.getCows() +
                                "\nBullAcuracy :" + bullAcc + "%  CowAccuracy :" + cowAcc + "%  SuccessRate :" + succRate + "% ");
                    }
                    break;

                case "4":

                    // if current player does not have saved code
                    if(currentPlayer.getSavedCode().equals("Empty")){
                        System.out.println("You dont have a code saved");
                    }
                    // load game with code and game mode retireved from player
                    else {
                        gameModeNum = currentPlayer.savedCodeisNum;
                        Game loadedGame = new Game(currentPlayer, gameModeNum);
                        loadedGame.loadGame(currentPlayer.getSavedCode());
                    }

                    break;

                case "5":
                    boolean atleastOneStatsStored = false;
                            int i = 0;
                    while(!atleastOneStatsStored && i < PlayersArr.getArraySize()){
                        if(PlayersArr.getPlayer(i).getCodesDeciphered() > 0){
                            atleastOneStatsStored = true;
                        }
                        i ++;
                    }

                    if (atleastOneStatsStored == true){
                        PlayersArr.topTen();
                    }
                    else{
                        System.out.println("no one has completed a game yet");
                    }

                    break;

                default:
                    System.out.println("Please input a valid command number");
            }
            // write updated array to file
            PlayersArr.savePlayers();
        }
        System.out.println("Exiting");

    }
}

