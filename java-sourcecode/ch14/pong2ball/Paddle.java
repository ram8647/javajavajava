/*
   * File: Paddle.java
   * Author: Java, Java, Java
   * Description: This class represents a paddle for the Pong game.
   *  The paddle is a vertical line segment located at the right boundary.
   *  Its motion is controlled by the user via up/down arrow keys. Therefore
   *  the paddle needs a reference to the applet. The Paddle class contains
   *  move() and draw() methods.
   */

import java.awt.*;

public class Paddle {
    public static final int HEIGHT = 50;        // Size of Paddle
    public static final int WIDTH = 10;        // Size of Paddle
    private static final int DELTA = HEIGHT/2;  // Size of each move
    private static final int BORDER = 0;
    private int gameAreaHeight;
    private int locationX, locationY;
    private PongApplet applet;

    /**
     * Paddle() constructor is passed a reference to the applet, which it
     *  uses to determine the dimensions of the game area.
     */
    public Paddle (PongApplet a) {
        applet = a;
        gameAreaHeight  = a.getHeight();
        locationX = a.getWidth()-WIDTH;
        locationY = gameAreaHeight/2;
    } // Paddle()

     public void resetLocation() {
        gameAreaHeight  = applet.getHeight();
        locationX = applet.getWidth()-WIDTH;
     }
      /**
       * Return the x coordinate of the paddle's location
       */
      public int getX() {
          return locationX;
      }

      /**
       * Return the x coordinate of the paddle's location
       */
      public int getY() {
          return locationY;
      }

    /**
     * moveUp() moves the paddle up by a fixed DELTA
     */
    public void moveUp () {
        if (locationY > BORDER )
            locationY -= DELTA;
    } // moveUp()

    /**
     * moveDown() moves the paddle down by a fixed DELTA
     */
    public void moveDown() {
        if (locationY + HEIGHT < gameAreaHeight - BORDER)
            locationY += DELTA;
    } // moveDown()
} // Paddle
