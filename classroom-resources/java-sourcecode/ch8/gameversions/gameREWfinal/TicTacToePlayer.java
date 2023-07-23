public class TicTacToePlayer  implements ComputerPlayable
{   private TicTacToe game;

    public TicTacToePlayer (TicTacToe game)
    {   this.game = game;
    }

    public String computerMove()
    {   for (int k = 1; k <= 9; k++) 
        if (game.getSquare(k).equals(game.BLANK))
	      return game.move("" + k);
    return "Error - There are no blank squares\n";
    }
} // TicTacToePlayer
