import java.util.*  ;
public class Main {
    public static void main(String[] args) {

        boolean gameModeNum ;
        boolean done = false;
        Player  JohnDoe = new Player("John Doe",0,0,0,0);

        while(!done){

            System.out.println("Enter a Number to do operation\n 0:quit \n 1:start-game Numbers-Mode \n 2:start-game Letters-Mode\n");

            String input = new java.util.Scanner(System.in).nextLine();

            switch(input){
                case "0":
                    done = true;
                    break;
                case "1":
                    gameModeNum = true;
                    Game NumGame = new Game(JohnDoe,gameModeNum);
                    NumGame.playGame();
                    break;
                case "2":
                    gameModeNum = false;
                    Game LetGame = new Game(JohnDoe,gameModeNum);
                    LetGame.playGame();
                    break;

                default:
                    System.out.println("Please input a valid command number");
            }

        }
        System.out.println("Exiting");

    }
}