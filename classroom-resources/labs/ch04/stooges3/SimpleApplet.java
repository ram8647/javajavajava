/*
 * File: SimpleApplet.java
 * Author: Java, Java, Java
 * Description: This program illustrates the basic 
 *  format for a Java applet. The SimpleApplet class
 *  extends the Applet class and implements the ActionListener
 *  interface. The applet's execution begins in the init()
 *  method, which is called automatically by the browser. It
 *  initialized the applet. The actionPeformed() method is
 *  called automatically whenever the user clicks on the toggle
 *  button. Each time the button is clicked, it changes its
 *  label. Clicking a button is an example of a "action event",
 *  which is handled by the actionPerformed() method.
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleApplet extends Applet implements ActionListener
{
    private Button toggle;       // From java.awt.Button

     
   /* 
    * The init() method instantiates the toggle Button, assigns
    * it an ActionListener, and adds it to the applet. This causes
    * the button to appear on the applet's window.
    */
    public void init()
    {
        toggle = new Button ("The machine is off");
        toggle.addActionListener(this);
        add(toggle);
    } // init()

    /*
     * The actionPerformed() method is called whenever the toggle
     * button is clicked. It reverses the button's label.
     */
    public void actionPerformed(ActionEvent e) 
    {
        String str = toggle.getLabel();              // Get the toggle Button's label
        if (str.equals("The machine is on"))         // and change it
	    toggle.setLabel("The machine is off");
        else                                         // or
            toggle.setLabel("The machine is on");    // change it back
    } // actionPerformed()
} // SimpleApplet
