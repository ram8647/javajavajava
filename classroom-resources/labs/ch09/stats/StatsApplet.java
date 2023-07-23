/**
  Partial implementation of StatsApplet.java
***/

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class StatsApplet extends Applet implements ActionListener
{
    private Label prompt = new Label("Next Grade");
    private TextField inField;
    private TextArea display;
    private Button reset, displayStats;
    //CREATE A STATS OBJECT
    
    public void init() {      //INSTANTIATE AND ADD ACTION LISTENERS
      
      inField = new TextField(4);
      display = new TextArea("", 5,20);
      reset = new Button("RESET");
      displayStats = new Button("STATS");
      
      
      add(prompt);
      add(inField);
      inField.addActionListener( this ); 
      add(displayStats);
      displayStats.addActionListener( this );               
      add(reset);
      reset.addActionListener( this );
      add(display);
      
      setSize(500,200);  
    }
   
    public void actionPerformed( ActionEvent e ) {
      // ADD THE GRADE TO stats
      // DISPLAY THE RESULTS
      // CREATE A NEW stats
      
      if ( e.getSource() == inField ) 
       {         
        int number = Integer.parseInt(inField.getText());
       }
      
    }// actionPerformed
}//StatsApplet
