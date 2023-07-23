/* 
 * File: GreeterGUI2.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 4.2. 
 * Exercise: Modify the GreeterGUI class so that it allows
 *   the JTextField to serve as a control element as well as
 *   an input element. Every time the user types a Return in
 *   the JTextField, it should take action.
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreeterGUI2 extends JFrame implements ActionListener 
{   private JTextArea display;
    private JTextField inField;
    private Greeter greeter;
	    
    public GreeterGUI2(String title) 
    {   greeter = new Greeter();  
        buildGUI();
        setTitle(title);
        pack();
        setVisible(true);
    } // GreeterGUI2()

    private void buildGUI() 
    {   Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        display = new JTextArea(10,30);
        inField = new JTextField(10);
        inField.addActionListener(this);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input your name and type enter: "));
        inputPanel.add(inField);
        contentPane.add("Center", display);
        contentPane.add("South", inputPanel);
    } // buildGUI()

    public void actionPerformed(ActionEvent e) 
    {   if (e.getSource() == inField) 
        {   String name = inField.getText();
            display.append(greeter.greet(name) + "\n");
        }
    } // actionPerformed()
} // GreeterGUI2
