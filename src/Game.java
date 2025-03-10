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
        // true while main game loop is operational
        boolean running = true;

        // get code
        String gameCode = requestCode();
        System.out.println("Enter Your guess:\nType 'give up' to show the correct code:");

        while (running == true) {
            // take in input from user
            String input = new java.util.Scanner(System.in).nextLine();
            // set input to lowercase to simplify comparison
            input = input.toLowerCase();

            // if input is "give up" display answer and exit game loop
            if (input.equals("give up")){
                System.out.println("the correct code was: "+ showSolution());
                running = false;
            }
            else {
                // enter guess does error checks on guess for both num and letter modes
                // will return a string with either an error msg or the Bulls&Cows
                String output = enterGuess(input);
                // print output from enter guess
                System.out.println(output);

                // if output is the msg for a correct code, exit game
                if (output.equals("Well Done You Are Right")) {
                    running = false;
                }
            }
        }

    }

    public String requestCode() {
        // if gamemodenum true get numberscode else letterscode
        if (gameModeNum == true) {
            NumbersCode numCode = new NumbersCode();
            return numCode.getCode();
        } else {
            LettersCode letCode = new LettersCode("lettercode.txt");
            return letCode.getCode();
        }
    }

    public String enterGuess(String guess) {
        // if number game mode
        if (gameModeNum) {
            if (guess.length() != 4) {
                return ("Guess must be 4 characters long");
            } else if (!isNumeric(guess)) {
                return ("Guess must be numeric characters");
            } else if (repeatChar(guess)) {
                return ("Guess must not have repeated characters");
            } else {
                return (countBullsCows(guess));
            }
        }
        // if letters game mode
        else {
            if (guess.length() != 4) {
                return ("Guess must be 4 characters long");
            } else if (!isalpha(guess)) {
                return ("Guess must be alphabetical characters");
            } else if (repeatChar(guess)) {
                return ("Guess must not have repeated characters");
            } else {
                return (countBullsCows(guess));
            }
        }
    }

        public void saveGame () {
// Writes playergameMapping to file
        }

        public void loadGame () {
// reads playergameMapping from file
        }

        public String showSolution () {
// Shows the correct code
            return code;
        }


        // Helper Functions
        public boolean isNumeric (String input){
        // counts how many numeric characters found
         int numFoundTotal = 0;
            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))){
                    numFoundTotal ++;
                }
            }
            // returns true if all charcters are numeric
            return (numFoundTotal == input.length());
        }

    public boolean isalpha (String input){
        // counts how many numeric characters found
        int numFoundTotal = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))){
                numFoundTotal ++;
            }
        }
        // returns true no charcters are numeric
        return (numFoundTotal == 0);
    }


        public boolean repeatChar (String input){
            // loop through string return true if repeating charcters
            for (int i = 0; i < input.length(); i++) {
                for (int j = 0; j < input.length(); j++) {
                    if (i != j) {
                        if (input.charAt(i) == input.charAt(j)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public String countBullsCows (String input){
            // counts number of Bulls and cows and returns a string with appropiate msg
            int numcows = 0;
            int numbulls = 0;
            for (int i = 0; i < input.length(); i++) {
                if (code.charAt(i) == input.charAt(i)) {
                    numbulls += 1;
                } else if (code.contains("" + input.charAt(i))) {
                    numcows += 1;
                }
            }
            // increments player values
            currentPlayer.updateCows(numcows);
            currentPlayer.updateBulls(numbulls);
            if (numbulls == 4){
                currentPlayer.incrementCodesDeciphered(); // if player gets correct code, update their deciphered codes.
                return("Well Done You Are Right");
            }
            else{
                currentPlayer.incrementCodesAttempted(); // if player gets wrong code, update their attempted codes.
                return ("Bulls: " + numbulls + " Cows: " + numcows);
            }
        }
    }
