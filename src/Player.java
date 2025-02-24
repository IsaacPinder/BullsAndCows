import java.util.*  ;
public class Player {
String username;
int numberOfBulls;
int numberOfCows;
int codesAttempted;
int codesDeciphered;

    void updateBulls(int newBulls) {
      numberOfBulls += newBulls;
    }

    void updateCows(int newCows) {
      numberOfCows += newCows;
    }

    void incrementCodesAttempted() {
        codesAttempted += 1;
    }

    void incrementCodesDeiphered() {
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

