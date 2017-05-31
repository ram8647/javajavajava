/*
 * RockPaperScissors.java
 * The Rock Paper Scissors game.
 * To compile: javac -classpath twoplayer.jar:. RockPaperScissors.java
 * To run CLUI: java -classpath twoplayer.jar:. RockPaperScissors
 */
public class RockPaperScissors extends TwoPlayerGame implements CLUIPlayableGame, GUIPlayableGame
{   public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;    
    
    private int player1;   // The plays of each player
    private int player2;
    private int score1 = 0, score2 = 0;

    public RockPaperScissors()
    {
    } //RockPaperScissors() constructor1

    public String getRules() {
        return "\n*** The Rules of Rock Paper Scissors ***\n" +
        "(1) Rock breaks scissors, scissors cut paper, paper covers rock.\n" + 
        "(2) On each play, the two players simultaneously choose rock, paper, scissors.\n" + 
        "(3) Best two out of three wins the game.\n";
    }

    public String reportGameState()  {   
	if (!gameOver())
	    return "Scores: Player1 = " + score1 + " Player2 = " + score2 + "\n";
	else
	    return "Scores: Player1 = " + score1 + " Player2 = " + score2 + "\n" +
		"The game is over." + getWinner() + "\n";
    }   // reportGameState()

    private String reportPlay() {
	return "Player1 = " + nameIt(player1) + " Player2 = " + nameIt(player2) + 
	    " so the winner of this play is " + nameIt(calcWinner(player1,player2)) + "\n";
    }

    private String nameIt(int move) {
        if (move == ROCK)
	    return "ROCK";
	else if (move == PAPER)
	    return "PAPER";
	else if (move == SCISSORS)
	    return "SCISSORS";
	else 
	    return "TIE";
    }

    private int calcWinner(int p1, int p2) {
        if (p1 == p2)
	    return -1;    // That's a tie
        if (p1 == 0 && p2 == 2)
	    return p1;
        if (p1 == 0 && p2 == 1)
	    return p2;
        if (p2 == 0 && p1 == 2)
	    return p2;
	if (p2 == 0 && p1 == 1)
	    return p1;
        if (p1 == 1 && p2 == 2)
	    return p2;
	if (p2 == 1 && p1 == 2)
	    return p1;
        return -1;
    }

    /** From TwoPlayerGame */
    public boolean gameOver()
    {   return (score1 == 2 || score2 == 2);
    } // gameOver()

    /** From TwoPlayerGame */
    public String getWinner()  {   
	if (score1 == 2)
	    return "The winner is Player1";
	else if (score2 == 2)
	    return "The winner is Player2";
	else 
	    return "The game is not over yet.";
    } // getWinner()

    /** From Playable interface */
    public void play(UserInterface ui) {
        if (nComputers == 0) {
            ui.report("At least 1 player must be a computer.\n");
            return;
	}
        ui.report(getRules());

        if (nComputers == 1) {
            ui.report("You are player 1 and I am player 2, a " + computer2.toString() + "\n");
	} else if (nComputers == 2) {
            ui.report("Player 1 is a " + computer1.toString() + 
                       "\nand player 2 is a " +  computer2.toString() + "\n");
	}

	while(!gameOver()) {  
	    ui.report(reportGameState());
	    if (nComputers == 2) {                // Computers play each other
		   player1 = Integer.parseInt(computer1.makeAMove(""));
		   player2 = Integer.parseInt(computer2.makeAMove(""));
	    } 
	    else if (nComputers == 1) {    
		player2 = Integer.parseInt(computer2.makeAMove(""));
		ui.prompt(getGamePrompt());
		player1 = Integer.parseInt(ui.getUserInput()); // Get move 
	    }
            ui.report(reportPlay());
            if (calcWinner(player1, player2) == player1)
		++score1;
	    else if (calcWinner(player1, player2) == player2)
		++score2;
        } // while
	ui.report(reportGameState());  // The game is now over
    }

    public String getGamePrompt() {
        return "\nRock (0), Paper (1), Scissors (2) ? : ";
    }
 
    /** For a GUI interface, Player1 is the user and Player2 is a computer */
    public String submitUserMove(String theMove) {
        IPlayer computer = new RockPaperScissorsPlayer(this);
	player2 = Integer.parseInt(computer.makeAMove(""));
        player1 = Integer.parseInt(theMove);
	if (calcWinner(player1, player2) == player1)
	    ++score1;
	else if (calcWinner(player1, player2) == player2)
	    ++score2;
	if (gameOver()) {
	    return "\n" + reportPlay() + "\n" + reportGameState() + "\n";
	} else {
	    return "\n" + reportPlay() + "\n" + reportGameState() + getGamePrompt();
	}
    }

    /**
     * A RockPaperScissors Keyboard Application Program
     */
    public static void main(String args[]) {
        KeyboardReader kb = new KeyboardReader();
        RockPaperScissors game = new RockPaperScissors();
        kb.prompt("How many computers are playing, 0, 1, or 2? ");
	int m = kb.getKeyboardInteger();
        for (int k = 0; k < m; k++) {
            IPlayer computer = new RockPaperScissorsPlayer(game);
            game.addComputerPlayer(computer);
	}
	//        game.play((UserInterface)ui);
        game.play(kb);
    }
} // RockPaperScissors class
