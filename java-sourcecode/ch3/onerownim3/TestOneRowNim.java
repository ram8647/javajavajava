/*
 * File: TestOneRowNim.java
 * Author: Java Java Java
 * Description: This main program tests the newest version of OneRowNim.
 *   It uses a while-loop to play a game with 11 sticks until the game is
 *   over.
 */

import java.util.Scanner;  
  
public class TestOneRowNim
{
    public static void main(String argv[])
    {   Scanner sc = new Scanner(System.in);
        OneRowNim game = new OneRowNim(11);
        while(game.gameOver() == false) 
        {   game.report();  // Prompt the user
            System.out.print("Input 1, 2, or 3: ");
            int sticks = sc.nextInt(); // Get move
            game.takeSticks(sticks);   // Do move
            System.out.println();
        } // while
        game.report();  // The game is now over
        System.out.print("Game won by player ");
        System.out.println(game.getWinner());
     } // main()
} // TestOneRowNim
