public abstract class TwoPlayerGame extends Game
{   public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;

    protected boolean onePlaysNext = true;
    protected boolean computerIsPlayer = false;

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

} //TwoPlayerGame
