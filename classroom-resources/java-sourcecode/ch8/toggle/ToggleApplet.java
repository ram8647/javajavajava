/*
 * File: ToggleTest.java
 * Author: Java, Java, Java
 * Description:  This applet test the ToggleButton class.
 *  It creates a ToggleButton and lets the user click on
 *  on it repeatedly. The button's label should alternate
 *  between "off" and "on" on each click.
 *
 *  Note that the applet defines its own actionPerformed() 
 *  method. Whenever the toggle button is clicked, the
 *  applet reports this fact on the browser's status line.
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToggleApplet extends JApplet implements ActionListener
{
    private ToggleButton lightSwitch;  

    public void init()
    {
        lightSwitch = new ToggleButton ("off","on");
        getContentPane().add(lightSwitch);
        lightSwitch.addActionListener(this);
    } // init()

    public void actionPerformed(ActionEvent e) 
    {
        showStatus("The light is " + lightSwitch.getText());
    } // actionPerformed()
} // ToggleApplet
