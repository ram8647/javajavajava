/*
 * File: GreeterGUIPanel.java
 * Author: Java Java Java
 * Description: This class defines a GUI contained within a JPanel,
 *  rather than directly in a top-level window, such as a JApplet 
 *  or JFrame.  The advantage of this design is that the panel can
 *  be embedded directly into a web page.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreeterGUIPanel extends JPanel implements ActionListener 
{   private JTextArea display;
    private JTextField inField;
    private JButton goButton;
    private Greeter greeter;
	    
    public GreeterGUIPanel() 
    {   greeter = new Greeter();  
        buildGUI();
    } // GUIPanel()

    private void buildGUI() 
    {   display = new JTextArea(10,30);
        inField = new JTextField(10);
        goButton = new JButton("Click here for a greeting!");
        goButton.addActionListener(this);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input your name here: "));
        inputPanel.add(inField);
        inputPanel.add(goButton);
        add("Center", display);
        add("South", inputPanel);
    } //buildGUI()

    public void actionPerformed(ActionEvent e) 
    {   if (e.getSource() == goButton) 
        {   String name = inField.getText();
            display.append(greeter.greet(name) + "\n");
        } // if
    } // actionPeformed()
} // GreeterGUIPanel
