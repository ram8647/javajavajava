/*
 * OneRowNim.java
 * The full version of One Row Nim. This version can be CLUIPlayable or GUIPlayable
 * To compile: javac -classpath twoplayer.jar:.  OneRowNim.java
 * To run CLUI:  java -classpath twoplayer.jar:. OneRowNim
 */

import java.awt.*;

public class OneRowNim extends TwoPlayerGame implements CLUIPlayableGame, GUIPlayableGame,
                                                        Drawable  {   
    public static final int MAX_PICKUP = 3;
    public static final int MAX_STICKS = 11;
    
    private int nSticks = MAX_STICKS;

    public OneRowNim() { }        // Constructors
    public OneRowNim(int sticks) {   
	nSticks = sticks;
    }  
    public OneRowNim(int sticks, int starter) {   
	nSticks = sticks;
        setPlayer(starter);
    } 
    public boolean takeSticks(int num) {   
	if (num < 1 || num > MAX_PICKUP || num > nSticks) 
	    return false;                // Error
        else                             // Valid move
        {   nSticks = nSticks - num;
            return true;
	} //else
    }//takeSticks
    public int getSticks() {   
	return nSticks;
    } //getSticks

    public String getRules() {
        return "\n*** The Rules of One Row Nim ***\n" +
        "(1) A number of sticks between 7 and " + MAX_STICKS + " is chosen.\n" + 
        "(2) Two players alternate making moves.\n" + 
        "(3) A move consists of subtracting between 1 and\n\t" + 
            MAX_PICKUP + " sticks from the current number of sticks.\n" + 
        "(4) A player who cannot leave a positive\n\t" + 
        " number of sticks for the other player loses.\n";
    }
    public boolean gameOver() {   /** From TwoPlayerGame */
	return (nSticks <= 0);
    } // gameOver()
    public String getWinner()  {       /** From TwoPlayerGame */
	if (gameOver()) //{
		return "" + getPlayer() + " Nice game.";
	return "The game is not over yet.";   // Game is not over
    } // getWinner()

    public String getGamePrompt() {
        return "\nYou can pick up between 1 and " + Math.min(MAX_PICKUP,nSticks) + " : ";
    }
    public String reportGameState() {   
	if (!gameOver())
             return ("\nSticks left: " + getSticks() + " Who's turn: Player " + getPlayer());
        else
             return ("\nSticks left: " + getSticks() + " Game over! Winner is Player " + getWinner() +"\n");
    }   // reportGameState()

    /** From CLUIPlayableGame interface */
    public void play(UserInterface ui) {
        int sticks = 0;
        ui.report(getRules());
        if (computer1 != null) 
            ui.report("\nPlayer 1 is a " + computer1.toString());
	if (computer2 != null)
	    ui.report("\nPlayer 2 is a " + computer2.toString());

	while(!gameOver()) {  
            IPlayer computer = null;             // Assume no computers playing
	    ui.report(reportGameState());
            switch(getPlayer()) {
	    case PLAYER_ONE:             // Player 1's turn
		computer = computer1;
		break;
	    case PLAYER_TWO:             // Player 2's turn
		computer = computer2;
		break;
	    } // cases

            if (computer != null) {      // If computer's turn
		sticks = Integer.parseInt(computer.makeAMove(""));
		ui.report(computer.toString() + " takes " + sticks + " sticks.\n");
	    } else {                     // otherwise, user's turn
		ui.prompt(getGamePrompt());
		sticks = Integer.parseInt(ui.getUserInput()); // Get user's move 
	    }
	    if (takeSticks(sticks))   // If a legal move
		changePlayer();
        } // while
	ui.report(reportGameState());  // The game is now over
    }

    public String submitUserMove(String theMove) {
        int sticks = Integer.parseInt(theMove);
        if (takeSticks(sticks)) {
            changePlayer();
            if (gameOver()) {
                return reportGameState() + "\nGame won by player" + getWinner() + "\n";
	    } else {
                return reportGameState() + getGamePrompt();
	    }
	}
        return "\nOops. " + sticks + " is an illegal move." + getGamePrompt();
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
	for (int k = 1; k <= nSticks; k++) {
            g.drawLine(10 + k * 10, 10, 10 + k * 10, 60);
	}
    }

    /**
     * A OneRowNim Keyboard Application Program
    */
    public static void main(String args[])  {  
	KeyboardReader kb = new KeyboardReader();
        CLUIPlayableGame game = new OneRowNim();
	//        TwoPlayerGame game = new OneRowNim();
	//        OneRowNim game = new OneRowNim();
        kb.prompt("How many computers are playing, 0, 1, or 2? ");
	int m = kb.getKeyboardInteger();
        for (int k = 0; k < m; k++) {
            kb.prompt("What type of player, NimPlayerBad = 1, or NimPlayer = 2 ? ");
	    int choice = kb.getKeyboardInteger();
            if (choice == 1) {
            IPlayer computer = new NimPlayerBad((OneRowNim)game);
		//            IPlayer computer = new NimPlayerBad(game);
            ((TwoPlayerGame)game).addComputerPlayer(computer);
	    } else {
            IPlayer computer = new NimPlayer((OneRowNim)game);
	    //            IPlayer computer = new NimPlayer(game);
            ((TwoPlayerGame)game).addComputerPlayer(computer);
	    }
	}
	//        ((CLUIPlayableGame)game).play(kb);
       game.play(kb);
    } //main()


} // OneRowNim class
