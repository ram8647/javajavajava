/*
 * File: OneRowNim.java
 * Author: Java, Java, Java
 * Description: This version of OneRowNim uses class constants
 *   (static final variables) to define certain elements of the state.
 */

public class OneRowNim
{   public static final int PLAYER_ONE = 1;  // Class constants
    public static final int PLAYER_TWO = 2;
    public static final int MAX_PICKUP = 3;
    public static final int MAX_STICKS = 11;
    public static final boolean GAME_OVER = false;

    private int nSticks = MAX_STICKS;
    private boolean onePlaysNext = true; // Who plays next

    /**
     * OneRowNim() default constructo4
     */
    public OneRowNim()
    {
    } //OneRowNim() constructor1

    /**
     * OneRowNim() constructor allows initial number
     *  of sticks to be set.
     * @param sticks, the initial number of sticks
     */
     public OneRowNim(int sticks)
     {   nSticks = sticks;
     }  // OneRowNim() constructor2

    /**
     * OneRowNim() constructor allows initial number
     *  of sticks and initial player to be set.
     * @param sticks, the initial number of sticks
     * @param starter, the initial player
     */
     public OneRowNim(int sticks, int starter)
     {   nSticks = sticks;
         onePlaysNext = (starter == PLAYER_ONE);
     }  // OneRowNim() constructor3

    /**
     * takeSticks() removes num sticks.
     * @param num, the number of sticks to be removed
     *   should be between 1 and 3 inclusive and no greater
     *   than nSticks, the number of sticks remaining.
     */
     public boolean takeSticks(int num)
     {   if (num < 1 || num > MAX_PICKUP || num > nSticks) 
             return false;                // Error
         else                             // Valid move
         {   nSticks = nSticks - num;
             onePlaysNext = !onePlaysNext;
             return true;
         } //else
     }//takeSticks()

    /**
     * getSticks() returns number of sticks remaining.
     */
     public int getSticks()
     {   return nSticks;
     } //getSticks()

    /**
     * getPlayer() returns whose turn it is as an int value.
     */
     public int getPlayer()
     {   if (onePlaysNext) 
             return PLAYER_ONE;
         else return PLAYER_TWO;
     } //getPlayer()

    /**
     * gameOver() returns true if no sticks remain.
     */
     public boolean gameOver()
     {   return (nSticks <= 0);
     } // gameOver()

    /**
     * getWinner() returns the winning player as an int.
     */
     public int getWinner()
     {   if (nSticks < 1) 
             return getPlayer();
         else return 0;         // Game is not over
     } // getWinner()

    /**
     * report() prints the current state of the game.
     */
     public String report()
     {   return ("Number of sticks left: " + getSticks()
          + "\nNext turn by player " + getPlayer() + "\n");
     }   // report()
} // OneRowNim class
