public abstract class Game
{   protected int nPlayers;
    protected int whoseTurn;
    protected IPlayer player[];  // An array of players

    public Game() {}
    public Game(int n) {
        nPlayers = n;
    }

    public void setPlayer(int starter)
    {   whoseTurn = starter;
    } //setPlayer()

    public int getPlayer()
    {   return whoseTurn;
    } //getPlayer()

    public String getRules() {
        return "The rules of this game are: ";
    }
    public abstract boolean gameOver();
    public abstract String getWinner();
} //Game
