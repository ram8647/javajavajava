public class TicTacToePlayer extends Player implements IPlayer
{   private TicTacToe game;
    public TicTacToePlayer (TicTacToe game)    {   this.game = game;  }

    public String move(String prompt) 
    {   for (int k = 1; k <= 9; k++) 
        if (game.getSquare(k).equals(game.BLANK))
	    return "" + k;
    return "0";
    }
} // TicTacToePlayer
