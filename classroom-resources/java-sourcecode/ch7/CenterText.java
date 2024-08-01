import java.awt.*;
import javax.swing.*;
public class CenterText extends Canvas 
{
                // Print hello world! in center of frame
  public void paint(Graphics g) {
    String str = "Hello, World!";
    g.setFont(new Font("Random", Font.PLAIN, 24)); // Random font
    FontMetrics metrics = g.getFontMetrics(); //  And its metrics
    Dimension d = getSize();       // Get the frame's size
              // Clear the frame
    g.setColor(getBackground());
    g.fillRect(0,0,d.width,d.height);
    g.setColor(Color.black);
                                  // Calculate coordinates
    int x = (d.width - metrics.stringWidth(str)) / 2;
    int y = (d.height + metrics.getHeight()) / 2;
    g.drawString( str, x, y );          // Draw the string
  } // paint()

  public static void main(String args[]) 
  {
    CenterText ct = new CenterText();
    JFrame frame = new JFrame("CenterText");
    frame.add(ct);
    frame.setSize(300,120);
    frame.setVisible(true);
  }
} // CenterText
