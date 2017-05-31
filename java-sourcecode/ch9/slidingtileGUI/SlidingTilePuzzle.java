/*
 * File: SlidingTilePuzzle.java
 * Author: Java, Java, Java
 * Description: An implementation of the SlidingTile puzzle. The puzzle consists
 *  of 7 tiles. Three are labelede R and three are labeled  L. The seventh tile
 *  is blank. The user can move a tile into the blank or can have a tile jump over
 *  one or two other tiles into the blank space. The goal is to rearrange the puzzle
 *  so that all the Ls are to the left of all the Rs and the blank is in the middle.
 */

public class SlidingTilePuzzle extends ComputerGame implements GUIPlayableGame {
    private char puzzle[] = {'R','R','R',' ','L','L','L'};
    private String solution = "LLL RRR";        // The goal of the puzzle
    private int blankAt = 3;

    /**
     * SlidingTilePuzzle() default constructor sets up a 1-player game.
     */
    public SlidingTilePuzzle() { super(1); }

    /**
     * gameOver() is abstract in the ComputerGame class and implemented here.
     *  The sliding tile puzzle is finished when the puzzles arrangement matches
     *  the solution variable.  
     * @return true is returned if the puzzle is solved.
     */
    public boolean gameOver() { // True if puzzle solved
        StringBuffer sb = new StringBuffer();
        sb.append(puzzle);
        return sb.toString().equals(solution);    
    } 

    /**
     * getWinner() is abstract in the ComputerGame class and implemented here.
     *  It returns a string reporting whether the puzzle is solved.
     */
    public String getWinner() {   
        if (gameOver())
            return "\nYou did it! Very Nice!\n";
        else 
            return "\nGood try. Try again!\n";
    }

    /**
     * reportGameState() reports the current state of the game as
     *  a String
     * @param a String representing the current game state.
     */
    public String reportGameState() {   
        StringBuffer sb = new StringBuffer();
        sb.append(puzzle);
        return sb.toString();
    } 

    /**
     * getGamePrompt() returns the prompt for this game.
     */
    public String getGamePrompt() {    
        return "To move a tile, click on it.";
    } //prompt()

    /**
     * submitUserMove() is from the CLUIPlayableGame interface.
     *  It takes a user move and processes it and returns a response.
     */
    public String submitUserMove(String usermove) {   
        int tile = Integer.parseInt(usermove);
        char ch = puzzle[tile];
        if (ch=='L' && (blankAt==tile-1 || blankAt==tile-2))
            swapTiles(tile,blankAt);
        else if (ch=='R' && (blankAt==tile+1 || blankAt==tile+2))
            swapTiles(tile,blankAt);
        else 
            return "That's an illegal move.\n";
        return "That move is legal.\n";
    }

    /**
     * swapTiles() reverses the labels on two tiles, one of which
     *   is the blank tile.
     * @param t1 an int giving the labeled tile
     * @param bl an int representing the blank tile
     */
    private void swapTiles(int ti, int bl) {
        char ch = puzzle[ti];
        puzzle[ti] = puzzle[bl];
        puzzle[bl] = ch;
        blankAt = ti;   // Reset the blank
    }
} //SlidingTilePuzzle
