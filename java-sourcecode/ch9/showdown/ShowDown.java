/*
 * File: ShowDown.java
 * Author: Java, Java, Java
 * Description: A game of 1 card show down.
 * To compile: javac -classpath nplayer.jar:deck.jar:. Showdown.java
 * To run: java -classpath nplayer.jar:deck.jar:. Showdown
 */

public class ShowDown extends ComputerGame implements CLUIPlayableGame {	
    public static final int WINNING_SCORE = 10;

    private int top = 0;                      // Position of top card
    private Card card1;    // First card dealt
    private Card card2;    // Second card dealt
    private Card hitMe;    // Hit me card
   
    public ShowDown() { }
    public ShowDown(int nplayers) { super(nplayers); }

    public void play(UserInterface ui) {
        ShowDownPlayer p = null;
        Deck deck = new Deck();
        deck.shuffleDeck();        
        ui.report(getRules());
        ui.report(reportGameState());
	while(!gameOver()) {  
            int highPlayer = -1;
            int highCardValue = 0;  // Card values are 2, 3, ..., 14
            for (int k = 0; k < nPlayers; k++) { // Deal a hand
                p = (ShowDownPlayer)player[k];
                if (p.inGame()) {
                    Card card = deck.dealOne();
                    p.deal(card);
                    ui.report("Player " + k + " is dealt " + card.toString() + "\n");
                    String move = "";
                    if (p.isComputer())
                        move = player[k].makeAMove(getGamePrompt());
                    else {
                        ui.report("Player " + k + " " + getGamePrompt());
                        move = ui.getUserInput();
                    }
                    ui.report("Player " + k + " decides to " + move + "\n");
                    if (move.equalsIgnoreCase("FOLD"))
                        p.fold(); 
                }
            }
            ui.report(scoreTheHand());
	    ui.report(reportGameState());  // The game is now over
        } // while
	ui.report("The winner is " + getWinner() + "\n");  // The game is now over
    }

    private String scoreTheHand() {
        ShowDownPlayer p = null;
        int values[] = new int[nPlayers];
        for (int k = 0; k < nPlayers; k++) {
            p = (ShowDownPlayer)player[k];
            if (p.inGame() && p.inHand())
		values[k] = p.showCard().value;
            else
		values[k] = -1;
        }
        int highValue = values[0];
        int highPlayer = 0;
        boolean isATie = false;
        for (int k = 1; k < nPlayers; k++) 
            if (values[k] > highValue) {		
                highValue = values[k];
                highPlayer = k;
                isATie = false;
	    } else if (values[k] == highValue)
		isATie = true;
        if (isATie) 
	    return "This hand is a tie.\n";
        for (int k = 0; k < nPlayers; k++) {
            p = (ShowDownPlayer)player[k];
            if (k != highPlayer && p.inGame() && p.inHand())
		((ShowDownPlayer)player[k]).loseAPoint();
            else if (k == highPlayer) 
		((ShowDownPlayer)player[k]).gainAPoint();
	}
        return "The winner of this hand is Player " + highPlayer + ".\n";
    }

    public String getRules() {
        return "The rules of Showdown are:\n" +
            " Each player starts with 3 points.\n" +
	    " On each hand, each player is dealt one card face down.\n" +
            " When it's his turn, a player may either 'call' or 'fold'.\n" + 
	    " The player with the highest card wins that hand \n" +
	    "   and gains 1 point. \n" + 
	    "   Each of the other players who CALLED lose 1 point.\n" + 
	    " If two players tie with the highest card, no one wins that hand.\n" +
	    " The game ends when there is only one player left \n" +
            "  or when one player reaches " + WINNING_SCORE + " points.\n";
    }
    public String getWinner() {
        String winner = "";
        for (int k = 0; k < nPlayers; k++)
	    if (((ShowDownPlayer)player[k]).inGame()) {
                winner =  "Player " + k;
                if (((ShowDownPlayer)player[k]).getPoints() >= WINNING_SCORE)
		    return winner;
	    }
        return winner;
    }   

    public boolean gameOver() {
        int nInGame = 0;
        for (int k = 0; k < nPlayers; k++)
	    if (((ShowDownPlayer)player[k]).inGame()) {
		++nInGame;
                if (((ShowDownPlayer)player[k]).getPoints() >= WINNING_SCORE)
		    return true;
	    }
        return nInGame == 1;
    }

    public String getGamePrompt() {
        return "Do you CALL or FOLD? ";
    }

    public String reportGameState() {
        StringBuffer result = new StringBuffer();
        for (int k = 0; k < nPlayers; k++)
            result.append("Player " + k + " is a " + player[k].toString() + 
                 " and has " + ((ShowDownPlayer)player[k]).getPoints() + " points.\n");
        return result.toString();
    }

    public static void main(String args[])  {  
	KeyboardReader kb = new KeyboardReader();
        kb.prompt("How many players are playing, 0, 1, or 2? ");
	int m = kb.getKeyboardInteger();
        ComputerGame game = new ShowDown(m);
        for (int k = 0; k < m; k++) {
            kb.prompt("Player " + k + ", what type, Human  = 1, or Computer = 2 ? ");
	    int choice = kb.getKeyboardInteger();
            if (choice == 1) {
                Player player = new ShowDownPlayer((ShowDown)game, Player.HUMAN);
                game.addPlayer(player);
	    } else {
                Player player = new ShowDownPlayer((ShowDown)game, Player.COMPUTER);
                game.addPlayer(player);
	    }
	}
        ((CLUIPlayableGame)game).play(kb);
    } //main()

} // ShowDown
