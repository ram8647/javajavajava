public class OneRowNim
{   public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int MAX_PICKUP = 3;
    public static final int MAX_STICKS = 11;
    public static final boolean GAME_OVER = false;

     private int nSticks = MAX_STICKS;
     private boolean onePlaysNext = true;

     public OneRowNim()
     {
     } //OneRowNim() constructor1
     public OneRowNim(int sticks)
     {   nSticks = sticks;
     }  // OneRowNim() constructor2
     public OneRowNim(int sticks, int starter)
     {   nSticks = sticks;
         onePlaysNext = (starter == PLAYER_ONE);
     }  // OneRowNim() constructor3
     public boolean takeSticks(int num)
     {   if (num < 1 || num > MAX_PICKUP || num > nSticks) 
             return false;                // Error
         else                             // Valid move
         {   nSticks = nSticks - num;
             onePlaysNext = !onePlaysNext;
             return true;
         } //else
     }//takeSticks
     public int getSticks()
     {   return nSticks;
     } //getSticks
     public int getPlayer()
     {   if (onePlaysNext) 
             return PLAYER_ONE;
         else return PLAYER_TWO;
     } //getPlayer
     public boolean gameOver()
     {   return (nSticks <= 0);
     } // gameOver()
     public int getWinner()
     {   if (nSticks < 1) 
             return getPlayer();
         else return 0;         // Game is not over
     } // getWinner()
     public String report()
     {   return ("Number of sticks left: " + getSticks()
		 + "\nNext turn by player " + getPlayer() + "\n");
     }   // report()
} // OneRowNim class
