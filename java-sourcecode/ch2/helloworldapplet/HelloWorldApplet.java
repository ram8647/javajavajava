/*
 * File: HelloWorldApplet.java 
 * Author: Java, Java, Java
 * Description: Draws "Hello World" on an applet.
 */
import java.applet.Applet;    // Import the Applet class
import java.awt.Graphics;     //  and the Graphics class

public class HelloWorldApplet extends Applet   // Class header
{                                              // Start of body
    public void paint(Graphics g)              // The paint method
    {
        g.drawString("Hello World",10,10);
    }  // End of paint
}  // End of HelloWorld
