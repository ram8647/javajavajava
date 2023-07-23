/*
 * File: HelloWorldApplet.java
 * Author: Java Java Java
 * Description: Draws "Hello World" on an applet.
 */

import java.applet.Applet; // Import class names
import java.awt.Graphics;

public class HelloWorldApplet extends Applet // Class header
{                                            // Start of body
     public void paint(Graphics g)           // The paint method
     {
         g.drawString("Hello World!", 10, 10);
     }  // End of paint
}  // End of HelloWorld
