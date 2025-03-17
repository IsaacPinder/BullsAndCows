import java.util.*  ;
public class Player {
    String username;
    int numberOfBulls;
    int numberOfCows;
    int numCharTotal;
    int codesAttempted;
    int codesDeciphered;

    String savedCode;

    boolean savedCodeisNum;


    public Player(String name, int numBull, int numCow, int numChar, int codesAttempt, int codesDeciph, String savCode, boolean savCodeNum){
        username = name;
        numberOfBulls = numBull;
        numberOfCows = numCow;
        numCharTotal = numChar;

        codesAttempted = codesAttempt;
        codesDeciphered = codesDeciph;

        savedCode = savCode;
        savedCodeisNum = savCodeNum;
    }

    void updateBulls(int newBulls) {
        numberOfBulls += newBulls;
    }

    void updateCows(int newCows) {
        numberOfCows += newCows;
    }

    void updateNumCharTotal(int newChar) {
        numCharTotal += newChar;
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

    int getNumCharTotal(){return numCharTotal;}

    int getCodesAttempted() {
        return codesAttempted;
    }

    int getCodesDeciphered() {
        return codesDeciphered;
    }

    String getName(){ return username;}

    void saveCode(String code, boolean codeTypeNum){
        savedCode = code;
        savedCodeisNum = codeTypeNum;
    }

    String getSavedCode(){return savedCode;}
    boolean getSavedCodeIsNum(){return savedCodeisNum;}

}


