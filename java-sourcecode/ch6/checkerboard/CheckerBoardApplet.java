/*
 * File: CheckerBoardApplet.java
 * Author: Java, Java, Java
 * Description: Provides a simple applet interface to the
 *   CheckerBoard graphical object.
 */
import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class CheckerBoardApplet extends JApplet {
    private CheckerBoard theBoard;      // Reference to the CheckerBoard

    /** 
     * init() instantiates the CheckerBoard object.
     */
    public void init() {
	theBoard = new CheckerBoard();
    }

    /** 
     * paint() draws the CheckerBoard
     */
    public  void paint(Graphics g) {
	theBoard.draw(g);
    } // paint()
} // CheckerBoardApplet
