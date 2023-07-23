public abstract class TwoPersonCLIGame extends TwoPlayerGame
{   private PlayableCLI pcli;
    private KeyboardReader kb;

    public TwoPersonCLIGame()
    {   pcli = ((PlayableCLI)this);
        kb = new KeyboardReader();
    }//TwoPersonCLIGame

    public void play()
    {   pcli.initCLI(kb);
        while (!gameOver())
        {   pcli.displayCLI(kb);
            if (pcli.moveCLI(kb))
                changePlayer();
        } //while
        pcli.finishCLI(kb);
    }//play()
}//TwoPersonCLIGame class
