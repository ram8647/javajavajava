/*
 * File: Canvas.java
 * Author: Java, Java, Java
 * Description: This subclass of JPanel performs all
 *  the drawing functions for the RecursivePatterns applet.
 *  Whenever the user selects a pattern, the applet invokes
 *  the setPattern() method and then calls its repaint()
 *  method. Since the Canvas is contained within the applet,
 *  it too will be repainted, by its paintComponent() method,
 *  which draws the currently selected pattern.
 */

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private static final int GASKET = 0, BOXES = 1;
    public static final int WIDTH=400, HEIGHT=400;
    private final int HBOX=10, VBOX=50, BOXSIDE=300, BOXDELTA=10;
    private final Point gasketP1 = new Point(10, 340);   // Initial gasket points
    private final Point gasketP2 = new Point(350, 340);
    private final Point gasketP3 = new Point(180, 40);
    private int pattern = 0 ;                           // Current pattern
    private int level = 4;                              // Current level

    /**
     *  Canvas() constructor sets its size
     */
    public Canvas() {
        setSize(WIDTH, HEIGHT);
    }

    /**
     *  setPattern() is invoked by the applet to set the
     *   current drawing pattern and level
     *  @param pat -- the pattern to be drawn
     *  @param lev -- the number of levels of recursion
     */
    public void setPattern(int pat, int lev) {
        pattern = pat;
        level = lev;
    }
    
    /**
     *  paintComponent() is invoked automatically whenever the Canvas
     *   needs to be painted -- e.g., when its containing applet is painted
     *  @param g -- the Canvas graphics object.
     */
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());      // Redraw the panel's background
        g.drawRect(0, 0, WIDTH, HEIGHT);
        g.setColor(getForeground());
        switch (pattern) {
            case GASKET:  drawGasket(g, level, gasketP1, gasketP2, gasketP3 ); 
                     break;
            case BOXES:  drawBoxes(g, level, new Point(HBOX, VBOX), BOXSIDE, BOXDELTA ); 
                     break;
        } // switch
    } // paintComponent()
    
    /**
     * drawGasket() --- recursively draws the Sierpinski gasket pattern, 
     *  with points p1, p2, p3, representing the vertices of its enclosing triangle.
     * @param p1 -- a Point representing 1 vertex of the enclosing triangle
     * @param p2 -- a second Point of the enclosing triangle
     * @param p3 -- a third Point of the enclosing triangle
     * @param level (>= 0) is the recursion paramenter (base case: level  0)
     */
    private void drawGasket(Graphics g, int lev, Point p1, Point p2, Point p3) {
        g.drawLine(p1.x, p1.y, p2.x, p2.y);		// Draw a triangle
        g.drawLine(p2.x, p2.y, p3.x, p3.y);
        g.drawLine(p3.x, p3.y, p1.x, p1.y);
        if (lev > 0) {            // If more divisions desired, draw 3 smaller gaskets
            Point midP1P2 = new Point( (p1.x + p2.x) / 2, (p1.y + p2.y) / 2 );
            Point midP1P3 = new Point( (p1.x + p3.x) / 2, (p1.y + p3.y) / 2 );
            Point midP2P3 = new Point( (p2.x + p3.x) / 2, (p2.y + p3.y) / 2 );
            drawGasket(g, lev - 1, p1, midP1P2, midP1P3); 
            drawGasket(g, lev - 1, p2, midP1P2, midP2P3);
            drawGasket(g, lev - 1, p3, midP1P3, midP2P3);
        }
    } // drawGasket()

    /**
     * drawBoxes() --- recursively draws a pattern of nested squares with loc 
     *  as the top left corner of outer square and side being the length square's side.
     * @param loc is the top-left Point of the outer square
     * @param side is the length of the square's side
     * @param level (>= 0) is the recursion paramenter (base case: level  0)
     * @param delta is the amount by which the side is adjusted at each level
     */
    private void drawBoxes(Graphics g, int level, Point loc, int side, int delta) {
        g.drawRect(loc.x, loc.y, side, side );
        if (level > 0) {                 
            Point newLoc = new Point( loc.x + delta, loc.y + delta);
            drawBoxes(g, level - 1, newLoc, side - 2 * delta, delta);
        }
    } // drawBoxes()

} // Canvas
