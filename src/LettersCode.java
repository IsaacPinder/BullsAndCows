import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LettersCode extends SecretCode {
//lc stands for "LettersCode", but you can name it anything and we using it cuz It calls the constructor LettersCode("issac.txt"), which reads the file and prints a random word.
     //   LettersCode LettersCode = new LettersCode("lettercode.txt"); // or new LettersCode("lettercode.txt");
    public LettersCode(String filename) {
        ArrayList<String> words = readFile(filename); // Read file into list
        if (!words.isEmpty()) {
            String decipheredCode = getRandomWord(words);
            System.out.println("Deciphered Code: " + decipheredCode);
        } else {
            System.out.println("Error: File is empty or not found."); //
        }
    }

    private ArrayList<String> readFile(String filename) {
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new java.io.File(filename)); // Read file
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().toLowerCase()); // Store words in LOWERCASE ISSSAC
            }
            scanner.close();
        } catch (Exception e) { // Handle errors when file not found
            System.out.println("Error: File not found.");
        }
        return words;
    }

    // Picks a random word from the arraylist
    private String getRandomWord(ArrayList<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size())); // Return random word
    }
}
