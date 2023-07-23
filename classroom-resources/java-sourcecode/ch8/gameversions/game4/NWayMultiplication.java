public class NWayMultiplication extends Game implements IPlayer, Playable
{   private int product;
    private int answer;
    private int nCorrect = 0;
    private boolean gameOver = false;
    private int n1,n2;
    
    public NWayMultiplication() { 
        nPlayers = 2;
        whoseTurn = 0;
	n1 = 1 + (int)(Math.random()* 10);
	n2 = 1 + (int)(Math.random()* 10);
	product = n1 * n2;
    }

    public NWayMultiplication(int n) { 
        super(n);              // Set number of players
        whoseTurn = 0;
	n1 = 1 + (int)(Math.random()* 10);
	n2 = 1 + (int)(Math.random()* 10);
	product = n1 * n2;
    }

    public String getRules() {
        return "\n*** The Rules of N-Way Multiplication Game  ***\n" +
	    "I will present multiplication problems.\n" +
	    "Players will take turns answering them.\n" +
	    "The game ends when any player gives a wrong answer.\n";
    }
    public String getWinner() {
        return "We are all winners for practicing multiplication!\n";
    }

    public boolean gameOver() {
        return gameOver;
    }
    public String move(String s) {
        String reply = "";
        answer = Integer.parseInt(s);       
        gameOver = answer != product;
        if (!gameOver) {
            ++nCorrect;
            reply = "\nPlayer" + whoseTurn + " to Player " + nextPlayer() + " : ";
            reply += "Good! " + n1 + " times " + n2 + " equals " + product + "\n";
            changePlayer();
	    n1 = 1 + (int)(Math.random()* 10);
	    n2 = 1 + (int)(Math.random()* 10);
	    product = n1 * n2;
            reply += prompt(); 
	} else {
	    reply =  "\nOops! " + n1 + " times " + n2 + " equals " + product + ". Game over.\n" +
		getWinner();
	}
        return reply;
    }

    private String report() {
        String reply = "There are " + nPlayers + " players in this game.\n";
	for (int k = 0; k < nPlayers; k++)
            reply += player[k].toString() + "\n";
        return reply;
    }
    private String prompt() {
        return "\nPlayer" + player[whoseTurn].toString() +  
                ": What is " + n1 + " times " + n2 + " ? ";
    }
    private String praise() {
        return "Player" + player[whoseTurn].toString() +  
                ": Good! " + n1 + " times " + n2 + " equals " + product + ".\n ";
    }

    private int nextPlayer() {
        return (whoseTurn+1) % nPlayers;
    }
    private void changePlayer() {
	whoseTurn = (whoseTurn +1) % nPlayers;
    }
    private void init(UserInterface ui) 
    {   ui.prompt("N-Way Multiplication: How many players are there?");
        nPlayers = Integer.parseInt(ui.getUserInput());
        player = new NWayMultPlayer[nPlayers];
        ui.prompt("N-Way Multiplication: Do you want the computer to play (y/n)? ");
	String answer = ui.getUserInput();
        if (answer.equals("Y" || answer.equals("y"))) 
	{   player[0] = new MultPlayer(this); 
            for (int k = 1; k < Math.min(nPlayers, nComputers); k++) 
                player[k] = new NWayMultPlayer(""+k, ui, Player.COMPUTER);
	} else {
            for (int k = 0; k < nPlayers; k++)
                player[k] = new NWayMultPlayer(""+k, ui, Player.HUMAN);
	}
        ui.report(getRules());
        ui.report(report());
    }
    
    public void play(UserInterface ui) {
        init(ui);
        while (!gameOver()) {
            n1 = 1 + (int)(Math.random()* 10);
            n2 = 1 + (int)(Math.random()* 10);
            product = n1 * n2;
            ui.report(prompt());
            int answer = Integer.parseInt(player[whoseTurn].move("What is " + n1 + " times " + n2 + "?"));
            gameOver = answer != product;
            if (!gameOver) 
                ui.report(praise());
             changePlayer();
            ++nCorrect;
	}
	ui.report("Oops! " + n1 + " times " + n2 + " equals " + product + ". Game over.\n");
	ui.report(getWinner());
   }

    public void play(GameGUI gui) {
        gui.callBack(this);
    }

    public static void main(String args[]) {
        KeyboardReader kb = new KeyboardReader();
        NWayMultiplication game = new NWayMultiplication();
        game.play((UserInterface)kb);
    }

}
