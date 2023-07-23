/*
 * File: WordGuesser.java
 * Author: Java, Java, Java
 * Description: Defines an IPlayer for the WordGuess game.
 *  It implements the makeAMove() method in a way that is appropriate
 *  for a two-player OneRowNim game. In this case the IPlayer takes
 *  a random number of sticks, which is not a "good" way to play the game.
 */
public class WordGuesser implements IPlayer {   
    private WordGuess game;

    /**
     * WordGuesser() constructor is given a reference to the WordGuess game.
     * @param a reference to the WordGuess game
     */
    public WordGuesser (WordGuess game) {   
      this.game = game;
    }

    /**
     * makeAMove() is defined as part of the IPlayer interface. It
     *  defines a valid move in the WordGuess game. This version simply
     *  picks a random letter from the alphabet.
     * @param prompt is a string containing a prompt
     * @return a string describing the move
     */
    public String makeAMove(String prompt)  {   
        String usedLetters = game.getPreviousGuesses();
        char letter;
        do {  // Pick one of 26 letters
            letter = (char)('A' + (int)(Math.random() * 26));
        } while (usedLetters.indexOf(letter) != -1);
        return "" + letter;
    }

    /**
     * toString() provides a string representation of this object.
     */
    public String toString() { // returns 'NimPlayerBad'
        String className = this.getClass().toString(); 
        return className.substring(5);        
    }
} // WordGuesser
