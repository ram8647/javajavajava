/*
 * File: SimpleGui.java
 * Author: Java Java Java
 * Description: This class creates and displays a JFrame,
 *  which is one type of top-level Java window.
 */
import javax.swing.*;

public class SimpleGUI extends JFrame 
{
    public SimpleGUI(String title) 
    {   setSize(200,150);
        setLocation(100, 150);
        setTitle(title);
        setVisible(true); // Displays the JFrame
    } // SimpleGUI()

    public static void main(String args[]) 
    {   new SimpleGUI("My GUI");
    } // main()
} // SimpleGUI class
