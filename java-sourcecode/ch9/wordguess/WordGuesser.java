//public class WordGuesser extends Player implements IPlayer {   
public class WordGuesser extends Player  {   
    private WordGuess game;
    public WordGuesser (WordGuess game) {   
	this.game = game;
    }
    public WordGuesser (WordGuess game, int id, int kind) {   
        super(id,kind);
	this.game = game;
    }

    public String makeAMove(String prompt)  {   
	String usedLetters = game.getPreviousGuesses();
        char letter;
	do {
	    letter =  (char)('A' +  (int)(Math.random() * 26));  // Pick one of 26 letters
	} while (usedLetters.indexOf(letter) != -1);
	return "" + letter;
    }

    public String toString() {
        if (kind == HUMAN)
            return "Human";
        String className = this.getClass().toString(); // returns 'class NimPlayerBad'
        return className.substring(5);                 // cut off the word 'class'
    }
} // WordGuesser

