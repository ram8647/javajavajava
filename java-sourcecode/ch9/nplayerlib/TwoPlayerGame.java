public abstract class TwoPlayerGame extends ComputerGame {   
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;

    protected boolean onePlaysNext = true;
    protected int nComputers = 0;             // How many computer players
    protected IPlayer computer1, computer2;   // Computers are IPlayers
 
    public void setPlayer(int starter) {   
	if (starter == PLAYER_TWO)
            onePlaysNext = false;
        else onePlaysNext = true;
    } //setPlayer()

    public int getPlayer() {   
	if (onePlaysNext) 
	    return PLAYER_ONE;
        else return PLAYER_TWO;
    } //getPlayer()

    public void changePlayer() {   
	onePlaysNext = !onePlaysNext;
    } //changePlayer

    public int getNComputers() {
	return nComputers;
    }

    public void addComputerPlayer(IPlayer player) {
        if (nComputers == 0)
	    computer2 = player;
        else if (nComputers == 1)
            computer1 = player;
        else 
	    return; // No more than 2 players
        ++nComputers;
    }
    public abstract boolean gameOver();  // Abstract Methods
    public abstract String getWinner();
} //TwoPlayerGame
