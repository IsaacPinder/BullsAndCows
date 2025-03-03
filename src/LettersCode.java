public class LettersCode extends SecretCode {
String file;
    LettersCode(String file){
        // deciphered code = a word read from file
        //if file not exist create and populate one (maybe make method for it to avoid repeats for version below)
        decipheredCode = "scot";
    }

    LettersCode(){
    // same as above but no file specified so create one and fill with words(leave for now)
    }

}
