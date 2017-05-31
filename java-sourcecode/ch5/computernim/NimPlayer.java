public class NimPlayer
{   private OneRowNim nim;
   
    public NimPlayer (OneRowNim game)
    {   nim = game;
    }
    public int move() 
    {   int sticksLeft = nim.getSticks();
        if (sticksLeft % (nim.MAX_PICKUP + 1) != 1)
            return (sticksLeft - 1) % (nim.MAX_PICKUP +1);
        else {
            int maxPickup = Math.min(nim.MAX_PICKUP, sticksLeft);
            return 1 + (int)(Math.random() * maxPickup);
        }
    }
} // NimPlayer
