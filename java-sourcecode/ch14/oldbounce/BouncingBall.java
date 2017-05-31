import java.awt.event.*;
import java.awt.*;

public class BouncingBall {

     public static void main(String args[]) {
         new BouncingBallFrame("Bouncing Ball");
     }
}

class BouncingBallFrame extends Frame implements Runnable {
     Thread ballThread;
     Image offscreenImage;
     Graphics offscreenGraph;
     Dimension frameDim;
     Insets frameInsets;
     int xCoord, yCoord, ballWidth = 30, ballHeight = 30;
     boolean xReverse, yReverse;

     BouncingBallFrame(String title) {
         super(title);

         /* Add the window listener */
         addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent evt) {

                 /* Stop the animation thread */
                 if (ballThread != null)
                     ballThread = null;

                 /* Explicitly dispose of the offscreen graphics context */
                 if (offscreenGraph != null)
                     offscreenGraph.dispose();

                 /* Dispose the frame and exit */
                 dispose();
                 System.exit(0);}});

         /* Size the frame */
         setSize(200,200);

         /* Set the frame unsizable */
         setResizable(false);

         /* Center the frame */
         Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
         frameDim = getSize();
         setLocation((screenDim.width - frameDim.width) / 2,
            (screenDim.height - frameDim.height) / 2);

         /* Show the frame */
         setVisible(true);

         /* Start the animation thread */
         ballThread = new Thread(this);
         ballThread.start();
     }

     public synchronized void run()
     {
         while(ballThread != null)
         {
             if (!xReverse)
             {
                 if ((++xCoord + ballWidth) >=
                     (frameDim.width - frameInsets.left))
                     xReverse = true;
             }
             else
             {
                 if (--xCoord <= frameInsets.right)
                     xReverse = false;
             }

             if (!yReverse)
             {
                 if ((++yCoord + ballHeight) >=
                     (frameDim.height - frameInsets.bottom))
                     yReverse = true;
             }
             else
             {
                 if (--yCoord <= frameInsets.top)
                     yReverse = false;
             }

             repaint();

             try
             {
                 wait();
                 Thread.sleep(10); //optional
             }
             catch(InterruptedException ie)
             {
                 //no op
             }
         }
     }

     public void update(Graphics g)
     {
         /* Clear the offscreen graphics context */
         offscreenGraph.setColor(getBackground());
         offscreenGraph.fillRect(0,0,frameDim.width,frameDim.height);

         /* Draw on the offscreen graphics context */
         offscreenGraph.setColor(Color.blue);
         offscreenGraph.fillOval(xCoord,yCoord,ballWidth,ballHeight);

         /* Draw the offscreen image to the visible graphics context */
         g.drawImage(offscreenImage,0,0,this);

         synchronized(this)
         {
             notifyAll();
         }
     }

     public void paint(Graphics g)
     {
         update(g);
     }

     public void addNotify()
     {
         super.addNotify();

         /* Create the offscreen image and graphics context */
         offscreenImage = createImage(frameDim.width,frameDim.height);
         offscreenGraph = offscreenImage.getGraphics();

         frameInsets = getInsets();

         xCoord = frameInsets.left;
         yCoord = frameInsets.top;
     }
}