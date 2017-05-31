/*
 * File: OneRowNim.java
 * Author: Java, Java, Java
 * Description: This verstion of OneRowNim uses a boolean
 *   variable to keep track of who plays next.
 */

public class OneRowNim
{    private int nSticks = 7;
     private boolean onePlaysNext = true;  // Who plays next

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
         onePlaysNext = (starter == 1);
     }  // OneRowNim() constructor3

    /**
     * takeSticks() removes num sticks.
     * @param num, the number of sticks to be removed
     *   should be between 1 and 3 inclusive and no greater
     *   than nSticks, the number of sticks remaining.
     */
     public boolean takeSticks(int num)
     {   if (num < 1 || num > 3 || num > nSticks) 
             return false;                // Error
         else                             // Valid move
         {   nSticks = nSticks - num;
             onePlaysNext = !onePlaysNext;
             return true;
         } //else
     } // takeSticks()

    /**
     * getSticks() returns number of sticks remaining.
     */
     public int getSticks()
     {   return nSticks;
     } // getSticks()}

    /**
     * getPlayer() returns whose turn it is as an int value.
     */
     public int getPlayer()
     {   if (onePlaysNext) return 1;
         else return 2;
     } // getPlayer()

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
     {   if (nSticks < 1) return getPlayer();
         else return 0;  // game is not over
     } // getWinner()

    /**
     * report() prints the current state of the game.
     */
     public void report()
     {   System.out.println("Number of sticks left: " 
                             + getSticks());
         System.out.println("Next turn by player " 
                             + getPlayer());
     }   // report()
} // OneRowNim class
