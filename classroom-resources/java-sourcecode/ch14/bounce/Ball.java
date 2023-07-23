import java.awt.*;
import java.applet.*;

public class Ball extends Thread {
     public int width = 30, height = 30;
     public int xCoord = 20, yCoord;
     private boolean xReverse, yReverse;
     private Dimension appletDim;
     private Insets appletInsets;
    private boolean stopped = false;
    private Applet applet;

     public Ball (Applet a) {
         applet = a;
         appletDim = a.getSize();
         appletInsets = a.getInsets();
     }

    public void stopBall() {
        stopped = true;
        System.out.println("Stopped");
    }

     public synchronized void run()
     {
         while(!stopped)
         {
             System.out.println("Running");
             if (!xReverse)
             {
                 if ((++xCoord + width) >=
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
                 if ((++yCoord + height) >=
                     (appletDim.height - appletInsets.bottom))
                     yReverse = true;
             }
             else
             {
                 if (--yCoord <= appletInsets.top)
                     yReverse = false;
             }

             applet.repaint();
             System.out.println("Called repaint");

             try
             {
		 //                 wait();
                 Thread.sleep(10); //optional
             }
             catch(InterruptedException ie)
             {
                 //no op
             }
             System.out.println("End of Running");
         }
     }

}
