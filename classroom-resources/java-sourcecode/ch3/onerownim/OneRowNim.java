/*
 * File: OneRowNim.java
 * Author: Java Java Java
 * Description: Defines an object that plays OneRowNim. This version
 *   uses a single method to takeSticks().
 */

import java.util.Scanner;         

public class OneRowNim
{   private int nSticks = 7;         // Start with 7 sticks
    private int player = 1;          // Player 1 plays first

    /** 
     * takeSticks() will remove num sticks
     * @param num -- the number of sticks to remove.
     */
    public void takeSticks(int num)
    {   nSticks = nSticks - num;
        player = 3 - player;
    }  // takeSticks()

    public void report()
    {   System.out.println("Number of sticks left: " + nSticks);
        System.out.println("Next turn by player " + player);
    } // report()

    public static void main (String argv[])
    {   Scanner sc;                  // Declare a Scanner variable
        sc = new Scanner(System.in); // Instantiate it
        OneRowNim game;              // Declare a OneRowNim variable
        game = new OneRowNim();      // Instantiate it
        game.report();               // Report state of game
        System.out.println("Input 1, 2, or 3 and hit enter:");
        int num = sc.nextInt();      // Read an int from keyboard
        game.takeSticks(num);        // Use the value read
        game.report();               // Report state of game
    } // main()
} // OneRowNim class
