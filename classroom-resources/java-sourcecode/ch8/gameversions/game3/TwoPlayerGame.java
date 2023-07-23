public abstract class TwoPlayerGame
{   public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;

    private boolean onePlaysNext = true;

    public void setPlayer(int starter)
    {   if (starter == PLAYER_TWO)
            onePlaysNext = false;
        else onePlaysNext = true;
    } //setPlayer()

    public int getPlayer()
    {   if (onePlaysNext) return PLAYER_ONE;
        else return PLAYER_TWO;
    } //getPlayer()

    public void changePlayer()
    {   onePlaysNext = !onePlaysNext;
    } //changePlayer

    public String getRules() {
        return "The rules of this game are: ";
    }
    public abstract boolean gameOver();
    public abstract int getWinner();

    public abstract String report();
    public abstract String move (String s);
} //TwoPlayerGame
