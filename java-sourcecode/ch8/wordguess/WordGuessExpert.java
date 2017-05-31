public class WordGuessExpert implements IPlayer {   
    private WordGuess game;
    private String letters = "ETAIONRHSLGCMFBDGPUKJVWQXYZ";
    private int guess = 0;
    public WordGuessExpert (WordGuess game) {   
	this.game = game;
    }
    public String makeAMove(String prompt)  {   
	String usedLetters = game.getPreviousGuesses();
        char letter;
	do {
            letter = letters.charAt(guess);   // Pick a letter
            ++guess;
	    //	    letter =  (char)('A' +  (int)(Math.random() * 26));  // Pick one of 26 letters
	} while (usedLetters.indexOf(letter) != -1);
	return "" + letter;
    }
    public String toString() {
        String className = this.getClass().toString(); // returns 'class NimPlayerBad'
        return className.substring(5);                 // cut off the word 'class'
    }
} // WordGuesser

