import javax.swing.JFrame;

public class OneRowNim extends TwoPlayerGame implements Playable
{   public static final int MAX_PICKUP = 3;
    public static final int MAX_STICKS = 11;
    
    private int nSticks = MAX_STICKS;


    public OneRowNim()
    {
    } //OneRowNim() constructor1
    public OneRowNim(int sticks)
    {   nSticks = sticks;
    }  // OneRowNim() constructor2
    public OneRowNim(int sticks, int starter)
    {   nSticks = sticks;
        setPlayer(starter);
    }  // OneRowNim() constructor3

    public String getRules() {
        return "\n*** The Rules of One Row Nim ***\n" +
        "(1) A number of sticks between 7 and " + MAX_STICKS + " is chosen.\n" + 
        "(2) Two players alternate making moves.\n" + 
        "(3) A move consists of subtracting between 1 and\n\t" + 
            MAX_PICKUP + " sticks from the current number of sticks.\n" + 
        "(4) A player who cannot leave a positive\n\t" + 
        " number of sticks for the other player loses.\n";
    }

    public boolean takeSticks(int num)
    {   if (num < 1 || num > MAX_PICKUP || num > nSticks) 
	    return false;                // Error
        else                             // Valid move
        {   nSticks = nSticks - num;
            return true;
	} //else
    }//takeSticks

    public int getSticks()
    {   return nSticks;
    } //getSticks

    public String report()
    {   if (!gameOver())
             return ("\nSticks left: " + getSticks() + " Who's turn: Player " + getPlayer());
        else
             return ("\nSticks left: " + getSticks() + " Game over! Winner is Player " + getWinner() +"\n");
    }   // report()

    /** From TwoPlayerGame */
    public boolean gameOver()
    {   return (nSticks <= 0);
    } // gameOver()

    /** From TwoPlayerGame */
    public String getWinner()
    {   if (nSticks < 1) {
	    if (getPlayer() == PLAYER_TWO && computerIsPlayer)
	        return "" + getPlayer() + " That's me. Nice game.";
            else if (getPlayer() == PLAYER_ONE && computerIsPlayer)
                return "" + getPlayer() + " That's you. Nice game.";
            else 
                return "" + getPlayer() + " Nice game.";
        } else 
            return "The game is not over yet.";   // Game is not over
    } // getWinner()

    public void play(GameGUI gui) {
        gui.callBack(this);
    }


    /** From Playable interface */
    public void play(UserInterface ui) {
        IPlayer computer = null;
        int sticks = 0;
        ui.prompt("One Row Nim: Two humans or one human? ");
        int nHumans = Integer.parseInt(ui.getUserInput());
        computerIsPlayer = nHumans == 1; 
        ui.report(getRules());
        if (computerIsPlayer) {
            ui.report("You are player 1 and I am player 2.\n");
            computer = new NimPlayer(this);
	}
	while(!gameOver())
        {  ui.report(report());
           if (getPlayer() == PLAYER_ONE || !computerIsPlayer) 
	    {    ui.prompt(prompt());
                 sticks = Integer.parseInt(ui.getUserInput()); // Get move 
	    } else {
                sticks = Integer.parseInt(computer.move(""));
                ui.report("\nMy move. I take " + sticks + " sticks.\n");
	    }
            if (takeSticks(sticks))
                 changePlayer();
        } // while
	ui.report(report());  // The game is now over
    }

    private String prompt() {
        return "\nYou can pick up between 1 and " + Math.min(MAX_PICKUP,nSticks) + " : ";
    }

    public String move(String s) {
        int sticks = Integer.parseInt(s);
        if (takeSticks(sticks)) {
            changePlayer();
            if (gameOver()) {
                return report() + "\nGame won by player" + getWinner() + "\n";
	    } else {
                return report() + prompt();
	    }
	}
        return "\nOops. " + sticks + " is an illegal move." + prompt();
    }

    /**
     * A OneRowNim Keyboard Application Program
     */
    public static void main(String args[]) {
        KeyboardReader kb = new KeyboardReader();
        OneRowNim nim = new OneRowNim(OneRowNim.MAX_STICKS);
        nim.play(kb);
	//        OneRowNimGUI gui = new OneRowNimGUI("One Row Nim Game");
	//        nim.play(gui);        
    }
} // OneRowNim class
