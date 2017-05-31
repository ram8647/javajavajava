/*   * File: Ball.java
   * Author: Java, Java, Java
   * Description: This class defines a ball that bounces back and forth
   *  and up and down within an applet. The "bouncing" is effected by
   *  repeatedly drawing, erasing and moving the ball in the run() method.
   *  Note the use of class constants in the program and the use of
   *  XOR mode in the draw method.
   * This version of Ball also keeps track of the location of the paddle.
   * The applet is used to mediate the connection between the paddle and the
   * ball. Whenever the ball hits the paddle, it bounces at a random angle.
   */

import javax.swing.*;
import java.applet.*;
import java.awt.*;

public class Ball extends Thread {
      public static final int SIZE = 10;   // Diameter of the ball
      private PongApplet applet;           // Reference to the applet
      private int topWall, bottomWall, leftWall, rightWall;  // Boundaries
      private int locationX, locationY;     // Current location of the ball
      private int directionX = 1, directionY = 1; //x- and y-direction (1 or -1)
      private Toolkit kit = Toolkit.getDefaultToolkit(); //For beep() method

      /**
       * Ball() constructor sets a pointer to the applet and initializes
       *  the ball's location at the left of the bouncing region
       */
      public Ball(PongApplet app) {
          applet = app;
          locationX = leftWall + 1;                // Set initial location
          locationY = bottomWall/2;
      } // Ball()

      /**
       * A Ball() constructor that sets a pointer to the applet and
       *  specifies location and direction of ball.
       */
      public Ball(PongApplet app, int x, int y, int dir) {
          applet = app;
          locationX = x;                // Set initial location
          locationY = y;
          if (dir > 0) {
              directionX = 1;
              directionY = 1;
          } else {
              directionX = -1;
              directionY = -1;
          } // else
      } // Ball()


      /** * Return the x coordinate of the ball's location */
      public int getX() { return locationX;}

      /** * Return the y coordinate of the ball's location*/
      public int getY() { return locationY;}

      /**
      * move() changes the ball's vertical location (y-coordinate) by
      * DY pixels. It then checks if the ball has reached a boundary
      * and if so, itreverses direction
      */
      public void move() {
           rightWall = applet.getWidth() - SIZE;   // Define bouncing region
           leftWall = topWall = 0;                 // And location of walls
           bottomWall = applet.getHeight() - SIZE;
           locationX = locationX + directionX; // Calculate a new location
           locationY = locationY + directionY;

           if (applet.ballHitsPaddle(this)){
               directionX = -1;   //  move toward left wall
               kit.beep();
           } //if ball hits paddle

           if (locationX <= leftWall){
               directionX = + 1;   //  move toward right wall
               kit.beep();
           } //if ball hits left wall

           if (locationY + SIZE >= bottomWall || locationY <= topWall){
               directionY = -directionY;      //  reverse direction
               kit.beep();
           } //if ball hits top or bottom walls

           if (locationX  >= rightWall + SIZE) {
               locationX = leftWall + 1;   // jump back to left wall
           } //if ball goes through right wall
       } // move()

       /** * run() repeatedly draws, erases and moves the ball*/
       public void run() {
           while (true) {
               move();                // Move
               applet.repaint();
               try {  sleep(15);
               } catch (InterruptedException e) {}
           } // while
       } // run()
       
} // Ball

