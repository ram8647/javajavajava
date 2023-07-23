public class NimPlayerBad implements IPlayer {   
    private OneRowNim game;
    public NimPlayerBad (OneRowNim game) {  
        this.game = game;
    }
    public String makeAMove(String prompt) {   
        return "" + randomMove();
    }
    private int randomMove() {   
        int sticksLeft = game.getSticks();
        return 1 + (int)(Math.random() * Math.min(sticksLeft, game.MAX_PICKUP));
    }
    public String toString() {
        String className = this.getClass().toString(); // returns 'class NimPlayerBad'
        return className.substring(5);                 // cut off the word 'class'
    }
} // NimPlayerBad
