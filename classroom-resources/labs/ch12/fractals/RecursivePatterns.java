/*
 * File: RecursivePatterns.java
 * Author: Java, Java, Java
 * Description: This applet provides a GUI interface for
 *  for the Canvas class, which draws recursive patterns
 *  selected by the user. Two JComboBoxes are provided, one
 *  to select a pattern, and one to select a level of recursion.
 *  Whenever the user makes a selection, the itemStateChanged() method 
 *  invokes canvas.setPattern() to draw the selected pattern.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RecursivePatterns extends JApplet implements ItemListener  {
    private String choices[] = {"Sierpinski Gasket", "Nested Boxes"};
    private JComboBox patterns = new JComboBox(choices);     // Pattern choices
    private JComboBox levels = new JComboBox();              // Level choices
    private Canvas canvas = new Canvas();                    // Drawing panel
    private JPanel controls = new JPanel();                 
    
    /**
     * init() sets up the applet's interface. Two JComboBoxes are
     *  created and given items. Note the use the border around
     *  the drawing canvas. Each JComboBox is assigned the applet
     *  itself as its ItemListener. 
     */
    public void init() {
        for (int k=0; k < 10; k++)                 // Add 10 levels
            levels.addItem(k + "" ); 
        patterns.setSelectedItem(choices[0]);      // Initialize the menus
        levels.setSelectedItem("4");
	  
        canvas.setBorder(BorderFactory.createTitledBorder("Drawing Canvas"));
        controls.add(levels);                     // Control panel for menus
        controls.add(patterns);	   
        getContentPane().add(controls,"North");   // Add the controls
        getContentPane().add(canvas,"Center");    // And the drawing panel
        levels.addItemListener( this );   // Register the menus with a listener
        patterns.addItemListener( this ); 
        setSize(canvas.WIDTH,canvas.HEIGHT+controls.getSize().width);
    } // init()
 
    /**
     * itemStateChanged() is the only method of the ItemListener interface.
     *  It is invoked whenever the user makes a selection in a JComboBox.
     *  In this case the selections from both JComboBoxes are passed along
     *  to canvas.setPattern(). Repainting the applet causes all of its
     *  contained componenets to be repainted, including the canvas.
     * @param e -- the ItemEvent that describes the user's selection.
     */
    public void itemStateChanged(ItemEvent e) {
        canvas.setPattern(patterns.getSelectedIndex(), levels.getSelectedIndex());
        repaint();	                                // Repaint the applet
    } // itemStateChanged()
} // RecursivePatterns
