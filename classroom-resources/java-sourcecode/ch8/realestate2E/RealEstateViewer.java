/*
 * File: RealEstateViewer.java
 * Author: Java, Java, Java
 * Description:  This Java application illustrates how
 *  files can be downloaded from the Internet via a socket
 *  connection. This application allows the user to select
 *  a home from a real estate broker. It then downloads 
 *  information about the home, including a picture, from 
 *  the Internet.
 */

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*;
import javax.swing.*;

public class RealEstateViewer extends JFrame implements ItemListener {
    public static final int WIDTH=400,HEIGHT=200;
    private final String dataFileURL = "http://troy.trincoll.edu/~ram/AJJJ/homes/homes.txt";
    private final String baseURL = "http://troy.trincoll.edu/~ram/AJJJ/homes/";
    private JTextArea display = new JTextArea(20,20);
    private JComboBox homeChoice = new JComboBox();
    private ImagePanel imagePanel = new ImagePanel(this);
    public Image currentImage = null;

    /**
     * RealEstateViewer() constructor creates the user interface.
     *  An JComboBox is used to list the choices.
     */
    public RealEstateViewer () {
        super("Home Viewer Application");     // Set the window title
        homeChoice.addItemListener( this);
        this.getContentPane().add("North",homeChoice);
        this.getContentPane().add("East",display);
        this.getContentPane().add("Center",imagePanel);
        display.setLineWrap(true);
        initHomeChoices();                    // Set up the choice box
        showCurrentSelection();               // Display the current home
    }

    /**
     * initHomeChoices() initializes the JComboBox. The menu items
     *  are themselves downloaded from a file on the Internet. So
     *  it reads the file and inserts each line as a menu item.
     */
    private void initHomeChoices() {
        try {
            URL url = new URL(dataFileURL);
            BufferedReader data = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = data.readLine();
            while (line != null) {
                homeChoice.addItem(line);
                line = data.readLine();
            }
            data.close();
        } catch (MalformedURLException e) {
            System.out.println( "ERROR: " + e.getMessage()) ;
        } catch (IOException e) {
            System.out.println( "ERROR: " + e.getMessage()) ;
        }
    } // initHomeChoices()

    /**
     * readTextIntoDisplay() reads a text file from the Internet
     *  and displays it in a JTextArea.
     *  @param url -- the URL of text file
     */
    private void readTextIntoDisplay(URL url) throws IOException {
        BufferedReader data 
            = new BufferedReader(new InputStreamReader(url.openStream()));

        display.setText("");                // Reset the text area
        String line = data.readLine();
        while (line != null)  {             // Read each line
            display.append(line + "\n");    // And add it to the display
            line = data.readLine();
        }
        data.close();
    } // readTextIntoDisplay()

    /**
     * showCurrentSelection() takes the user's choice from the JComboBox
     *  and downloads the appropriate text and GIF from the Internet.
     */
    private void showCurrentSelection() { // throws IOException {
        URL url = null;
        String choice = homeChoice.getSelectedItem().toString();      // Get user's choice
        try {
            url = new URL(baseURL + choice + ".txt") ;                // Create url
            readTextIntoDisplay(url);                                 // Download and display text file
            url = new URL(baseURL + choice + ".gif");                 // Create url
            currentImage = Toolkit.getDefaultToolkit().getImage(url); // Download image
            Toolkit.getDefaultToolkit().beep();                       // Alert the user
            repaint();
        } catch (MalformedURLException e) {
            System.out.println( "ERROR: " + e.getMessage()) ;
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage()) ;
        }
    } // showCurrentSelection()

    /**
     * itemStateChanged() is the ItemListener interface. It is called 
     *  automatically whenever the user makes a menu selection. 
     */
    public void itemStateChanged(ItemEvent evt) { 
        showCurrentSelection();
    }

    /**
     * main() creates a RealEstateViewer. Note the use of an 
     *   anonymous WindowAdapter to handle window close events.
     */
    public static void main(String args[]) {
        RealEstateViewer viewer = new RealEstateViewer();
        viewer.setSize(viewer.WIDTH,viewer.HEIGHT);
        viewer.setVisible(true);
        viewer.addWindowListener(new WindowAdapter() {      // Quit the application
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    } // main()
} // RealEstateViewer
