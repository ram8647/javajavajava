/*
 * File: OneRowNim.java
 * Author: Java, Java, Java
 * Description:  This version of OneRowNim extends the TwoPlayerGame 
 *  class and implements the CLUIPlayableGame interface, which enables
 *  two players to play using a command-line interface.  It makes 
 *  extensive use of Java's inheritance and polymorphism mechanisms.
 *
 * NOTE: To compile and run this program OneRowNim must have access to
 *  all the classes of TwoPlayerGame hierarchy.  One way to do this is
 *  to place all classes in the same directory. Another is to add the
 *  TwoPlayerGame hierarchy to the classpath during compilation and running:
 *    javac -classpath ../twoplayergame:. OneRowNim.java
 *    java -classpath ../twoplayergame:. OneRowNim
 *  Another way to provide access is to create a jar file containing the
 *  TwoPlayerGame classes and add that to the classpath:
 *     javac -classpath twoplayergame.jar:. OneRowNim.java
 *     java -classpath twoplayergame.jar:. OneRowNim
 *
*/
public class OneRowNim extends TwoPlayerGame implements CLUIPlayableGame {   
    public static final int MAX_PICKUP = 3;
    public static final int MAX_STICKS = 11;
    private int nSticks = MAX_STICKS;

    /**
     * OneRowNim() default constructor
     */
    public OneRowNim() { }        // Constructors

    /**
     * OneRowNim() constructor sets the initial number of sticks.
     * @param sticks, an int representing the number of sticks.
     */
    public OneRowNim(int sticks) {   
        nSticks = sticks;
    }  // OneRowNim()

    /**
     * OneRowNim() constructor sets the initial number of sticks and
     *  the initial player.
     * @param sticks, an int representing the number of sticks.
     * @param starter, an int representing which player goes first
     */
    public OneRowNim(int sticks, int starter) {   
        nSticks = sticks;
        setPlayer(starter);
    } // OneRowNim()

    /**
     * takeSticks() removes a valid number of sticks and returns true
     *  or returns false if the parameters is not valid.
     * @param num, an int representing the number of sticks to take.
     * @return true is returned if the move is valid, false otherwise.
     */
    public boolean takeSticks(int num) {   
        if (num < 1 || num > MAX_PICKUP || num > nSticks) 
            return false;                // Error
        else                             // Valid move
        {   nSticks = nSticks - num;
            return true;
        } //else
    } // takeSticks()

    /**
     * getSticks() returns the current number of sticks.
     */
    public int getSticks() {   
        return nSticks;
    } // getSticks()

    /**
     * getRules() is overridden from the TowPlayerGame class. It
     *  returns a String giving the games rules.
     * @return a String describing the game
     */
    public String getRules() {
        return "\n*** The Rules of One Row Nim ***\n" +
          "(1) A number of sticks between 7 and " + MAX_STICKS + 
          " is chosen.\n" + 
          "(2) Two players alternate making moves.\n" + 
          "(3) A move consists of subtracting between 1 and\n\t" + 
          MAX_PICKUP + " sticks from the current number of sticks.\n" + 
          "(4) A player who cannot leave a positive\n\t" + 
          " number of sticks for the other player loses.\n";
    } // getRules()

    /** 
     * gameOver() is defined as abstract in TwoPlayerGame
     *  and implemented here. A OneRowNim game is over when
     *  there are 0 sticks left.
     * @return true if the game is over and false otherwise
     */
    public boolean gameOver() {  
        return (nSticks <= 0);
    }  // gameOver()

    /** 
     * getWinner() is defined as abstract in TwoPlayerGame
     *  and implemented here. It defines who wins OneRowNim.
     * @return a String describing the winner
     */
    public String getWinner()  {       /** From TwoPlayerGame */
        if (gameOver()) //{
            return "" + getPlayer() + " Nice game.";
        return "The game is not over yet.";   // Game is not over
    } // getWinner()

    /** 
     * getGamePrompt() is implemented as part of the CLUIPlayableGame interface.
     *  It defines the prompt presented to the user before each move.
     * @return a String giving the prompt.
     */
    public String getGamePrompt() {
        return "\nYou can pick up between 1 and " + Math.min(MAX_PICKUP,nSticks) + " : ";
    } // getGamePrompt()

    /**
     * reportGameState() is implemented as part of the CLUIPlayableGame interface.
     *  It describes the current state of the game.
     * @return a String describing the game's current state.
     */
    public String reportGameState() {   
        if (!gameOver())
            return ("\nSticks left: " + getSticks() + " Who's turn: Player " + getPlayer());
        else
            return ("\nSticks left: " + getSticks() + " Game over! Winner is Player "  + getWinner() +"\n");
    }   // reportGameState()

    /**
     * play() is implemented as part of the CLUIPlayableGame interface.
     *  It contains the control algorithm for playing two-player OneRowNim.
     * @param ui gives a reference to the UserInterface where I/O is performed.
     */
    public void play(UserInterface ui) {
        int sticks = 0;
        ui.report(getRules());
        if (computer1 != null) 
            ui.report("\nPlayer 1 is a " + computer1.toString());
        if (computer2 != null)
            ui.report("\nPlayer 2 is a " + computer2.toString());
        while(!gameOver()) {  
            IPlayer computer = null;     // Assume no computers
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
            } else {                  // otherwise, user's turn
                ui.prompt(getGamePrompt());
                sticks = Integer.parseInt(ui.getUserInput()); // Get user's move 
            }
            if (takeSticks(sticks))      // If a legal move
                changePlayer();
        } // while
        ui.report(reportGameState());  // The game is now over
    } // play()

    /**
     * main() sets up an instance of a OneRowNim game to be played
     *   using a command-line interface between a user and a NimPlayerBad.
     */
    public static void main(String args[]) {
        KeyboardReader kb = new KeyboardReader();
        OneRowNim game = new OneRowNim();
        kb.prompt("How many computers are playing, 0, 1, or 2? ");
        int m = kb.getKeyboardInteger();
        for (int k = 0; k < m; k++) {
            kb.prompt("What type of player, " + "NimPlayerBad = 1, or NimPlayer = 2 ? ");
            int choice = kb.getKeyboardInteger();
            if (choice == 1) {
                IPlayer computer = new NimPlayerBad(game);
                game.addComputerPlayer(computer);
            } else {
                IPlayer computer = new NimPlayer(game);
                game.addComputerPlayer(computer);
            }
        }
        game.play(kb);
    } // main()

} // OneRowNim class
