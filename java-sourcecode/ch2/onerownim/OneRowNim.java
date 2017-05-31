/*
 * File: OneRowNim.java
 * Author: Java Java Java
 * Description: A class that represents the game of One Row Nim.
 */
public class OneRowNim 
{   private int nSticks = 7; // Start with 7 sticks.
    private int player = 1;  // Player 1 plays first.

    public void takeOne()
    {   nSticks = nSticks - 1;
        player = 3 - player;
    } // takeOne()

    public void takeTwo()
    {   nSticks = nSticks - 2;
        player = 3 - player;
    } // takeTwo()

    public void takeThree()
    {   nSticks = nSticks - 3;
        player = 3 - player;
    } // takeThree()

    public void report()
    {   System.out.println("Number of sticks left: " + nSticks);
        System.out.println("Next turn by player " + player);
    } // report()
} // OneRowNim1 class
