/** File: PongApplet.java
   * Author: Java, Java, Java, 3E
   * Description:  In the game of pong a balls ricochet off the walls
   * of a square. The paddle on the right wall is controlled by the up
   *  and down arrow keys. The ball bounces at a random angle off the
   *  paddle and the walls.
   */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongApplet extends JApplet implements KeyListener {
      private Ball b1, b2;
      private Paddle pad;

      /**
       * init() creates the ball and paddle objects, and registers as the
       *  KeyListener. It also must requestFocus() so that it will receive
       *  key events.
       */
      public void init() {
          setBackground(Color.white);
          addKeyListener(this);
          pad = new Paddle(this);  // Create the paddle
          b1 = new Ball(this, 200, 100, 1); // Create two balls
          b2 = new Ball(this, 200, 100, -1);
          b1.start();  //Start them
          b2.start();
          requestFocus();  // Required to receive key events
      } // init()

      /**  * paint() renders the scene */
      public void paint (Graphics g ) {
           g.setColor(getBackground());
           g.fillRect(0,0,getWidth(),getHeight());
           /* Draw the balls */
           g.setColor(Color.blue);
           g.fillOval(b1.getX(), b1.getY(), b1.SIZE, b1.SIZE);
           g.fillOval(b2.getX(), b2.getY(), b2.SIZE, b2.SIZE);
           /* Draw the paddle */
           pad.resetLocation();
           g.setColor(Color.red);
           g.fillRect(pad.getX(),pad.getY(),Paddle.WIDTH,Paddle.HEIGHT);
      } // paint()

      /**
       * hitPaddle() returns true if ball hits paddle.
       * @return -- a boolean which is true if paddle and ball are touching
       */
       public boolean ballHitsPaddle(Ball ball) {
           return ball.getX() + Ball.SIZE >= pad.getX()
              && ball.getY() >= pad.getY()
              && ball.getY() <= pad.getY() + Paddle.HEIGHT;
      } // ballHitsPaddle()

      /**
       * keyTyped() is invoked every time a KeyEvent occurs.
       * It getscthe key's code and checks whether the up
       *   or down arrow keys were pressed. If so it moves
       *  the paddle.
       */
      public void keyPressed( KeyEvent e) { // Check for arrow keys
          int keyCode = e.getKeyCode();
          if (keyCode == e.VK_UP)            // Up arrow
              pad.moveUp();
          else if (keyCode == e.VK_DOWN)     // Down arrow
              pad.moveDown();
      } // keyReleased()

      public void keyTyped(KeyEvent e) {}
      public void keyReleased( KeyEvent e) {} // Unused
} // PongApplet