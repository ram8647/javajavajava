import java.awt.*;

public class Yoyo
{   private final int width = 50;   // The yoyo's enclosing rectangle
    private final int height = 50;

    private void pause(int n)   // waste some time
    {   double x;    // increase  n to pause longer
        for (int m = 0; m < 1000*n; m++)
            x = 1.23456*1.23456;
    } // pause

     private void oneThrow(Graphics g, int time) 
    {   g.setColor(Color.red);
        g.fillOval(175,25,width,height);
        for(int k = 0; k <= 250; k++) // going down
        {   g.setColor(Color.white);
            g.fillOval(175,25 + k,width,height); // erase yoyo
            g.setColor(Color.black);
            g.drawLine(200, 25, 200, 25 + k); // draw string
            g.setColor(Color.red);
            g.fillOval(175,25 + k + 1,width,height); // draw yoyo
            pause(time);  // slow down animation
        } //for

        for(int k = 250; k >= 0; k--) // coming up
        {   g.setColor(Color.white);
            g.fillOval(175,25+k+1,width,height); // erase yoyo
            g.setColor(Color.red);
            g.fillOval(175,25 + k ,width,height); // draw yoyo
            pause(time);  // slow down animation
        } //for
    } //oneThrow()

    public void throwYoyo(Graphics g, int n, int pause) { // Do n throws
        for(int k = 1; k <= n; k++){
            oneThrow(g, pause);
        } //for
    } // throwYoyo()

} // Yoyo
