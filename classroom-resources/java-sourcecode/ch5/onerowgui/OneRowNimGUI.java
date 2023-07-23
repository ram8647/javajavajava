import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OneRowNimGUI extends JFrame implements ActionListener
{   private JTextArea display;
     private JTextField inField;
     private JButton goButton;
     private OneRowNim game;

     public OneRowNimGUI(String title)
     {   game = new OneRowNim(21);
         buildGUI();
         setTitle(title);
         pack();
         setVisible(true);
     } // OneRowNimGUI()
     private void buildGUI()
     {   Container contentPane = getContentPane();
         contentPane.setLayout(new BorderLayout());
         display = new JTextArea(20,30);
         display.setText("Let's play Take Away. There are " + game.getSticks() +
           " sticks.\n" + "Pick up 1,2, or 3 at a time.\n" + "You go first.\n");
         inField = new JTextField(10);
         goButton = new JButton("Take Sticks");
         goButton.addActionListener(this);
         JPanel inputPanel = new JPanel();
         inputPanel.add(new JLabel("How many sticks do you take: "));
         inputPanel.add(inField);
         inputPanel.add(goButton);
         contentPane.add("Center", display);
         contentPane.add("South", inputPanel);
     } // buildGUI
     private void userMove()
     {   int userTakes = Integer.parseInt(inField.getText());
         if (game.takeSticks(userTakes))
             display.append("You take " + userTakes + ".\n");
         else display.append("You can't take " + userTakes + ". Try again\n");
     }//UserMove()
     private void computerMove()
     {   if (game.gameOver()) return;
         if (game.getPlayer() == 2)
         {   game.takeSticks(1); // Temporary strategy
             display.append("I take 1 stick. ");
         } //if
     } //computerMove()
     private void endGame()
     {   goButton.setEnabled(false);  // Disable button and textfield
         inField.setEnabled(false);
         if (game.getWinner() == 1)
             display.append("Game over. You win. Nice game.\n");
         else  display.append("Game over. I win. Nice game.\n");
     } // endGame()
     public void actionPerformed(ActionEvent e)
     {   if (e.getSource() == goButton)
         {   userMove();
             computerMove();
             int sticksLeft = game.getSticks();
             display.append("There are " + sticksLeft + " sticks left.\n");
             if (game.gameOver()) endGame();
         } //if
     } //actionPerformed()
} // OneRowNimGUI