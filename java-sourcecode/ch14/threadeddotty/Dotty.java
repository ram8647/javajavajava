

/*
 * File: Dotty.java
 * Author: Java, Java, Java
 * Description: This class takes care of the drawing
 *  task. When a Dotty is created it is given a number
 *  representing the number of dots to draw and a reference
 *  to the drawing canvas. When its draw() method is called
 *  it begins drawing dots at random locations on the canvas.
 *  When its clear() method is called it clears the drawing canvas.

 * This version of Dotty implements the Runnable interface, 
 *  enabling it to run as a separater thread from the applet
 *  that creates it. This design leads to a more responsive
 *  user interface.
 */

import java.awt.*;
import javax.swing.*;

public class Dotty implements Runnable {
    private static final int HREF = 20, VREF = 20, LEN = 200; // Coordinates

    private JPanel canvas;
    private int nDots;                 // Number of dots to draw
    private int nDrawn;                // Number of dots drawn
    private int firstRed = 0;          // Number of the first red dot
    private boolean isCleared = false; // The panel has been cleared  

    public void run() {
        draw();
    }
   
    /**
     * Dotty() constructor is given the number of dots to draw
     *  and a reference to the drawing panel.
     * @param dots -- the number of dots
     * @canv -- the reference to the drawing panel
     */
    public Dotty(JPanel canv, int dots) {
        canvas = canv;
        nDots = dots;
    }
   
    /**
     * draw() draws ndots dots at random locations. After some
     *  random number of black dots, it changes the drawing color to red.
     *  Note that this version of draw() sleeps for an instance on each
     *  each iteration. This gives the applet thread a chance to run,
     *  making it more responsive to user input.
     */
    public void draw() {
        Graphics g = canvas.getGraphics();
        for (nDrawn = 0; !isCleared && nDrawn < nDots; nDrawn++) {
            int x = HREF + (int)(Math.random() * LEN);
            int y = VREF + (int)(Math.random() * LEN);  	       
            g.fillOval(x, y, 3, 3);                      // Draw a dot
		 
           if (Math.random() < 0.001 && firstRed == 0) {
               g.setColor(Color.red);                    // Change color to red
               firstRed = nDrawn;
           }

           try { 
               Thread.sleep(1) ;                      // Sleep for an instant
           } catch (InterruptedException e) {
               System.out.println(e.getMessage());
           }

        } //for
    } // draw()

    /**
     * clear() clears the drawing panel
     */
    public void clear() {
        isCleared = true;
        Graphics g = canvas.getGraphics();
        g.setColor( canvas.getBackground() );
        g.fillRect(HREF,VREF,LEN+3,LEN+3);
        g.setColor(Color.black);
        g.drawString("Dots since first red = " + (nDrawn-firstRed),HREF,VREF+LEN);
	//        System.out.println("Number of dots drawn since first red = " + (nDrawn-firstRed) );
    } // clear()
} // Dotty
