public class MultiplicationGame extends TwoPlayerGame implements PlayableGame
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

    public String reportState() {
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
    public String prompt() {
        return "\nWhat is " + n1 + " times " + n2 + " ? ";
    }

    public String move(String s) {
        String reply = "";
        answer = Integer.parseInt(s);       
        gameOver = answer != product;
        if (!gameOver) {
	    if (getPlayer()==PLAYER_ONE)
		++score1;
	    else
		++score2;
            reply = "\nThat's right. " + reportState();
            newProblem();
            changePlayer();
            reply += prompt(); 
	} else {
            winner = 3 - getPlayer();
	    reply =  "Oops. " + n1 + " times " + n2 + " equals " + product + 
		" not " + answer + ".\n" + reportState();
	}
        return reply;
    }

    public boolean gameOver() {
	//        gameOver = answer != product;
        return gameOver;
    }

    public void play(UserInterface ui) {
        IPlayer computer = null;
        ui.prompt("Multiplication Game: Two humans or one human? ");
        int nHumans = Integer.parseInt(ui.getUserInput());
        computerIsPlayer = nHumans == 1;
        ui.report(getRules());
        if (computerIsPlayer) {
            ui.report("You are player 1 and I am player 2.\n");
            computer = new MultPlayer(this);
	}
        ui.report("Whose turn: Player " + getPlayer() + "\n");
        while (!gameOver())
        {   ui.report(reportState());
            newProblem();
            if (getPlayer() == PLAYER_ONE || !computerIsPlayer) 
	    {    ui.prompt(prompt());
                 answer = Integer.parseInt(ui.getUserInput()); // Get move 
	    } else {
                answer = Integer.parseInt(computer.move(prompt()));
                ui.report("\nMy turn. " + prompt() +  " I say the product is  " + answer + "\n");
	    }
            gameOver = answer != product;
            if (!gameOver) {
		if (getPlayer()==PLAYER_ONE)
		    ++score1;
		else 
		    ++score2;
	    } else {
                ui.report("Oops. " + n1 + " times " + n2 + " equals " + product + "\n");
	    }
            changePlayer();
        } // while
	ui.report(reportState());  // The game is now over
    }

    public static void main(String args[]) {
        KeyboardReader ui = new KeyboardReader();
        MultiplicationGame game = new MultiplicationGame();
        game.play((UserInterface)ui);
    }

}
