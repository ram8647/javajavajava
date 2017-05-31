/*
 * File: TemperatureJPanel.java
 * Author: Java, Java, Java
 * Description:  The class provides a solution to Self-study exercise 5.15.
 *
 * Problem: Following the design for the GUI developed in Chapter 4, implement
 *  a GUI to use for testing the Temperature class. The GUI should have the
 *  layout shown in Figure 5.7.
 *
 * NOTE: This JPanel must be used with a JApplet top-level window as per
 *  Chapter 4.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureJPanel extends JPanel implements ActionListener
{   private JTextField inField = new JTextField(15);              // GUI components
    private JTextField resultField = new JTextField(15);
    private JLabel prompt1 = new JLabel("Input Temperature >>");
    private JLabel prompt2 = new JLabel("Conversion Result:");
    private JButton celsToFahr = new JButton("C to F");
    private JButton fahrToCels = new JButton("F to C");
    private JPanel panelN = new JPanel(); // Panels 
    private JPanel panelC = new JPanel();  
    private JPanel panelS = new JPanel();
    private Temperature temperature = new Temperature(); // Temperature object

    /**
     * TemperatureJPanel() default constructor sets up the user interface
     *  by defining the layout and the input, output, and control elements.
     */
    public TemperatureJPanel()                 // Set up  user interface
    {   setLayout(new BorderLayout());         // Use BorderLayout
        panelN.setLayout(new BorderLayout());
        panelC.setLayout(new BorderLayout());
        panelS.setLayout(new BorderLayout());
        panelN.add("North", prompt1);          // Input elements
        panelN.add("South", inField);
        panelC.add("West", celsToFahr);        // Control buttons
        panelC.add("East", fahrToCels);
        panelS.add("North", prompt2);          // Output elements
        panelS.add("South", resultField);
        add("North", panelN);                  // Input at the top
        add("Center", panelC);                 // Buttons in the center
        add("South", panelS);                  // Result at the bottom
        celsToFahr.addActionListener(this);    // Register with listeners
        fahrToCels.addActionListener(this);
        setSize(175,200);
    } // TemperatureJPanel()


    /**
     * actionPerformed() is required by the ActionListener interface. It 
     *  all the action events generated when the control buttons are pressed.
     */
    public void actionPerformed(ActionEvent e)
    {   String inputStr = inField.getText();             // User's input
        double userInput = Double.parseDouble(inputStr); // Convert to double
        double result = 0;
        if (e.getSource() == celsToFahr) {          // Process and report 
            result = temperature.celsToFahr(userInput);       
            resultField.setText(inputStr + " C = " + result  + " F");
        } else {
            result = temperature.fahrToCels(userInput);
            resultField.setText(inputStr + " F = " +  result  + " C");
        }
    } // actionPerformed
} // TemperatureJPanel
