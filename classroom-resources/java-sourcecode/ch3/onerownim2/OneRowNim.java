/*
 * File: OneRowNim.java
 * Author: Java Java Java
 * Description: This version of OneRowNim includes several constructor
 *  methods and several instance methods.
 */

public class OneRowNim
{   private int nSticks = 7;         // Start with 7 sticks
    private int player = 1;          // Player 1 plays first

    public OneRowNim()
    {   nSticks = 7;
        player = 1;
    }

    public OneRowNim(int sticks)
    {   nSticks = sticks;
    }

    public OneRowNim(int sticks, int starter)
    {   nSticks = sticks; // Set the number of sticks
        player = starter; // Set who starts
    }

    /** 
     * takeSticks() will remove num sticks
     * @param num -- the number of sticks to remove.
     */
    public void takeSticks(int num)
    {   nSticks = nSticks - num;
        player = 3 - player;
    }  // takeSticks()

    public int getSticks()
    {   return nSticks;
    }

    public int getPlayer()
    {   return player;
    }

    public boolean gameOver()
    {   return (nSticks <= 0);
    }

    public void report()
    {   System.out.println("Number of sticks left: " + nSticks);
        System.out.println("Next turn by player " + player);
    } // report()

    public static void main(String[] args) 
    {   OneRowNim game = new OneRowNim(13,2);
        game.takeSticks(2);
        System.out.print("The game is over is: ");
        System.out.println(game.gameOver());
        System.out.print("The next turn is by player: ");
        System.out.println(game.getPlayer());
        System.out.print("Sticks remaining: ");
        System.out.println(game.getSticks());
    } // main()
} // OneRowNim class
