public class NimPlayer extends Player implements IPlayer
{   private OneRowNim game;
    public NimPlayer (OneRowNim game)
    {   this.game = game;
    }
    public int move() 
    {   int sticksLeft = game.getSticks();
        if (sticksLeft % (game.MAX_PICKUP + 1) != 1)
            return (sticksLeft - 1) % (game.MAX_PICKUP +1);
        else {
            int maxPickup = Math.min(game.MAX_PICKUP, sticksLeft);
            return 1 + (int)(Math.random() * maxPickup);
        }
    }
    public String move(String prompt) 
    {   return ""+move();
    }
} // NimPlayer
