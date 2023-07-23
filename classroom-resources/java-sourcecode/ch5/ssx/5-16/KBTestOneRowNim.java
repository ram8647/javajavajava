/*
 * File: KBTestOneRowNim.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 5-16.
 * 
 * Problem: Implement a command-line interface, named KBTestOneRowNim
 *  that uses the new version of OneRowNim. Make use of MAX_STICKS
 *  and MAX_PICKUP in the user interface.
 *
 * NOTE: This class must have access to KeyboardReader and OneRowNim
 *  classes in order to compile and run.
 */

public class KBTestOneRowNim
{   
    /**
     * main() creates a KeyboardReader and uses it to
     *  interact with the user as a game of OneRowNim
     *  is played.
     */
    public static void main(String argv[])
    {   KeyboardReader kb = new KeyboardReader();
        OneRowNim game = new OneRowNim(11);
        while(game.gameOver() == false)
        {   kb.prompt(game.report());                // Prompt the user
            kb.prompt("You can pick up between 1 and " + OneRowNim.MAX_PICKUP + " :");
            int sticks = kb.getKeyboardInteger();   // Get move
            game.takeSticks(sticks);                // Do move
            System.out.println();
        } // while
        kb.display(game.report());                  // The game is now over
        System.out.print("Game won by player ");
        System.out.println(game.getWinner());
    } // main()
} // KBTestOneRowNim
