/*
 * File: FileChooser.java
 * Author: Java, Java, Java
 * Description: This program illustrates the use of the 
 *  JFileChooser class. It creates a JFileChooser and
 *  uses it to browse the directory hierarchy. If a
 *  file is chosen, it just prints the file's name.
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class FileChooser extends JFrame {

    public static void main(String args[]) {
	FileChooser fc = new FileChooser();
	JFileChooser chooser = new JFileChooser();
	int result = chooser.showOpenDialog(fc);

	if (result == JFileChooser.APPROVE_OPTION) {
	    File file = chooser.getSelectedFile();
	    // Insert code here to read data from file
	    String fileName = file.getName();
	    System.out.println("You selected " + fileName);
	} else
	    System.out.println("You cancelled the file dialog");
        System.exit(0);
    } // main()
}
