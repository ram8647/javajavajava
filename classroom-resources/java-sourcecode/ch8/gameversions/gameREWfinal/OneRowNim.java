public class OneRowNim extends TwoPlayerGame implements
    CLUIPlayable, ComputerPlayable
{   public static final int MAX_PICKUP = 3;
    public static final int MAX_STICKS = 11;
    
    private int nSticks = MAX_STICKS;

    public OneRowNim()
    {
    } //OneRowNim() constructor1

    public OneRowNim(int sticks)
    {   nSticks = sticks;
    }  // OneRowNim() constructor2

    public OneRowNim(int sticks, int starter)
    {   nSticks = sticks;
        setPlayer(starter);
    }  // OneRowNim() constructor3

    public String getRules() {
        return "\n*** The Rules of One Row Nim ***\n" +
        "(1) A number of sticks between 7 and " + MAX_STICKS + " is chosen.\n" + 
        "(2) Two players alternate making moves.\n" + 
        "(3) A move consists of subtracting between 1 and\n\t" + 
            MAX_PICKUP + " sticks from the current number of sticks.\n" + 
        "(4) A player who cannot leave a positive\n\t" + 
        " number of sticks for the other player loses.\n";
    }

    public boolean takeSticks(int num)
    {   if (num < 1 || num > MAX_PICKUP || num > nSticks) 
	    return false;                // Error
        else                             // Valid move
        {   nSticks = nSticks - num;
            return true;
	} //else
    }//takeSticks

    public int getSticks()
    {   return nSticks;
    } //getSticks

    /** From TwoPlayerGame */
    public boolean gameOver()
    {   return (nSticks <= 0);
    } // gameOver()

    /** From TwoPlayerGame */
    public String getWinner()
    {   if (nSticks < 1) // Game is over
        {   return "Player " + getPlayer();
        } else
            return "The game is not over yet.";
    } // getWinner()

    /** From CLUIPlayable */
    public String prompt() {
        return "\nYou can pick up between 1 and " +
            Math.min(MAX_PICKUP,nSticks) + " : ";
    }

    /** From CLUIPlayable */
    public String reportState()
    {   return ("\nSticks left: " + getSticks() +
                 " Who's turn: Player " + getPlayer());
    }   // reportState()

    /** From CLUIPlayable */
    public String move(String s)
    {   int sticks = Integer.parseInt(s);
        String str = "Player " + getPlayer() +
                " takes " + sticks + " sticks.\n";
        if (takeSticks(sticks))
        {   changePlayer();
            return str;
	      } else
            return "Oops: " + sticks + " is an illegal move.\n";
    } //move()


    /** From ComputerPlayable */
    public String computerMove()
    {   //Implements a mathematical strategy for OneRowNim
        int sticksLeft = getSticks();
        if (sticksLeft <= 0) return "ERROR - no sticks left?\n";
        int sticksToTake;
        if (sticksLeft % (MAX_PICKUP + 1) != 1)
            sticksToTake = (sticksLeft - 1) % (MAX_PICKUP +1);
        else
        {   int maxPickup = Math.min(MAX_PICKUP, sticksLeft);
            sticksToTake = 1 + (int)(Math.random() * maxPickup);
        }//else
        if (takeSticks(sticksToTake))
        {   changePlayer();
            return "Smart computer takes " + sticksToTake
                 + " sticks.\n";
        } else
            return "ERROR - computer tried to take " +
                sticksToTake + " sticks.\n";
    } //computerMove()

    /**
    * A OneRowNim Keyboard Application Program
    */
    public static void main(String args[]) {
         OneRowNim game = new OneRowNim(OneRowNim.MAX_STICKS);
         CLUIGamePlayer gp = new CLUIGamePlayer(game);
         System.out.println("\nTwo Persons playing One Row Nim");
         gp.play();

         game = new OneRowNim(OneRowNim.MAX_STICKS);
         ComputerPlayable gameCP = (ComputerPlayable)game;
         gp = new CLUIGamePlayer(game, gameCP);
         System.out.println("\n\n\n\nPerson vs smart computer.");
         gp.play();

         game = new OneRowNim(OneRowNim.MAX_STICKS);
         ComputerPlayable randCP =
             (ComputerPlayable)(new OneRowNimRandomPlayer(game));
         gameCP = (ComputerPlayable)game;
         gp = new CLUIGamePlayer(game, randCP, gameCP);
         System.out.println("\n\n\n\nRandom vs. smart computer.");
         gp.play();
    } //main()
    
} // OneRowNim class
