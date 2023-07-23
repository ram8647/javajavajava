/*
 * File: NimPlayer.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 8.13.
 * Problem: Define a NimPlayer class that plays the optimal strategy 
 *  for OneRowNim. The strategy was described in Chapter 5.
 *  It implements the makeAMove() method in a way that is appropriate
 *  for a two-player OneRowNim game. In this case the IPlayer takes
 *  a random number of sticks, which is not a "good" way to play the game.
 */
public class NimPlayer implements IPlayer {   
    private OneRowNim game;

    /**
     * NimPlayer() constructor is given a reference to the OneRowNim game.
     * @param a reference to the OneRowNim game
     */
    public NimPlayer (OneRowNim game) {   
        this.game = game;
    }

    /**
     * move() plays an optimal OneRowNim game
     * @return an int representing the number of sticks to take.
     */
    public int move() {   
        int sticksLeft = game.getSticks();
        if (sticksLeft % (game.MAX_PICKUP + 1) != 1)
            return (sticksLeft - 1) % (game.MAX_PICKUP +1);
        else {
            int maxPickup = Math.min(game.MAX_PICKUP, sticksLeft);
            return 1 + (int)(Math.random() * maxPickup);
        }
    } // move()

    /**
     * makeAMove() is defined as part of the IPlayer interface. It
     *  defines a valid move in the OneRowNim game. Details of the
     *  move are handled by the move() method.
     * @param prompt is a string containing a prompt
     * @return a string describing the move
     */
    public String makeAMove(String prompt) {   
        return ""+ move();
    }

    /**
     * toString() provides a string representation of this object.
     */
    public String toString() {
        String className = this.getClass().toString(); // returns 'class NimPlayerBad'
        return className.substring(5);                 // cut off the word 'class'
    }
} // NimPlayer
