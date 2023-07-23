import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class BouncingBallApplet extends Applet {
    Ball ball;
    //     Thread ballThread;
     Image offscreenImage;
     Graphics offscreenGraph;
     Dimension appletDim;
     Insets appletInsets;
    //     int xCoord = 20, yCoord, ballWidth = 30, ballHeight = 30;
    //     boolean xReverse, yReverse;

     public void init()
     {
         if (getBackground().equals(Color.white))
             setBackground(Color.lightGray);

         appletDim = getSize();
         appletInsets = getInsets();

         /* Create the offscreen image and graphics context */
         offscreenImage = createImage(appletDim.width,appletDim.height);
         offscreenGraph = offscreenImage.getGraphics();
     }

     public void start()
     {
         if (ball == null)
         {
             /* Start the animation thread */
	     //             ball = new Thread(this);
             ball = new Ball(this);
             ball.start();
         }
     }

     public void stop()
     {
         /* Stop the animation thread */
         if (ball != null)
	     //             ball = null;
             ball.stopBall();
     }

     public void update(Graphics g)
     {
         /* Clear the offscreen graphics context */
         offscreenGraph.setColor(getBackground());
         offscreenGraph.fillRect(0,0,appletDim.width,appletDim.height);

         /* Draw on the offscreen graphics context */
         offscreenGraph.setColor(Color.blue);
         offscreenGraph.fillOval(ball.xCoord,ball.yCoord,ball.width,ball.height);

         /* Draw the offscreen image to the visible graphics context */
         g.drawImage(offscreenImage,0,0,this);

         synchronized(this)
         {
	     //             notifyAll();
	     //             notify();
             System.out.println("Notified");
         }
     }

     public void paint(Graphics g)
     {
         System.out.println("Painting");
         update(g);
     }

     public void destroy()
     {
         /* Explicitly dispose of the offscreen graphics context */
         if (offscreenGraph != null)
             offscreenGraph.dispose();
     }
}
