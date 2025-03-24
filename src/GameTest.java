import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testRequestCodeLetterMode() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0,"Empty",false);
        Game game = new Game(player, false); // false = letter mode
        String code = game.requestCode();

        assertNotNull(code, "Code should not be null.");
        assertTrue(code.matches("[a-zA-Z]+"), "Code should contain only alphabetical characters.");
        assertEquals(8, code.length(), "Code length should be 8 characters.");
    }

    @Test
    public void testRequestCodeNumberMode() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0,"Empty",false); //initialize object called player with its initial values
        Game game = new Game(player, true); // true = number mode
        String code = game.requestCode(); // provides the game code for its respective version

        assertNotNull(code, "Code should not be null.");
        assertTrue(code.matches("\\d+"), "Code should be numeric.");
        assertEquals(8, code.length(), "Code length should be 8 characters.");
    }

    @Test
    public void testRequestLettersMissingFileCode() {
        String invalidFilePath = "cs207-main/invalid.txt";
        boolean exceptionThrown = false;

        // handles the exception thrown
        try {
            new LettersCode(invalidFilePath);
        } catch (RuntimeException e) {
            exceptionThrown = true;
            // Validate the exception message
            assertEquals("Error: File not found.", e.getMessage(), "File wasn't found.");
        }
        // Ensure an exception was actually thrown
        assertTrue(exceptionThrown, "A RuntimeException should have been thrown for the missing file.");
    }

    @Test
    public void testPlayerEntersGuess() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0,"Empty",false);
        Game game = new Game(player, true);
        game.code = "12345678";
        String res = game.enterGuess("12435678");
        assertNotNull(res, "This result should not be null.");



        assertEquals("Bulls: 6 Cows: 2", res, "The result should return the correct number of Bulls and Cows.");
        // play game with correct code so that it ends
        // this line adds "1234" as sytem input
        System.setIn(new ByteArrayInputStream("12345678\n".getBytes()));
        game.playGame();

        assertEquals(1, player.getCodesAttempted(), "Player's attempted codes count should be incremented.");
    }

    @Test
    public void testPlayerEntersCorrectGuess() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0,"Empty",false);
        Game game = new Game(player, true);
        game.code = "12345678";

        String res = game.enterGuess("12345678");
        assertNotNull(res, "This result should not be null");
        assertEquals("Well Done You Are Right", res, "The result should indicate the correct guess.");

        // play game with correct code so that it ends
        // this line adds "1234" as sytem input
        System.setIn(new ByteArrayInputStream("12345678\n".getBytes()));
        game.playGame();

        assertEquals(1, player.getCodesDeciphered(), "Player's deciphered codes count should be incremented.");
    }

    @Test
    public void testInvalidGuessLength() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0,"Empty",false);
        Game game = new Game(player, true);
        game.code = "1234";

        String shortGuessRes = game.enterGuess("12");
        String longGuessRes = game.enterGuess("12345");

        assertEquals("Guess must be 8 characters long", shortGuessRes, "The result indicates the guess is too short.");
        assertEquals("Guess must be 8 characters long", longGuessRes, "The result indicates the guess is too long.");
    }

    //one or more bulls
    @Test
    public void testForOneOrMoreBulls() {
        Player player = new Player("TestPlayer", 0, 0, 0, 0, 0, "Empty", false);
        Game game = new Game(player, true);
        game.code = "12345678";
        String res = game.enterGuess("12897054"); // 2 bulls

        player.incrementCodesAttempted();
        assertEquals(2, player.getBulls(), "Bulls count should be increased");
        assertEquals(1, player.getCodesAttempted(), "The total number of guesses should increase");
    }

    //one or more cows
    @Test
    public void testForOneOrMoreCows() {
        Player player = new Player("TestPlayer", 0, 0, 0, 0, 0, "Empty", false);
        Game game = new Game(player, true);
        game.code = "12345678";
        String res = game.enterGuess("87654321"); // 8 cows

        player.incrementCodesAttempted();
        assertEquals(8, player.getCows(), "An update should be made to the cow count");
        assertEquals(1, player.getCodesAttempted(), "The total number of guesses should increase");
    }

    //no cows
    @Test
    public void testForNoCows() {
        Player player = new Player("TestPlayer", 0, 0, 0, 0, 0, "Empty", false);
        Game game = new Game(player, false);
        game.code = "abcdefgh";
        String res = game.enterGuess("ijklmnop"); // guess, with no cows

        player.incrementCodesAttempted();
        assertEquals(0, player.getCows(), "Cows attempts should stay the same");
        assertEquals(1, player.getCodesAttempted(), "The total number of guesses should increasee");
    }
    //no bulls
    @Test
    public void testForNoBulls() {
        Player player = new Player("TestPlayer", 0, 0, 0, 0, 0, "Empty", false);
        Game game = new Game(player, false);
        game.code = "abcdefgh";
        String res = game.enterGuess("abcdefgh"); //no bulls

        player.incrementCodesAttempted();
        assertEquals(0, player.getBulls(), "Bulls attempts should stay the same");
        assertEquals(1, player.getCodesAttempted(), "The total number of guesses should increase");
    }

    // display stats when game's been played, here we ensure the player has played at least one game and the correct number of attempts and games are recorded
    @Test
    public void testForDisplayStatWithGamesPlayed() {
        Player player = new Player("TestPlayer", 5, 10, 20, 5, 2, "Empty", false);
        Game game = new Game(player, true);

        assertTrue(player.getCodesAttempted() > 0, "player should play at least one game");
        assertEquals(5, player.getCodesAttempted(), "number of attempts should be displayed correctly");
        assertEquals(2, player.getCodesDeciphered(), "number of solved codes should be displayed correctly");
    } 

    // display stat with NO game played, here we make sure that the games attempted remains zero has no games has been attempted
    @Test
    public void testForDisplayStatWithNoGamesPlayed() {
        Player player = new Player("TestPlayer", 0, 0, 0, 0, 0, "Empty", false);
        Game game = new Game(player, true);

        assertEquals(0, player.getCodesAttempted(), "Player should have no games played");
    }

}
