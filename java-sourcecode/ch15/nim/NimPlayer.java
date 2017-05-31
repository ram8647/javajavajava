public class NimPlayer implements IPlayer
{   private OneRowNim game;
    public NimPlayer (OneRowNim game) {   
        this.game = game;
    }
    public int move() {   
        int sticksLeft = game.getSticks();
        if (sticksLeft % (game.MAX_PICKUP + 1) != 1)
            return (sticksLeft - 1) % (game.MAX_PICKUP +1);
        else {
            int maxPickup = Math.min(game.MAX_PICKUP, sticksLeft);
            return 1 + (int)(Math.random() * maxPickup);
        }
    }
    public String makeAMove(String prompt) {   
        return ""+ move();
    }
    public String toString() {
        String className = this.getClass().toString(); // returns 'class NimPlayerBad'
        return className.substring(5);                 // cut off the word 'class'
    }
} // NimPlayer
