public abstract class ComputerGame {   
    protected int nPlayers;
    protected int addedPlayers = 0;
    protected int whoseTurn;
    protected Player player[];  // An array of players

    public ComputerGame() {
        nPlayers = 1;       // Default: 1 player game
        player = new Player[1];
    }
    public ComputerGame(int n) {
        nPlayers = n;
        player = new Player[n];
    }
    public void setPlayer(int starter)
    {   whoseTurn = starter;
    }
    public int getPlayer() {   
        return whoseTurn;
    }
    public void addPlayer(Player p) {
        player[addedPlayers] = p;
        ++addedPlayers;
    }
    public void changePlayer() {
        whoseTurn = (whoseTurn + 1) % nPlayers;
    }
    public String getRules() {
        return "The rules of this game are: ";
    }
    public String listPlayers() {
        StringBuffer result = new StringBuffer("\nThe players are:\n");
        for (int k = 0; k < nPlayers; k++)
            result.append("Player" + k + " " + player[k].toString() + "\n");
        result.append("\n");
        return result.toString();
    }
    public abstract boolean gameOver();
    public abstract String getWinner();
} //ComputerGame
