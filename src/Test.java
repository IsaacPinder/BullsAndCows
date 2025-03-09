import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testRequestCodeLetterMode() {
        Player player = new Player("John Doe", 0, 0, 0, 0);
        Game game = new Game(player, false); // false = letter mode
        String code = game.requestCode();

        assertNotNull(code, "Code should not be null.");
        assertTrue(code.matches("[a-zA-Z]+"), "Code should contain only alphabetical characters.");
        assertEquals(4, code.length(), "Code length should be 4 characters.");
    }

    @Test
    public void testRequestCodeNumberMode() {
        Player player = new Player("John Doe", 0, 0, 0, 0);
        Game game = new Game(player, true); // true = number mode
        String code = game.requestCode();

        assertNotNull(code, "Code should not be null.");
        assertTrue(code.matches("\\d+"), "Code should be numeric.");
        assertEquals(4, code.length(), "Code length should be 4 characters.");
    }

    @Test
    public void testRequestLettersMissingFileCode() {
        Player player = new Player("John Doe", 0, 0, 0, 0);

        String invalidFilePath = "cs207-main/invalid.txt";

        Exception exception = assertThrows(RuntimeException.class, () -> {
                LettersCode letCode = new LettersCode(invalidFilePath);
                letCode.getCode();
        });

        assertEquals("File not found: invalid.txt", exception.getMessage(), "The file was not found.");
    }

    @Test
    public void testPlayerEntersGuess() {

    }

    @Test
    public void testPlayerEntersCorrectGuess() {

    }

    @Test
    public void testInvalidGuessLength() {

    }

}
