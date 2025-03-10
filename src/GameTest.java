import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testRequestCodeLetterMode() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0);
        Game game = new Game(player, false); // false = letter mode
        String code = game.requestCode();

        assertNotNull(code, "Code should not be null.");
        assertTrue(code.matches("[a-zA-Z]+"), "Code should contain only alphabetical characters.");
        assertEquals(4, code.length(), "Code length should be 4 characters.");
    }

    @Test
    public void testRequestCodeNumberMode() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0); //initialize object called player with its initial values
        Game game = new Game(player, true); // true = number mode
        String code = game.requestCode(); // provides the game code for its respective version

        assertNotNull(code, "Code should not be null.");
        assertTrue(code.matches("\\d+"), "Code should be numeric.");
        assertEquals(4, code.length(), "Code length should be 4 characters.");
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
        Player player = new Player("John Doe", 0, 0, 0, 0,0);
        Game game = new Game(player, true);
        game.code = "1234";
        String res = game.enterGuess("1243");
        assertNotNull(res, "This result should not be null.");
        assertEquals("Bulls: 2 Cows: 2", res, "The result should return the correct number of Bulls and Cows.");
        assertEquals(1, player.getCodesAttempted(), "Player's attempted codes count should be incremented.");
    }

    @Test
    public void testPlayerEntersCorrectGuess() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0);
        Game game = new Game(player, true);
        game.code = "1234";

        String res = game.enterGuess("1234");
        assertNotNull(res, "This result should not be null");
        assertEquals("Well Done You Are Right", res, "The result should indicate the correct guess.");
        assertEquals(1, player.getCodesDeciphered(), "Player's deciphered codes count should be incremented.");
    }

    @Test
    public void testInvalidGuessLength() {
        Player player = new Player("John Doe", 0, 0, 0, 0,0);
        Game game = new Game(player, true);
        game.code = "1234";

        String shortGuessRes = game.enterGuess("12");
        String longGuessRes = game.enterGuess("12345");

        assertEquals("Guess must be 4 characters long", shortGuessRes, "The result indicates the guess is too short.");
        assertEquals("Guess must be 4 characters long", longGuessRes, "The result indicates the guess is too long.");
    }

}
