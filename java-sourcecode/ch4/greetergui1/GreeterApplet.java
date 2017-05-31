/*
 * File: GreeterApplet.java
 * Author: Java Java Java
 * Description: This applet simply creates a GreeterGUI,
 *  which uses Java's event-processing loop to control interaction
 *  between the program and the user.
 */
import javax.swing.*;

public class GreeterApplet extends JApplet 
{
    public void init() 
    {
        new GreeterGUI("Greeter");
    }
}
