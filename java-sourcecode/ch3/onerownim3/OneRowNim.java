/*
 * File: OneRowNim.java
 * Author: Java Java Java
 * Description: This version of OneRowNim includes several constructor
 *  methods and several instance methods and it uses an if-else structure
 *  in its takeSticks() method.
 */
public class OneRowNim 
{   private int nSticks = 7;
    private int player = 1;

    public OneRowNim() 
    {
    } // OneRowNim() constructor

    public OneRowNim(int sticks) 
    {   nSticks = sticks;
    }  // OneRowNim() constructor2

    public OneRowNim(int sticks, int starter) 
    {   nSticks = sticks;
        player = starter;
    }  // OneRowNim() constructor3

    public boolean takeSticks(int num) 
    {   if (num < 1) return false;       // Error
        else if ( num > 3) return false; // Error
        else              // this is a valid move
        {   nSticks = nSticks - num;
            player = 3 - player;
            return true;
        } // else
    } // takeSticks()

    public int getSticks() 
    {   return nSticks;
    } // getSticks()

    public int getPlayer() 
    {   return player;
    } // getPlayer()

    public boolean gameOver()
    {   return (nSticks <= 0);
    } // gameOver()

    public int getWinner()
    {   if (nSticks < 1) return getPlayer();
        else return 0;  //game is not over
    } // getWinner()
    
    public void report()
    {   System.out.println("Number of sticks left: " + getSticks());
        System.out.println("Next turn by player " + getPlayer());
    }   // report()
} // OneRowNim class
