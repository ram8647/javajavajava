public abstract class TwoPlayerGame
{   private boolean onePlaysNext = true;

    public void setPlayer(int starter)
    {   if (starter == 2)
            onePlaysNext = false;
        else onePlaysNext = true;
    } //setPlayer()

    public int getPlayer()
    {   if (onePlaysNext) return 1;
        else return 2;
    } //getPlayer()

    public void changePlayer()
    {   onePlaysNext = !onePlaysNext;
    } //changePlayer

    public abstract boolean gameOver();
    public abstract int getWinner();

} //TwoPlayerGame