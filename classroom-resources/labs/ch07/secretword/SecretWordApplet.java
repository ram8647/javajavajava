/*
 * File: SecretWordApplet.java
 * Author: Java, Java, Java
 * Description: This applet interface is used to test
 *  the methods of the SecretWord class. It displays
 *  a secret word and lets the user type in letters.
 *  It reports wheter the user's letter is contained in
 *  the secret word.
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class SecretWordApplet extends Applet implements ActionListener {

    private Label prompt1, prompt2;        // The GUI elements
    private TextField inputField;
    private TextArea outputArea;
    private String inputString;
    private int numberOfGuesses = 0;
    SecretWord secret = new SecretWord();   // SecretWord object
	
    /**
     * init() sets up the applet's interface which consists of a TextField
     *  in which the user inputs a guess, and a TextArea which displays
     *  the results of each guess. An ActionListener is assigned to the
     *  TextField.
     */
    public void init() {
        prompt1 = new Label("Enter a letter you think is in the secret word.");
        inputField = new TextField(5);
        inputField.setEditable(true);
        inputField.addActionListener(this);
        outputArea = new TextArea(10,60);
	
        add(prompt1);
        add(inputField);
        add(outputArea);
        setSize(500,300);
        outputArea.append("The secret word: " + secret.getDisplayedWord() +"\n");
    } // init()
	
    /**
     * actionPerformed() handles action events in the TextField.
     */ 
    public void actionPerformed(ActionEvent e) {
        inputString = inputField.getText();
        inputField.setText("");
        boolean guess = secret.makeGuess(inputString.charAt(0));

                            // Process the user's guess
        if (guess == true) 
            outputArea.append ("That Guess Was Right " + secret.getDisplayedWord() + "\n");
        else 
            outputArea.append ("That Guess Was Wrong " + secret.getDisplayedWord() + "\n");


    } // actionPerformed()
} // SecretWordApplet

