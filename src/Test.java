import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.assertEquals;

@Test
public void testRequestLettersCode() {
    gameModeNum = false;
    Game LetGame = new Game(JohnDoe,gameModeNum);
    LetGame.playGame();

    assertNotNull(Game.requestCode(), "Secret code should not be null.");
    assertTrue(LettersCode.words.Contains(Game.input), "Secret code should be one of the stored words.");
    assertEquals(1, Player.incrementCodesAttempted(), "Number of secret code attempts should be updated.");
}

@Test
public void testRequestNumbersCode() {
    gameModeNum = true;
    Game LetGame = new Game(JohnDoe,gameModeNum);
    LetGame.playGame();

    assertNotNull(Game.requestCode(), "Secret code should not be null.");
    assertTrue(Game.input.matches("//d+"), "Secret code should only contain digits.");
    assertEqual(Game.input.chars().distinct().count(), Game.input.length(), "Secret code should only contain unique digits.");
    assertEquals(1, Player.incrementCodesAttempted(), "Number of secret code attempts should be updated.");
}

@Test
public void testRequestLettersMissingFileCode() {

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
