/*
 * File: OneRowNimApplet.java
 * Author: Java Java Java
 * Description: This applet adds OneRowNimGUIPanel to
 *  a top-level JApplet window.
 */
import javax.swing.*;

public class OneRowNimApplet extends JApplet 
{   public void init() 
    {    getContentPane().add(new OneRowNimPanel());
    }
}
