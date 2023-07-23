import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OneRowNimGUI extends JFrame implements ActionListener
{   private JTextArea display;
    private JTextField inField;
    private JButton goButton;
    private OneRowNim nim;

    public OneRowNimGUI(String title)
    {    buildGUI();
         setTitle(title);
         pack();
         setVisible(true);
     } // OneRowNimGUI()

    public void callBack(OneRowNim game) {
        nim = game;
        nim.setPlayer(TwoPlayerGame.PLAYER_TWO);
	display.setText(nim.getRules());
        display.append(nim.report());
    }
     private void buildGUI()
     {   Container contentPane = getContentPane();
         contentPane.setLayout(new BorderLayout());
         display = new JTextArea(20,30);
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
         if (nim.takeSticks(userTakes)) {
             display.append("You take " + userTakes + ".\n");
             nim.changePlayer();
         }
         else display.append("You can't take " + userTakes + ". Try again\n");
     }//UserMove()
     private void computerMove()
     {   if (nim.gameOver()) return;
         if (nim.getPlayer() == TwoPlayerGame.PLAYER_ONE)
         {   nim.takeSticks(1); // Temporary strategy
             display.append("I take 1 stick. ");
             nim.changePlayer();
         } //if
     } //computerMove()
     private void endGame()
     {   goButton.setEnabled(false);  // Disable button and textfield
         inField.setEnabled(false);
         if (nim.getWinner() == TwoPlayerGame.PLAYER_TWO)
             display.append("Game over. You win. Nice game.\n");
         else  display.append("Game over. I win. Nice game.\n");
     } // endGame()
     public void actionPerformed(ActionEvent e)
     {   if (e.getSource() == goButton)
         {   userMove();
             computerMove();
             int sticksLeft = nim.getSticks();
             display.append("There are " + sticksLeft + " sticks left.\n");
             if (nim.gameOver()) endGame();
         } //if
     } //actionPerformed()
} // OneRowNimGUI
