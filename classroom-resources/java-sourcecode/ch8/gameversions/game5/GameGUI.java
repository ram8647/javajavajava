import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//public class GameGUI extends JFrame implements ActionListener, UserInterface
public class GameGUI extends JFrame implements ActionListener
{   private JTextArea display;
    private JTextField inField;
    //    private TwoPlayerGame game;    // Generic game;
    private Game game;    // Generic game;
    private JMenuBar mBar = new JMenuBar();
    private JMenu playMenu = new JMenu("Play");
    private JMenuItem nimItem, multItem, tictactoeItem;    

    public GameGUI(String title)
    {   buildGUI();
        buildMenuBar();
        setTitle(title);
        pack();
        setVisible(true);
     } // GameGUI()

    private void buildMenuBar() {
        mBar.add(playMenu);
        nimItem = new JMenuItem("OneRowNim");
        nimItem.addActionListener(this);
        multItem = new JMenuItem("MultiplicationGame");
        multItem.addActionListener(this);
        tictactoeItem = new JMenuItem("TicTacToe");
        tictactoeItem.addActionListener(this);
  	playMenu.add(nimItem);
        playMenu.add(multItem);
        playMenu.add(tictactoeItem);
        this.setJMenuBar(mBar);
    }

    private void buildGUI()
     {   Container contentPane = getContentPane();
         contentPane.setLayout(new BorderLayout());
         display = new JTextArea(20,30);
         display.setText("Choose a game.\nInformation about the game's state\n" +
			 " and prompts during the game will appear here.\n" +
			 " Type your input into the text field below.\n");
         JScrollPane scroll = new JScrollPane(display);
         inField = new JTextField(10);
         inField.addActionListener(this);
         JPanel inputPanel = new JPanel();
         inputPanel.add(new JLabel("Please type your input here: "));
         inputPanel.add(inField);
	 //         contentPane.add("Center", display);
         contentPane.add("Center", scroll);
         contentPane.add("South", inputPanel);
     } // buildGUI

    public void init() {
	display.setText(game.getRules());
        display.append(((Playable)game).reportState());
        display.append(((Playable) game).prompt());
    }
   
     public void actionPerformed(ActionEvent e) {   
	 if (e.getSource() == nimItem) {
             game = new OneRowNim();
	     //             ((Playable) game).play(this);
             inField.setEnabled(true);
             init();        
             inField.requestFocus();
	 } 
	 if (e.getSource() == multItem) {
             game = new MultiplicationGame();
	     //             ((Playable) game).play(this);
             inField.setEnabled(true);
             init();        
             inField.requestFocus();
	 } 
	 if (e.getSource() == tictactoeItem) {
             game = new TicTacToe();
	     //             ((Playable) game).play(this);
             inField.setEnabled(true);
             init();        
             inField.requestFocus();
	 } 
         
	 if (e.getSource() == inField)
         {   String s = ((IPlayer)game).move(inField.getText());
             inField.setText("");
             display.append(s);
             inField.requestFocus();
             if (game.gameOver()) 
		 inField.setEnabled(false);
         } //if
     } //actionPerformed()

    public static void main(String args[]) {
        GameGUI gui = new GameGUI("GamePlayerGUI");
    }
} // GameGUI
