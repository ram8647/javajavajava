import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
  private static final int GASKET = 0, BOXES = 1;
  public static final int WIDTH=400, HEIGHT=400;
  private final int HBOX=10, VBOX=50, BOXSIDE=200, BOXDELTA=10;
  private final int gP1X = 10;  private final int gP1Y = 280; // Initial
  private final int gP2X = 290; private final int gP2Y = 280; // gasket
  private final int gP3X = 150; private final int gP3Y = 110; // points
  private int pattern = 0 ;                      // Current pattern
  private int level = 4;                         // Current level

  public Canvas() {
    setSize(WIDTH, HEIGHT);
  }
  public void setPattern(int pat, int lev) {
    pattern = pat;
    level = lev;
  }

  public void paintComponent(Graphics g) {
        g.setColor(getBackground());   // Redraw the panel's background
        g.drawRect(0, 0, WIDTH, HEIGHT);
        g.setColor(getForeground());
        switch (pattern) {
        case GASKET:
            drawGasket(g, level, gP1X, gP1Y, gP2X, gP2Y, gP3X, gP3Y);
            break;
        case BOXES:
            drawBoxes(g, level, HBOX, VBOX, BOXSIDE, BOXDELTA );
            break;
        } // switch
    } // paint()
  
   /** drawGasket()---recursively draws the Sierpinski
    *  gasket pattern, with points (p1X, p1Y), (p2X, p2Y), (p3X, p3Y)
    *  representing the vertices of its enclosing triangle.
    * level (>= 0) is the recursion parameter (base case: level  0)
    */
    private void drawGasket(Graphics g, int lev, int p1X, int p1Y,
                   int p2X, int p2Y, int p3X, int p3Y) {
        g.drawLine(p1X, p1Y, p2X, p2Y);  // Draw a triangle
        g.drawLine(p2X, p2Y, p3X, p3Y);
        g.drawLine(p3X, p3Y, p1X, p1Y);
        if (lev > 0) { // If more levels, draw 3 smaller gaskets
            int q1X = (p1X + p2X) / 2;    int q1Y = (p1Y + p2Y) / 2;
            int q2X = (p1X + p3X) / 2;    int q2Y = (p1Y + p3Y) / 2;
            int q3X = (p2X + p3X) / 2;    int q3Y = (p2Y + p3Y) / 2;
            drawGasket(g, lev - 1, p1X, p1Y, q1X, q1Y, q2X, q2Y);
            drawGasket(g, lev - 1, p2X, p2Y, q1X, q1Y, q3X, q3Y);
            drawGasket(g, lev - 1, p3X, p3Y, q2X, q2Y, q3X, q3Y);
        }
    } // drawGasket()
  
   /** drawBoxes()---recursively draws pattern of nested squares
    *  with (locX, locY) the top left corner of outer the square and
    *  side being the length square's side.
    * level (>= 0) is the recursion parameter (base case: level  0)
    * delta is used to adjust the length of the side.
    */
    private void drawBoxes(Graphics g, int level,
           int locX, int locY, int side, int delta) {
        g.drawRect(locX, locY, side, side );
        if (level > 0) {
            int newLocX = locX + delta; int newLocY = locY + delta;
            drawBoxes(g, level - 1, newLocX, newLocY,
                                          side - 2 * delta, delta);
        }
    } // drawBoxes()
} // PatternCanvas
