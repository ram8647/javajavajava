/*
* File: HelloWorldCanvas.java
* Author: Java Java Java
* Description: Draws "Hello World" on a JFrame.
*/

import javax.swing.JFrame; // Import class names
import java.awt.Graphics;
import java.awt.Canvas;

public class HelloWorldCanvas extends Canvas // Class header
{                                            
    // Start of body
    public void paint(Graphics g)           
        // The paint method
    {
        g.drawString("Hello, World!", 10, 10);
    }  // End of paint

    public static void main(String[] args){
        HelloWorldCanvas c = new HelloWorldCanvas();
        JFrame f = new JFrame();
        f.add(c);
        f.setSize(150,50);
        f.setVisible(true);
    }
}  // End of HelloWorldCanvas
