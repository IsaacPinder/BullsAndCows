import java.util.*  ;
public class Player {
String username;
int numberOfBulls;
int numberOfCows;
int codesAttempted;
int codesDeciphered;

    public Player(String name, int numBull, int numCow, int codesAttempt, int codesDeciph){
        username = name;
        numberOfBulls = numBull;
        numberOfCows = numCow;
        codesAttempted = codesAttempt;
        codesDeciphered = codesDeciph;
    }

    void updateBulls(int newBulls) {
      numberOfBulls += newBulls;
    }

    void updateCows(int newCows) {
      numberOfCows += newCows;
    }

    void incrementCodesAttempted() {
        codesAttempted += 1;
    }

    void incrementCodesDeciphered() {
        codesDeciphered += 1;
    }

    int getBulls() {
        return numberOfBulls;
    }

    int getCows() {
        return numberOfCows;
    }

    int getCodesAttempted() {
        return codesAttempted;
    }

    int getCodesDeciphered() {
        return codesDeciphered;
    }
}
