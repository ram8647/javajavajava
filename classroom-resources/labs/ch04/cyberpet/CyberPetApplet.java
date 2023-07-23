/*
 * File: CyberPetApplet.java
 * Author: Java, Java, Java
 * Description: This apply provides a graphical user
 *  interface to the CyberPet class. The interface consists
 *  of two Buttons that can be clicked to tell the CyberPet
 *  to eat or drink, and a TextField which reports the 
 *  CyberPet's state. 
 *  
 *  The interface is initialized in the init() method and
 *  user actions are handled in the actionPerformed() method.
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CyberPetApplet extends Applet implements ActionListener
{
   // Declare instance variables
   private CyberPet pet1;                   // The CyberPet
   private Label nameLabel;                 // A Label
   private TextField stateField;            // A TextField
   private Button eatButton, sleepButton;   // Two Buttons

   /* 
    * The init() method instantiates the instance variables, including both the 
    * CyberPet (pet1) and the GUI elements that are displayed on the applet.
    */
    public void init() 
    { 
       pet1 = new CyberPet("Socrates");   // CyberPet

        // Create the GUI components

       nameLabel = new Label("Hi! My name is " + pet1.getName() + 
                              " and currently I am : ");  
       stateField = new TextField(12);
       eatButton = new Button("Eat!");     // Buttons
       eatButton.addActionListener(this);    // Assign the listeners.
       sleepButton = new Button("Sleep!");
       sleepButton.addActionListener(this);

        // Initialize the TextField

      stateField.setText(pet1.getState());
      stateField.setEditable(false);

        // Add the components to the applet.

      add(nameLabel); 
      add(stateField);
      add(eatButton);
      add(sleepButton);

      setSize(300,150);          // Set the applet's size to 300 x 150 pixels
    } // init

    /*
     * The actionPerformed() method is called whenever 
     * one of the buttons is pressed.
     */
    public void actionPerformed( ActionEvent e) 
    {
        if (e.getSource() == eatButton)
            pet1.eat();
        else if (e.getSource() == sleepButton)
            pet1.sleep();

        stateField.setText(pet1.getState());
    }//actionPerformed

} // CyberPetApplet
