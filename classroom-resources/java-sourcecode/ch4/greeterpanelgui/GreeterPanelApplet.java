/*
 * File: GreeterPanelApplet.java
 * Author: Java Java Java
 * Description: This applet creates a GreeterGUIPanel and 
 *  adds it to the applet's content pane. 
 */
import javax.swing.*;

public class GreeterPanelApplet extends JApplet 
{   public void init() 
    {    getContentPane().add(new GreeterGUIPanel());
    }
}
