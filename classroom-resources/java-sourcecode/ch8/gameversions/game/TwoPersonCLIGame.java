public class TwoPersonCLIGame extends TwoPlayerGame
{//   private TwoPlayerGame game;
    private PlayableCLI pcli;
    private KeyboardReader kb;

//    public TwoPersonCLIGame(TwoPlayerGame aGame)
    public TwoPersonCLIGame()
    {//   game = aGame;
//        pcli = ((PlayableCLI)game);
        pcli = ((PlayableCLI)this);
        kb = new KeyboardReader();
    }//TwoPersonCLIGame

    public void play()
    {   pcli.initCLI(kb);
//        while (!game.gameOver())
        while (gameOver())
        {   pcli.displayCLI(kb);
            if (pcli.moveCLI(kb))
//                game.changePlayer();
                changePlayer();
        } //while
        pcli.finishCLI(kb);
    }//play()

}//TwoPersonCLIGame class
