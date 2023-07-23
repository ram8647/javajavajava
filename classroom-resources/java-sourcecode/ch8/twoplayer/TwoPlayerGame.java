/*
 * File: TwoPlayerGame.java
 * Author: Java, Java, Java
 * Description: This abstract class is the root class of
 *  the TwoPlayerGame hierarchy. It is meant to be overridden
 *  by specific TwoPlayerGames, such as OneRowNim and WordGuess.
 * Subclasses must implement the gameOver() and getWinner() methods
 *  and override the getRules() method.
 */
public abstract class TwoPlayerGame {   
    public static final int PLAYER_ONE = 1;  // Class constants
    public static final int PLAYER_TWO = 2;

    protected boolean onePlaysNext = true;    // Player 1 plays next
    protected int nComputers = 0;             // How many computer players
    protected IPlayer computer1, computer2;   // Computers are IPlayers
 
    /**
     * setPlayer() sets which player makes the first move.
     * @param starter, an int representing PLAYER_ONE or PLAYER_TWOI
     */
    public void setPlayer(int starter) {   
	if (starter == PLAYER_TWO)
            onePlaysNext = false;
        else onePlaysNext = true;
    } //setPlayer()

    /**
     * getPlayer() returns an int representing whose turn it it.
     * @return an int representing PLAYER_ONE or PLAYER_TWO.
     */
    public int getPlayer() {   
	if (onePlaysNext) 
	    return PLAYER_ONE;
        else return PLAYER_TWO;
    } //getPlayer()

    /**
     * changePlayer() toggles between PLAYER_ONE or PLAYER_TWO.
     */
    public void changePlayer() {   
	onePlaysNext = !onePlaysNext;
    } //changePlayer

    /**
     * getNComputers() returns the number of computers playing
     * @return an int representing the number of computer players
     */
    public int getNComputers() {
	return nComputers;
    }

    /**
     * getRules() returns a String describing the rules of the game.
     * @return a String giving the game's rules.
     */
    public String getRules() {
        return "The rules of this game are: ";
    }

    /**
     * addComputerPlayer() adds to the number of computer players.
     * @param player is an IPlayer
     */
    public void addComputerPlayer(IPlayer player) {
        if (nComputers == 0)
	    computer2 = player;
        else if (nComputers == 1)
            computer1 = player;
        else 
	    return; // No more than 2 players
        ++nComputers;
    }

    /**
     * gameOver() defines when the game is over. It is meant to be
     *   implemented in subclasses.
     */
    public abstract boolean gameOver();  // Abstract Methods

    /**
     * getWinner() defines who wins the game. It is meant to be 
     *   implemented in subclasses.
     */
    public abstract String getWinner();
} //TwoPlayerGame
