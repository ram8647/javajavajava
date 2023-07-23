/*
 * MultiplicationGame.java
 * A multiplication quiz game for two players.
 * To compile: javac -classpath twoplayer.jar:. MultiplicationGame.java
 * To run CLUI: java -classpath twoplayer.jar:. MultiplicationGame
 */

public class MultiplicationGame extends TwoPlayerGame implements CLUIPlayableGame, GUIPlayableGame
{   private int product;
    private int answer;
    private boolean gameOver = false;
    private int n1,n2;
    private int score1 = 0, score2 = 0;
    private int winner = 0;

    public MultiplicationGame() { 
	newProblem();
    }

    public String getRules() {
        return "\n*** The Rules of Multiplication Game ***\n" +
	    "Players 1 and 2  will take turns answering\n" +
	    "The game ends when any player gives a wrong answer\n" +
            "The first one to get an answer wrong loses.\n";
    }
    public String getWinner() {
        if (winner == PLAYER_ONE)
	    return "The winner is Player1 with " + score1 + " correct answers. Nice game.\n";
	else
	    return "The winner is Player2 with " + score2 + " correct answers. Nice game.\n";
    }

    public String reportGameState() {
        if (!gameOver())
            return "\nPlayer1 = " + score1 + " Player2 = " + score2 + " Who's turn: Player " + getPlayer();
        else
            return "\nPlayer1 = " + score1 + " Player2 = " + score2 
	    + " Game over!\n" + getWinner() + "\n";
    }

    private void newProblem () {
	n1 = 1 + (int)(Math.random()* 10);
	n2 = 1 + (int)(Math.random()* 10);
	product = n1 * n2;
    }
    public String getGamePrompt() {
        return "\nWhat is " + n1 + " times " + n2 + " ? ";
    }

    public String submitUserMove(String theMove) {
        String reply = "";
        answer = Integer.parseInt(theMove);       
        gameOver = answer != product;
        if (!gameOver) {
	    if (getPlayer()==PLAYER_ONE)
		++score1;
	    else
		++score2;
            changePlayer();
            reply = "\nThat's right. " + reportGameState();
            newProblem();
	} else {
            winner = 3 - getPlayer();
	    reply =  "Oops. " + n1 + " times " + n2 + " equals " + product + 
		" not " + answer + ".\n" + reportGameState();
	}
        return reply;
    }

    public boolean gameOver() {
        return gameOver;
    }

    public void play(UserInterface ui) {
        ui.report(getRules());
        if (computer1 != null) 
            ui.report("\nPlayer 1 is a " + computer1.toString());
	if (computer2 != null)
	    ui.report("\nPlayer 2 is a " + computer2.toString());
        while (!gameOver()) {   
            IPlayer computer = null;  // Assume no computer
            switch(getPlayer()) {
	    case PLAYER_ONE:             // Player 1's turn
		computer = computer1;
		break;
	    case PLAYER_TWO:             // Player 2's turn
		computer = computer2;
		break;
	    } // cases

            if (computer != null) {      // If computer's turn
                String computerMove = computer.makeAMove(getGamePrompt());
                ui.report("\n" + computer.toString() +"'s turn. " + getGamePrompt() 
                             +  " I say the product is  " + computerMove + "\n");
		ui.report(submitUserMove(computerMove));
	    } else {                     // otherwise, user's turn
		ui.prompt(getGamePrompt());
                ui.report(submitUserMove(ui.getUserInput()));
	    }
        } // while
    }

    public static void main(String args[]) {
        KeyboardReader ui = new KeyboardReader();
        MultiplicationGame game = new MultiplicationGame();
        ui.prompt("How many computers are playing, 0, 1, or 2? ");
	int m = ui.getKeyboardInteger();
        for (int k = 0; k < m; k++) {
            IPlayer computer = new MultPlayer(game);
            game.addComputerPlayer(computer);
	}
        game.play((UserInterface)ui);
    }

}
