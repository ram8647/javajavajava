/*
 * File: NimPlayerBad.java
 * Author: Java, Java, Java
 * Description: This class implements the IPlayer interface, meaning
 *  it implements the makeAMove() method in a way that is appropriate
 *  for a two-player OneRowNim game. In this case the IPlayer takes
 *  a random number of sticks, which is not a "good" way to play the game.
 */
public class NimPlayerBad implements IPlayer {   
    private OneRowNim game;  // Reference used to get information from the game.

    /**
     * NimPlayerBad() constructor is given a reference to the
     *  OneRowNim game.
     * @param a reference to the OneRowNim game
     */
    public NimPlayerBad (OneRowNim game) {  
        this.game = game;
    } // NimPlayerBad()

    /**
     * makeAMove() defines this player's move given the situation in the game.
     * @param the prompt is a String that  provides information for the player. 
     *   In this case the prompt information is ignored.
     * @return a String describing the player's move.
     */
    public String makeAMove(String prompt) {   
        return "" + randomMove();
    } // makeAMove()

    /**
     * randomMove() is a helper method that calculates a random but valid number
     *   of sticks that can be removed.
     * @return a int that gives the number of sticks to remove.
     */
    private int randomMove() {   
        int sticksLeft = game.getSticks();
        return 1 + (int)(Math.random() * Math.min(sticksLeft, game.MAX_PICKUP));
    } // randomMove()

    /**
     * toString() provides a String representation of this player.
     * @return a String containing the name of the class.
     */
    public String toString() { 
        String className = this.getClass().toString(); // Gets 'class NimPlayerBad'
        return className.substring(5);                 // Cut off the word 'class'
    } // toString()
} // NimPlayerBad
