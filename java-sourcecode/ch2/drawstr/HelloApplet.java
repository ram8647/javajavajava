import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet {

     public void paint(Graphics g) {
         g.drawString("Hello World", 10, 10);
         g.drawString("Welcome to Java", 10, 35);
     }
}
