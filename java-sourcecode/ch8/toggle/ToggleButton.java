/*
 * File: ToggleButton.java
 * Author: Java, Java, Java
 * Description:  This class uses Java's inheritance mechanism
 *  to define a toggle button as a specialization of Java's Button
 *  class. A toggle button is one that toggles its label between
 *  two possible values (e.g., On/Off) each time it is clicked.  It
 *  does this in addition to carrying out whatever action it is 
 *  associated with (like turning the lights on or off).

 *  The toggle action will be performed by the button itself in
 *  its own actionPerformed() method. Thus a ToggleButton acts 
 *  as an ActionListener for itself.  This toggling happens independently
 *  of any action that may be associated with the button by the applet.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToggleButton extends JButton implements ActionListener
{
    private String label1;   // Two Labels to toggle between
    private String label2;
   
    /**
     * The ToggleButton constructor initializes its two labels and
     *  assigns the button itself as its own ActionListener.
     * @param l1 is a String representing the button's initial label
     * @param l2 is a String representing the button's secondary label
     */
    public ToggleButton(String l1, String l2) // Constructor method
    {
        super(l1);                // Use l1 as the default label
        label1 = l1; 
        label2 = l2;
        addActionListener(this);
    } 

    /**
     * The actionPerformed() method swaps the button's two labels
     *  in memory, and then resets the button's label to label1. 
     *  Note the use of the temporary String variable to perform the swap.
     * @param ActionEvent e represents the event that led to this action.
     */
    public void actionPerformed(ActionEvent e) 
    {
        String tempS = label1;  // Swap the labels
        label1 = label2;
        label2 = tempS;
        setText(label1);
    } // actionPerformed()
} // ToggleButton

