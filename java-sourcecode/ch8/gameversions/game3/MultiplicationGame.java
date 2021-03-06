public class MultiplicationGame extends TwoPlayerGame implements Playable 
{   private int product;
    private int answer;
    private int nCorrect = 0;
    private boolean gameOver = false;
    private KeyboardReader kb;
    private GameGUI gui;
    private int n1,n2;

    public MultiplicationGame() { 
	n1 = 1 + (int)(Math.random()* 10);
	n2 = 1 + (int)(Math.random()* 10);
	product = n1 * n2;
    }

    public String getRules() {
        return "\n*** The Rules of Multiplication Game ***\n" +
        "Player 1 will present a multiplication problem\n" +
        "Player 2 will present an answer\n" +
        "The game ends when Player 2 gives a wrong answer\n" +
        "I'm Player 1 and you are Player 2\n";
    }
    public int getWinner() {
        return 2;
    }

    public String report() {
        return "Player1: What is " + n1 + " times " + n2 + " ? ";
    }

    public String move(String s) {
        answer = Integer.parseInt(s);       
        gameOver = answer != product;
        if (!gameOver) {
            ++nCorrect;
	    n1 = 1 + (int)(Math.random()* 10);
	    n2 = 1 + (int)(Math.random()* 10);
	    product = n1 * n2;
	    return "\nPlayer1: Good. What is " + n1 + " times " + n2 + " ? ";
	} else {
	    return "\nOops! " + n1 + " times " + n2 + " equals " + product + "\n" +
		"The game is over.\nYou win because you got " + nCorrect + " correct.\n";
	}
    }

    public boolean gameOver() {
        return gameOver;
    }
    public void play(KeyboardReader reader) {
        int n1 = 0, n2 = 0;
        kb = reader;
        kb.display(getRules());
        while (!gameOver()) {
            n1 = 1 + (int)(Math.random()* 10);
            n2 = 1 + (int)(Math.random()* 10);
            product = n1 * n2;
            kb.display("Player1: What is " + n1 + " times " + n2 + " ? ");
            int answer = kb.getKeyboardInteger();
            gameOver = answer != product;
            ++nCorrect;
	}
	kb.display("Oops! " + n1 + " times " + n2 + " equals " + product + "\n");
	kb.display("The game is over.\nYou win because you got " + (nCorrect-1) + " correct.\n");
   }

    public void play(GameGUI gui) {
        this.gui = gui;
	//        gui.callBack((TwoPlayerGame)this);
        gui.callBack(this);
    }

    public static void main(String args[]) {
        KeyboardReader kb = new KeyboardReader();
        MultiplicationGame game = new MultiplicationGame();
        game.play(kb);
    }

}
