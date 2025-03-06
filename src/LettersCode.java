import java.io.File;
import java.io.FileNotFoundException;
import java.util.*  ;


public class LettersCode extends SecretCode {

//usage of"LettersCode" after LettersCode, but you can name it anything and we using it cuz It calls the constructor LettersCode("issac.txt"), which reads the file and prints a random word.
    //  code ->  LettersCode LettersCode = new LettersCode("issac.txt"); // or new LettersCode("issac.txt");

    // The constructor that generates the actual random code from the file
    // Reads the file and returns a random word
    private String getRandomWord(String filename) {
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().toLowerCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // neat for no file
            System.out.println("Error: File not found - " + filename);
            return "Error: No words available";
        }
        // this is neat for edge case of no words in the file if the array itself is empty
        if (words.isEmpty()) {
            return "Error: No words available";
        }

        Random random = new Random();
        return words.get(random.nextInt(words.size())); // Return random word
    }


    public LettersCode(String filename) {
        String decipheredCode = getRandomWord(filename);
        System.out.println("Deciphered Code: " + decipheredCode); // Just for testing
    }


}
