public class MultiplicationGame extends TwoPlayerGame implements Playable
{   private int product;
    private int answer;
    private int nCorrect = 0;
    private boolean gameOver = false;
    private int n1,n2;

    public MultiplicationGame() { 
	//	n1 = 1 + (int)(Math.random()* 10);
	//	n2 = 1 + (int)(Math.random()* 10);
	//	product = n1 * n2;
    }

    public String getRules() {
        return "\n*** The Rules of Multiplication Game ***\n" +
	    "I will present a multiplication problem\n" +
	    "Players 1 and 2  will take turns answering\n" +
	    "The game ends when any player  gives a wrong answer\n";
    }
    public String getWinner() {
        return "Everyone wins for practicing multiplication!\n";
    }

    public String report() {
        if (gameOver())
            return "Oops. " + n1 + " times " + n2 + " equals " + product + "\n" 
                  + "The game is over. " + getWinner() +"\n";
        if (n1 == 0 && n2  == 0)  // Initial state.
            return "\nWhose turn: Player "  + getPlayer() + "\n";
        if (answer == product)
            return "That's right. " + n1 + " times " + n2 + " equals " + product + 
                   "\nWhose turn: Player "  + getPlayer() + "\n";
        return "";
    }
    private void newProblem () {
	n1 = 1 + (int)(Math.random()* 10);
	n2 = 1 + (int)(Math.random()* 10);
	product = n1 * n2;
    }
    private String prompt() {
        return "\nWhat is " + n1 + " times " + n2 + " ? ";
    }

    public String move(String s) {
        answer = Integer.parseInt(s);       
        gameOver = answer != product;
        String reply = "\nPlayer1: Good! " + n1 + " times " + n2 + " equals " + product;
                    
        if (!gameOver) {
            ++nCorrect;
	    n1 = 1 + (int)(Math.random()* 10);
	    n2 = 1 + (int)(Math.random()* 10);
	    product = n1 * n2;
            reply += "\nWhat is " + n1 + " times " + n2 + " ? "; 
	} else {
	    reply =  "\nOops! " + n1 + " times " + n2 + " equals " + product + "\n" +
		"The game is over.\nYou win because you got " + nCorrect + " correct.\n";
	}
        return reply;
    }

    public boolean gameOver() {
        gameOver = answer != product;
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
        while (!gameOver())
        {   ui.report(report());
   	    newProblem();
            if (getPlayer() == PLAYER_ONE || !computerIsPlayer) 
	    {    ui.prompt(prompt());
                 answer = Integer.parseInt(ui.getUserInput()); // Get move 
	    } else {
                answer = Integer.parseInt(computer.move(prompt()));
                ui.report("\nMy turn. " + prompt() +  " I say the product is  " + answer + "\n");
	    }
            changePlayer();
        } // while
	ui.report(report());  // The game is now over
    }

    public void play(GameGUI gui) {
        gui.callBack(this);
    }

    public static void main(String args[]) {
        KeyboardReader ui = new KeyboardReader();
        MultiplicationGame game = new MultiplicationGame();
        game.play((UserInterface)ui);
    }

}
