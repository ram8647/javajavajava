/*  Professional advice on Java animation stresses (A) USING THREADS
and (B) USING A DOUBLE BUFFERED TECHNIQUE to avoid flicker.
  See advice on
   http://www.cuj.com/documents/s=8467/cujjsup1808paternos/
One of two examples (the Applet example) from that site is given here.
THIS CODE DOES NOT SEEM TO BE A GOOD EXAMPLE FOR LOOPS.
WE SHOULD DECIDE WHETHER WE CAN CREATE A SIMPLIFIED
ANIMATION EXAMPLE THAT WOULD BE ANY BETTER.
IT IS NOT CLEAR TO ME THAT WE CAN AVOID USING THREADS AND EXCEPTIONS??!!
*/

import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class BouncingBallApplet extends Applet implements Runnable {
     Thread ballThread;
     Image offscreenImage;
     Graphics offscreenGraph;
     Dimension appletDim;
     Insets appletInsets;
     int xCoord = 20, yCoord, ballWidth = 30, ballHeight = 30;
     boolean xReverse, yReverse;

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
         if (ballThread == null)
         {
             /* Start the animation thread */
             ballThread = new Thread(this);
             ballThread.start();
         }
     }

     public void stop()
     {
         /* Stop the animation thread */
         if (ballThread != null)
             ballThread = null;
     }

     public synchronized void run()
     {
         while(ballThread != null)
         {
             if (!xReverse)
             {
                 if ((++xCoord + ballWidth) >=
                     (appletDim.width - appletInsets.left))
                     xReverse = true;
             }
             else
             {
                 if (--xCoord <= appletInsets.right)
                     xReverse = false;
             }

             if (!yReverse)
             {
                 if ((++yCoord + ballHeight) >=
                     (appletDim.height - appletInsets.bottom))
                     yReverse = true;
             }
             else
             {
                 if (--yCoord <= appletInsets.top)
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
         offscreenGraph.fillRect(0,0,appletDim.width,appletDim.height);

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

     public void destroy()
     {
         /* Explicitly dispose of the offscreen graphics context */
         if (offscreenGraph != null)
             offscreenGraph.dispose();
     }
}
