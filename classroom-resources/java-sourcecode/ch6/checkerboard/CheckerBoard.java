/*
 * File: CheckerBoard.java
 * Author: Java, Java, Java
 * Description: Draws a 340x340 checker board.
 */
import java.awt.*;

public class CheckerBoard extends Canvas {
                                        // Default values for a standard checkerboard
    private final int LEFT_X = 10;                     // Position of left
    private final int UPPER_Y = 10;                    // upper corner
    private final int SQ_SIDE = 40;                    // Size of each square
    private final int N_ROWS = 8;                      // Checkerboard rows
    private final int N_COLS = 8;                      // Checkerboard columns
    private final Color SQ_COLOR1 = Color.lightGray;   // Colors
    private final Color SQ_COLOR2 = Color.gray;        // of squares
    private final Color CHECKER_COLOR1 = Color.white;  // and
    private final Color CHECKER_COLOR2 = Color.black;  // checkers

    /**
     * drawBoard() uses a nested for loop to draw the 64 squares of the 
     *  checkerboard.
     * @param g is a reference to the current Graphics object
     */
    private void drawBoard(Graphics g) {
	for(int row = 0; row < N_ROWS; row++)          // For each row
	    for(int col = 0; col < N_COLS; col++) {    // For each square
		if ((row + col) % 2 == 0)              // Alternate colors
		    g.setColor(SQ_COLOR1);             // Light
		else
		    g.setColor(SQ_COLOR2);             // or dark
		g.fillRect(LEFT_X+col*SQ_SIDE,
			   UPPER_Y+row*SQ_SIDE,SQ_SIDE,SQ_SIDE);
	    } //for
    } //drawBoard()

    /**
     * drawBoard() uses a nested for loop to draw round checkers on 
     *  each of the 64 squares of the checkerboard.
     * @param g is a reference to the current Graphics object
     */
    private void drawCheckers(Graphics g) {            // Place checkers
	for(int row = 0; row < N_ROWS; row++)          // For each row
	    for(int col = 0; col < N_COLS; col++)      // For each square
		if ((row + col)%2 == 1) {              // One player has top 3 rows
		    if (row < 3) {
			g.setColor(CHECKER_COLOR1);
			g.fillOval(LEFT_X+col*SQ_SIDE,
				   UPPER_Y+row*SQ_SIDE,SQ_SIDE-2,SQ_SIDE-2);
		    }//if
		    if (row >= N_ROWS - 3) {           // Other has bottom 3 rows
			g.setColor(CHECKER_COLOR2);
			g.fillOval(LEFT_X+col*SQ_SIDE,
				   UPPER_Y+row*SQ_SIDE,SQ_SIDE-2,SQ_SIDE-2);
		    }//if
		}//if
    } // drawCheckers()

    /**
     * draw() is the public method that handles drawing of the checkerboard.
     * @param g is a reference to the current Graphics object
     */
    public void paint(Graphics g) {                     // Draw board and checkers
	drawBoard(g);
	drawCheckers(g);
    } // draw()
} //CheckerBoard
