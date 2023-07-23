/*****************************************************
file: MonthApplet.java                               
@author cpsc115 staff                           
date:  February 2002                           
course: cpsc 115 -- Spring 2002
description: This applet provides an interface to the
  Days.java class.
********************************************************
*/

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class MonthApplet extends Applet implements ActionListener {

 /**
  * Two instance variables, a TextField and an int.
  */

  TextField inputField;         // TextField IS USED TO STORE THE USER'S INPUT
  int number;                   // THE NUMBER INPUT BY THE USER

 /**
  * Initializes the prompt Label and TextField and adds them to
  *  the applet.
  */

  public void init()  {  
    Label prompt = new Label("Input a month between 1 and 12 and press return:"); // CREATE A PROMPT

    inputField = new TextField(10);       // CREATE THE INPUT TEXTFIELD
    inputField.setText("0");
    add(prompt);                          // ADD prompt AND inputField TO THE APPLET
    add(inputField);
    inputField.addActionListener( this ); // MAKE THE APPLET THE listener FOR THE TEXTFIELD
    setSize( 350, 150 );                  // SET THE APPLET's SIZE
  }
  
 /**
  * Reports the applet's result
  * @param g is the applet's Graphics object 
  */

  public void paint (Graphics g) {
      
      g.drawString( "The "+ number + " month has " + 0 + " Days", 10 ,100);
    
  } // paint()

 /**
  * Handles a <RETURN> typed into the TextField.
  * @param evt is a copy of the current ActionEvent
  * uses Integer.parseInt() to convert a string to an int
  */

  public void actionPerformed(ActionEvent evt)  { 
    if ( evt.getSource() == inputField ) {         // get the user's input
                                              // and convert it to an integer
      number = Integer.parseInt(inputField.getText()); 
      repaint();
    }
  } // actionPerformed()
  
} //  MonthApplet


