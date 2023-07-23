

/*
 * File: RandomDotGUI.java
 * Author: Java, Java, Java
 * Description: This applet creates a multithreaded
 *  solution to the problem of drawing random dots.
 *  In this case the user interface portion of a program and the
 *  computational portion of the program are separate threads. 
 *  By making the drawing thread sleep on each iteration, the
 *  applet thread can respond to user input, thereby making
 *  the program more responsive.

 *  When the user clicks the Draw button a Dotty
 *  object begins drawing NDOTS dots at random locations
 *  on a JPanel. The user is supposed to click on the clear
 *  button as soon as he or she sees a red dot. When the user 
 *  clicks the Clear button, this is supposed to stop the drawing
 *  and report the number of red dots that were drawn, thereby measuring
 *  the quickness of the user's response.  In this multithreaded
 *  design, the program does indeed stop drawing as soon as the
 *  user clicks the button.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RandomDotGUI extends JFrame implements ActionListener  {
    public final int NDOTS = 10000;
    
    private Dotty dotty;                          // The drawing class
    private Thread dottyThread;
    private JPanel controls = new JPanel();
    private JPanel canvas = new JPanel();
    private JButton draw = new JButton("Draw");
    private JButton clear = new JButton("Clear");
 	
    /**
     * init() sets up the applet interface which consists
     *  of the Draw and Clear buttons.
     */
    public RandomDotGUI() {
        getContentPane().setLayout(new BorderLayout());
        draw.addActionListener(this);
        clear.addActionListener(this);
        controls.add(draw);
        controls.add(clear);
        canvas.setBorder(BorderFactory.createTitledBorder("Drawing Canvas"));
        getContentPane().add("North", controls);
        getContentPane().add("Center", canvas);
        getContentPane().setSize(400, 400);
    } // init()
		
    /**
     * actionPerformed() handles the applet's action events. 
     *  Note that dotty, the drawing object, is created as a
     *  Thread and then started. Since dotty is a separate
     *  thread of execution, it can be made to sleep occasionally
     *  to give the applet thread a chance to run. This makes
     *  the applet more responsive to user input.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == draw) {
            dotty = new Dotty( canvas, NDOTS );
            dottyThread = new Thread(dotty);
            dottyThread.start();
        } else {
            dotty.clear();
	}	   
    } // actionPerformed()
 
    public static void main(String args[]){
        RandomDotGUI gui = new RandomDotGUI();
        gui.setSize(400,400);
        gui.setVisible(true);
    }

} // RandomDotGUI
