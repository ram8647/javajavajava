/*
 *  File: FontNames.java
 *  Author: Java, Java, Java
 *  Description:  This application gets the names of the first 10
 *   fonts stored in the GraphicsEnvironment and displays a
 *   string in each font. Fonts are system dependent. 
 */

import java.awt.*;
import javax.swing.*;

public class FontNames extends JFrame {
   /**
    *  paint() is called automatically to paint the JApplet each time
    *   it needs it. Note the use of vRef and vGap to space the fonts.
    */
    public void paint(Graphics g) {
       // Get the font names available in this graphics environment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
		
       // Display hello world and font's name in the first 10 fonts	
        int vRef = 30; 
        int vGap = 15;	
        g.drawString("The first 10 fonts on this system are: ", 30, vRef);
        for (int k = 0; k < fonts.length; k++) {
            System.out.println("Font " + k + " = " + fonts[k]);
	    //        for (int k = 0; k < 10; k++) {
            vRef += vGap;
	    //            g.setFont(new Font(fonts[k], Font.PLAIN, 12));
	    //            g.drawString("Hello World! (" + fonts[k] + ")", 30, vRef);
        }  
    } // paint()
    
    public static void main(String args[]) {
        FontNames f = new FontNames();
        f.setTitle("Font Names");
        f.pack();
        f.setSize(300,300);
        f.setVisible(true);
    }
} // FontNames
