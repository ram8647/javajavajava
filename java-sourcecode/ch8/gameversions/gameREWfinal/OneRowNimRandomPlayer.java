public class OneRowNimRandomPlayer implements ComputerPlayable
{   private OneRowNim game;

    public OneRowNimRandomPlayer (OneRowNim g)
    {   game = g;
    } //OneRowNimRandomPlayer() constructor

    public String computerMove()
    {   int sticksLeft = game.getSticks();
        if (sticksLeft <= 0)
            return "ERROR - No sticks for computer to take.";
        int maxPickup = Math.min(OneRowNim.MAX_PICKUP, sticksLeft);
        int sticksToTake = 1 + (int)(Math.random() * maxPickup);
        if (game.takeSticks(sticksToTake))
        {   game.changePlayer();
            return "Random computer player has taken " +
                sticksToTake + " sticks.\n";
        } else
            return "ERROR - No sticks for computer to take.";
    } //computerMove()

} // OneRowNimRandomPlayer
