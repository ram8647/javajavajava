/*
 * File: TwentyOne.java
 * Author: Java, Java, Java
 * Description: A game of TwentyOne
 * To compile: javac -classpath nplayer.jar:deck.jar:. TwentyOne.java
 * To run: java -classpath nplayer.jar:deck.jar:. TwentyOne
 */

public class TwentyOne extends ComputerGame implements CLUIPlayableGame {	
    private Deck deck;
    private boolean gameover = false;
    
    public TwentyOne() {}
    public TwentyOne(int nplayers) { super(nplayers); }

    public void play(UserInterface ui) {
        deck = new Deck();
        ui.report(getRules());
        ui.report(reportGameState());

        while (!gameOver()) {
            ui.report("\n\nNew hand.\n");
            deck.shuffleDeck();
            for (int k = 0; k < nPlayers; k++)   // For each player
                dealAndPlay((TwentyOnePlayer)player[k], ui);
            ui.report(getWinner());
	    ui.prompt("Play again? (Y/N): ");
	    gameover = ui.getUserInput().equalsIgnoreCase("N");
	} // while
        ui.report("\n\nNice game. Here are the final tallies.\n" + reportGameState());
    }
    private void dealAndPlay(TwentyOnePlayer p, UserInterface ui) {
       String move = "";
       p.newHand();                      // Deal the hand
       p.deal(deck.dealOne());
       p.deal(deck.dealOne());           
       ui.report("Player" + p.getID() + " " +  p.toString() + " " + p.getHand() + "\n");
       do {
           if (p.isComputer())
               move = p.makeAMove(getGamePrompt());
           else {
               ui.report("Player" + p.getID() + ": " + getGamePrompt());
               move = ui.getUserInput();
           }
           ui.report("Player" + p.getID() + " decides to " + move + "\n");
           if (move.equalsIgnoreCase("HIT")) {
               p.deal(deck.dealOne());
               ui.report("Player" + p.getID() + " " +  p.toString() + " " + p.getHand() + "\n");
           }
       } while (move.equalsIgnoreCase("HIT") && p.totalCards() <= 21);
    }
    public String getRules() {
        return "The rules of Twenty One are:\n" +
            " A player is dealt 2 cards whose face values are added together.\n" +
	    "  Face cards count for 10 and aces for 11. \n" +
            " A player may take as many additional cards as desired provided\n" + 
	    "  the player's score doesn't exceed 21. .\n" +
            " The player who comes closest to 21 wins the hand.\n" + 
	    " If two players tie, nobody wins.\n" +
	    " The game ends when the user decides to quit.\n";
    }
    public String getWinner() {
         int bestScore = 0;
         int bestPlayer  = -1;
         boolean isATie = false;
         TwentyOnePlayer p = null;
         for (int k = 0; k < nPlayers; k++) {
             p = (TwentyOnePlayer)player[k]; 
             int total = p.totalCards();
             if (total <= 21) 
                 if (total > bestScore) {
                     bestScore = total;
                     bestPlayer = k;
                     isATie = false;
                 } else if (total == bestScore)
                     isATie = true;
         }
	 if (isATie || bestPlayer == -1)
             return "This hand is a tie.\n";            
         p = (TwentyOnePlayer)player[bestPlayer];
         p.updatePoints(1);
         return "Winner: Player" + bestPlayer + " " + p.toString() + " " 
                      + p.getHand() + "\n";
    }   
    public boolean gameOver() {
        return gameover;
    }
    public String getGamePrompt() {
        return "HIT or STAY? ";
    }
    public String reportGameState() {
        StringBuffer result = new StringBuffer();
        for (int k = 0; k < nPlayers; k++)
            result.append("Player" + k + " " + player[k].toString() + "\n");
        return result.toString();
    }
    public int getFaceValue(int v) {
        if (v >= 10 && v <= 13) // face cards
            return 10;
        if (v == 14)
	    return 11; // ace
        return v;      // 2 through 9
    }

    public static void main(String args[])  {  
	KeyboardReader kb = new KeyboardReader();
        kb.prompt("How many players are playing, 1,  2 or more? ");
	int m = kb.getKeyboardInteger();
        ComputerGame game = new TwentyOne(m);
        for (int k = 0; k < m; k++) {
            kb.prompt("Player " + k + ", what type, Human  = 1, or Computer = 2 ? ");
	    int choice = kb.getKeyboardInteger();
            if (choice == 1) {
                Player player = new TwentyOnePlayer((TwentyOne)game, Player.HUMAN, k);
                game.addPlayer(player);
	    } else {
                Player player = new TwentyOnePlayer((TwentyOne)game, Player.COMPUTER, k);
                game.addPlayer(player);
	    }
	}
        ((CLUIPlayableGame)game).play(kb);
    } //main()

} // TwentyOne
