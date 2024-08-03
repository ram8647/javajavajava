/*
 * File: DrawSticksCanvas.java
 * Author: Java Java Java
 * Description: This uses Java's built-in 
 *  drawing methods to draw vertical lines on its window.
 *  It draws a set of 12 vertical lines and a set of 7 lines.
 */

import java.awt.*;
import javax.swing.*;

public class DrawSticksCanvas extends Canvas
{
    /** drawSticks(g,x,y,num) will draw num vertical line
     * segments.  The line segments are 10 pixels apart and
     * 50 pixels long. The top endpoint of the left most
     *line segment is at the point (x,y).
     */
    public void drawSticks(Graphics g, int x, int y, int num)
    {   int k = 0;
        while (k < num)
        {   g.drawLine(x, y, x, y + 50);
            x = x + 10;
            k = k + 1;
        } // while
    } // drawSticks()

    public void paint(Graphics g)
    {
	g.setColor(Color.red);
	drawSticks(g, 25, 25, 12);
        g.setColor(Color.cyan);
        drawSticks(g, 25, 125, 7);
    } // paint()

        // every java program needs a main to run!
    public static void main(String[] args){
        DrawSticksCanvas c = new DrawSticksCanvas();
        JFrame f = new JFrame("Draw Sticks Program");
        f.add(c);
        f.setSize(200,300);
        f.setVisible(true);
    }

} // DrawSticksCanvas
