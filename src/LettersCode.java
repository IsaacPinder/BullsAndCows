import java.io.FileNotFoundException;
import java.util.*;


public class LettersCode extends SecretCode {
    // the constructor LettersCode("lettercode.txt"), which reads the file and prints a random word.
    // new LettersCode("lettercode.txt");
    public LettersCode(String filename) {
        ArrayList<String> words = readFile(filename); // Read file into list
        if (words.isEmpty()) {
            throw new RuntimeException("Word list is empty."); // Handles empty file
        }
        decipheredCode = getRandomWord(words);
    }

    private ArrayList<String> readFile(String filename) {
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new java.io.File(filename)); // Read file
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().toLowerCase()); // Store words in LOWERCASE
            }
            scanner.close();
        } catch (FileNotFoundException e) { // Handle errors when file not found
            throw new RuntimeException("Error: File not found.");
        }
        return words;
    }

    // Picks a random word from the arraylist
    private String getRandomWord(ArrayList<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size())); // Return random word
    }
}
