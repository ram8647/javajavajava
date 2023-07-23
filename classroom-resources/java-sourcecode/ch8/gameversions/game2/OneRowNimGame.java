public class OneRowNimGame extends TwoPersonCLIGame implements PlayableCLI
{   private int nSticks = 7;

    public OneRowNimGame()
    {
    } //OneRowNimGame() constructor1

    public OneRowNimGame(int sticks)
    {   nSticks = sticks;
    } // OneRowNim() constructor2

    public OneRowNimGame(int sticks, int starter)
    {   nSticks = sticks;
        setPlayer(starter);
    } // OneRowNim() constructor3

    public boolean takeSticks(int num)
    {   if (num < 1 || num > 3 || num > nSticks)
            return false; // Error
        else // Valid move
        {   nSticks = nSticks - num;
            return true;
        } //else
    }//takeSticks

    public void setSticks(int num)
    {   nSticks = num;
    }//setSticks

    public int getSticks()
    {   return nSticks;
    } //getSticks

//*** Implement abstract methods of TwoPlayerGame ***
    public boolean gameOver()
    {   return (nSticks <= 0);
    } // gameOver()

    public int getWinner()
    {   if (nSticks < 1) return getPlayer();
        else return 0; //game is not over
    } //getWinner()

//*** Implement methods of PlayableCLI interface ***
    public void initCLI(KeyboardReader kr)
    {   kr.display("\n*** The Rules of One Row Nim ***\n");
        kr.display("(1) A number of sticks between 7 and 21 is chosen.\n");
        kr.display("(2) Two players alternate making moves.\n");
        kr.display("(3) A move consists of subtracting 1, 2,\n");
        kr.display("   or 3 from the current number of sticks.\n");
        kr.display("(4) A player who cannot leave a positive\n");
        kr.display(" number of sticks for the other player loses.\n");
        int num = -1;
        while ((num < 7) || (num > 21))
        {   kr.prompt("Input a number between 7 and 21:");
            num = kr.getKeyboardInteger();
        }//while
        setSticks(num);
        setPlayer(1);
    } //initCLI()

    public void displayCLI(KeyboardReader kr)
    {   kr.display("\nThere are are now " + nSticks + " sticks.\n");
        kr.display("Player " + getPlayer() + " moves next.\n");
    } //displayCLI()

    public boolean moveCLI(KeyboardReader kr)
    {   int max = 3;
        if (nSticks < 3) max = nSticks;
        kr.prompt("Input a number between 1 and " + max + ": ");
        int num = kr.getKeyboardInteger();
        return takeSticks(num);
    } // moveCLI()

    public void finishCLI(KeyboardReader kr)
    {   kr.display("\nThe game is over and the winner is ");
        kr.display("Player "+getWinner()+". \nCongratulations!\n");
    }//finishCLI()

    public static void main(String[] args)
    { //  TwoPlayerGame game = new  OneRowNimGame();
	//        TwoPersonCLIGame cliGame = new TwoPersonCLIGame(game);
        OneRowNimGame game = new OneRowNimGame();
        game.play();
    } //main()

} //OneRowNimGame class
