/*
 * File: WordGuess.java
 * Author: Java, Java, Java
 * Description:  WordGuess  extends the TwoPlayerGame 
 *  class and implements the CLUIPlayableGame interface, which enables
 *  two players to play using a command-line interface.  It makes 
 *  extensive use of Java's inheritance and polymorphism mechanisms.
 *
 * NOTE: To compile and run this program WordGuess must have access to
 *  all the classes of TwoPlayerGame hierarchy.  One way to do this is
 *  to place all classes in the same directory. Another is to add the
 *  TwoPlayerGame hierarchy to the classpath during compilation and running:
 *    javac -classpath ../twoplayergame:. WordGuess.java
 *    java -classpath ../twoplayergame:. WordGuess
 *  Another way to provide access is to create a jar file containing the
 *  TwoPlayerGame classes and add that to the classpath:
 *     javac -classpath twoplayergame.jar:. WordGuess.java
 *     java -classpath twoplayergame.jar:. WordGuess
 *
*/

import java.io.*;

public class WordGuess extends TwoPlayerGame implements CLUIPlayableGame {
    private String secretWord;            // The word being guessed
    private StringBuffer currentWord;     // The state of the current guesses
    private StringBuffer previousGuesses; // A string of the previous guesses
    private int unguessedLetters;         // Unused letters
    private String[] wordArray;           // An array of secret words
    private int arraySize;                // The number of secret words

    /**
     * WordGuess() default constructor initializes the game. 
     *  The secret words used by the program are read from a file
     *  named "secretwords.txt".
     */
    public WordGuess() {   
        try{
            FileReader fr = new FileReader("secretwords.txt");
            BufferedReader inStream = new BufferedReader(fr);
            String line = inStream.readLine();
            arraySize = Integer.parseInt(line);
            wordArray = new String[arraySize];
            line = inStream.readLine();
            int k = 0;
            while((line != null) && (k < arraySize)){
                wordArray[k] = line;
                line = inStream.readLine();
                k++;
            } // while
            inStream.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } //catch
        secretWord = getSecretWord();
        currentWord = new StringBuffer(secretWord);
        previousGuesses = new StringBuffer();
        for (int k = 0; k < secretWord.length(); k++)
           currentWord.setCharAt(k,'?');
        unguessedLetters = secretWord.length();
    } //WordGuess() constructor

    /**
     * getPreviousGuesses() returns a string containing
     *  all previous letter guesses
     * @return a String containing the guesses
     */
    public String getPreviousGuesses() {
	return previousGuesses.toString();
    } // getPreviousGuesses()

    /**
     * getCurrentWord() returns the current state of the guessed word
     */
    public String getCurrentWord() {
	return currentWord.toString();
    } // getCurrentWord()

    /**
     * getSecretWord() returns a secret word
     */
    private String getSecretWord(){
        int num = (int)(Math.random()*arraySize);
        return wordArray[num];
    } //getSecretWord()

    /**
     * guessLetter() returns true if the letter is in the secret word
     *   and returns false otherwise
     * @param letter is the letter being guessed
     */
    private boolean guessLetter(char letter) {   
	previousGuesses.append(letter);
	if (secretWord.indexOf(letter) == -1)
            return false; // letter is not in secretWord
        else // find positions of letter in secretWord
	{   for (int k = 0; k < secretWord.length(); k++)
            {   if (secretWord.charAt(k) == letter)
                {   if (currentWord.charAt(k) == letter)
                        return false; ////already guessed
                    currentWord.setCharAt(k,letter);
                    unguessedLetters--; //one less to find
                } //if
            } //for
            return true;
        } //else
    } //guessLetter()

    /**
     * getRules() is overridden from the TowPlayerGame class. It
     *  returns a String giving the games rules.
     * @return a String describing the game
     */
    public String getRules() {      // Overridden from TwoPlayerGame
        return "\n*** The Rules of Word Guess ***\n" +
        "(1) The game generates a secret word.\n" +
        "(2) Two players alternate taking moves.\n" +
        "(3) A move consists of guessing a letter in the word.\n" +
        "(4) A player continues guessing until a letter is wrong.\n" +
        "(5) The game is over when all letters of the word are guessed\n" +
        "(6) The player guessing the last letter of the word wins.\n";
    } //getRules()

    /** 
     * gameOver() is defined as abstract in TwoPlayerGame
     *  and implemented here. A WordGuess game is over when
     *  all the letters in the word have been guessed
     * @return true if the game is over and false otherwise
     */
    public boolean gameOver() {   // From TwoPlayerGame
        return (unguessedLetters <= 0);
    } // gameOver()

    /** 
     * getWinner() is defined as abstract in TwoPlayerGame
     *  and implemented here. It defines who wins WordGuess.
     * @return a String describing the winner
     */
    public String getWinner() {  // From TwoPlayerGame
        if (gameOver())
            return "Player " + getPlayer();
        else return "The game is not over.";
    } // getWinner()

    /**
     * reportGameState() is implemented as part of the CLUIPlayableGame interface.
     *  It describes the current state of the game.
     * @return a String describing the game's current state.
     */
    public String reportGameState() {   
        if (!gameOver())
            return "\nCurrent word " + currentWord.toString() + " Previous guesses " 
                + previousGuesses + "\nPlayer " + getPlayer() + " guesses next.";
        else
	    return "\nThe game is now over! The secret word is " + secretWord 
              + "\n" + getWinner() + " has won!\n";
    } // reportGameState()

    /** 
     * getGamePrompt() is implemented as part of the CLUIPlayableGame interface.
     *  It defines the prompt presented to the user before each move.
     * @return a String giving the prompt.
     */
    public String getGamePrompt() {    // From CLUIPlayableGame
        return "\nGuess a letter that you think is in the secret word: ";
    } // getGamePrompt()

    /**
     * move() defines one move of the WordGuess game.
     * @param s is a String giving the move, in this case a single
     *   letter at s.charAt(0) which is the guessed letter.
     * @return a message describing the outcome of the move
     */
    public String move(String s) {   
        char letter = s.toUpperCase().charAt(0);
        if (guessLetter(letter)) {   //if correct 
            return "Yes, the letter " + letter + " IS in the secret word\n";
         } else {   
             changePlayer();
             return "Sorry, " + letter + " is NOT a " + "new letter in the secret word\n";
         } 
    } // move()

    /**
     * play() is implemented as part of the CLUIPlayableGame interface.
     *  It contains the control algorithm for playing the WordGuess game.
     * @param ui gives a reference to the UserInterface where I/O is performed.
     */
    public void play(UserInterface ui) {
        ui.report(getRules());
        if (computer1 != null) 
            ui.report("\nPlayer 1 is a " + computer1.toString());
	if (computer2 != null)
	    ui.report("\nPlayer 2 is a " + computer2.toString());

	while(!gameOver()) {  
           IPlayer computer = null;       // Assume no computers playing
	    ui.report(reportGameState());
            switch(getPlayer()) {
	    case PLAYER_ONE:             // Player 1's turn
		computer = computer1;
		break;
	    case PLAYER_TWO:             // Player 2's turn
		computer = computer2;
		break;
	    } // cases

            if (computer != null) {      // If computer's turn
		ui.report(move(computer.makeAMove("")));
	    } else {                     // otherwise, user's turn
		ui.prompt(getGamePrompt());
                ui.report(move(ui.getUserInput()));
	    }
        } // while
	ui.report(reportGameState());  // The game is now over
    }// play()

    /**
     * main() plays the WordGuess game
    */
    public static void main(String args[])  {  
	KeyboardReader kb = new KeyboardReader();
        WordGuess game = new WordGuess();
        kb.prompt("How many computers are playing, 0, 1, or 2? ");
	int m = kb.getKeyboardInteger();
        for (int k = 0; k < m; k++) {
            IPlayer computer = new WordGuesser(game);
            game.addComputerPlayer(computer);
	}
	//        game.setNComputers(m);
        game.play(kb);
    } //main()

} //WordGuess class
