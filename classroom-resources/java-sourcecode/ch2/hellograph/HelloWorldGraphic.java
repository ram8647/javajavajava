/*
 * File: HelloWorldGraphic.java
 * Author: Java Java Java
 * Description: Draws a message inside a rectangle.
 */
import java.awt.*;
import java.applet.*;

public class HelloWorldGraphic  extends Applet 
{   public void paint(Graphics g) 
    {   g.setColor(Color.cyan);              // Set color
        g.fillRect(25, 25, 140, 40);         // Fill rectangle
        g.setColor(Color.blue);              // Set color
        g.drawRect(25, 25, 140, 40);         // Outline rectangle
        g.setColor(Color.black);             // Set color
        g.drawString("Hello World", 50, 50); // Display string
        g.setColor(Color.yellow);          
        g.fillOval(25, 75, 140, 40);         // Fill oval
        g.setColor(Color.red);
        g.drawOval(25, 75, 140, 40);         // Outline oval
        g.setColor(Color.black);
        g.drawString("Welcome to Java", 50, 100);
    } // paint()
} // HelloWorldGraphic
