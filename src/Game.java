import java.util.* ;

// Note: Game acts as the middleman between the Ui and other classes
// therefore Game will not print directly but return strings that the Ui will display
public class Game {
Player currentPlayer;
// connects player to game for saving/load
Map<Player, Game> playerGameMapping = new HashMap<Player, Game>();
//true if gamemode is number else false
Boolean gameModeNum;
String code;

    public Game(Player p, Boolean codeType) {
        // reading playerGameMapping from file
        currentPlayer = p;
        gameModeNum = codeType;
        code = requestCode();
    }


    public void getHint() {
    }

    public Player loadPlayer() {
        return currentPlayer;
    }

    public void playGame() {


    }

   public String requestCode() {
        // if gamemodenum true get numberscode else letterscode
       if(gameModeNum == true){
           NumbersCode  numCode = new NumbersCode();
           return numCode.getCode();
       }
       else{
           LettersCode letCode = new LettersCode("validWords.txt");
           return letCode.getCode();
       }
    }

    public String enterGuess(String guess) {
        //returns appropriate feedback string/errormsg use
        // gameModeNum to handle appripriately per game mode
        //maybe make some methods to help(e.g count bulls/cows)
        return "";
    }

    public void saveGame() {
// Writes playergameMapping to file
    }

    public void loadGame() {
// reads playergameMapping from file
    }

    public String showSolution() {
// Shows the correct code
        return code;
    }
}