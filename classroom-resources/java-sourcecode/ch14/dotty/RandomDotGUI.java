/*
 * File: RandomDotApplet.java
 * Author: Java, Java, Java
 * Description: This applet illustrates the problem
 *  of using a single thread to serve both the 
 *  user interface portion of a program and the
 *  computational portion of the program. If the
 *  computational portion contains a lengthy loop,
 *  the user interface will become very unresponsive.

 *  When the user clicks the Draw button a Dotty
 *  object begins drawing NDOTS dots at random locations
 *  on a JPanel. The user is supposed to click on the clear
 *  button as soon as he or she sees a red dot. When the user 
 *  clicks the Clear button, this is supposed to stop the drawing
 *  and report the number of red dots that were drawn, thereby measuring
 *  the quickness of the user's response.  However, in this
 *  single-threaded version, the drawing loop cannot be
 *  interrupted. So the user must wait until all NDOTS
 *  are drawn before the panel is cleared. Therefore, the program
 *  cannot provide an accurate measure of the user's response time.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RandomDotGUI extends JFrame implements ActionListener  {
    public final int NDOTS = 10000;
    
    private Dotty dotty;                          // The drawing class
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
     * actionPerformed() handles the GUI's action events. 
     * However, once dotty starts drawing, the clear operation
     * will have to wait until the drawing is completed. This
     * can lead to a noticeable delay.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == draw) {
            dotty = new Dotty(canvas, NDOTS);
            dotty.draw();
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
