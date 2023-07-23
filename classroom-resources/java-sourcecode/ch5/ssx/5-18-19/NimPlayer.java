/*
 * File: NimPlayer.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 5-18.
 * 
 * Problem: Implement a class called NimPlayer that incorporates the
 *  move() method designed in this section. Follow the design shown 
 *  in Figure 5.9.
 *
 * NOTE: This class must have access to OneRowNim class in order to compile.
 */

public class NimPlayer
{   
    private OneRowNim nim;   // Reference to the OneRowNim game

    /**
     * NimPlayer() constructor sets the reference to the OneRowNim game.
     * @param game -- a reference to the OneRowNim game.
     */
    public NimPlayer (OneRowNim game)
    {   nim = game;
    } // NimPlayer()

    /**
     * move() determines the computer's move and returns it as an int.
     *  This version returns a random number between 1 and the minimum
     *  of either the number of sticks left of the maximum number that
     *  can be picked up.
     */
    public int move() 
    {   int sticksLeft = nim.getSticks();
        if (sticksLeft % (nim.MAX_PICKUP + 1) != 1)
            return (sticksLeft - 1) % (nim.MAX_PICKUP +1);
        else 
        {   int maxPickup = Math.min(nim.MAX_PICKUP, sticksLeft);
            return 1 + (int)(Math.random() * maxPickup);
        } // else
    } // move()
} // NimPlayer
