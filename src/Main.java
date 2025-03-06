import java.util.*  ;
public class Main {
    public static void main(String[] args) {

        boolean gameModeNum;
        boolean done = false;

        Players PlayersArr = new Players();

        // Temp Players added to array
        Player JohnDoe = new Player("John Doe", 10, 20, 5, 5);
        Player JaneDoe = new Player("Jane Doe", 2, 2, 2, 2);
        PlayersArr.addPlayer(JohnDoe);
        PlayersArr.addPlayer(JaneDoe);


        // take in name
        System.out.println("Enter your player name to load details\n");
        String input = new java.util.Scanner(System.in).nextLine();

        // if player does not exist then create new player
        if (PlayersArr.findPlayer(input) == null) {
            System.out.println("Creating new player");
            Player currentPlayer = new Player(input, 0, 0, 0, 0);
            PlayersArr.addPlayer(currentPlayer);
        }
        // print found players details
        else {


            Player currentPlayer = PlayersArr.findPlayer(input);
            System.out.println("Codes Attempt :" + currentPlayer.getCodesAttempted() + " Codes Deciphered :"
                    + currentPlayer.getCodesDeciphered() + " TotalBulls :" + currentPlayer.getBulls() +
                    " TotalCows :" + currentPlayer.getCows());

        }

            while (!done) {

                System.out.println("Enter a Number to do operation\n 0:quit \n 1:start-game Numbers-Mode \n 2:start-game Letters-Mode\n");

                input = new java.util.Scanner(System.in).nextLine();

                switch (input) {
                    case "0":
                        done = true;
                        break;
                    case "1":
                        gameModeNum = true;
                        Game NumGame = new Game(JohnDoe, gameModeNum);
                        NumGame.playGame();
                        break;
                    case "2":
                        gameModeNum = false;
                        Game LetGame = new Game(JohnDoe, gameModeNum);
                        LetGame.playGame();
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
