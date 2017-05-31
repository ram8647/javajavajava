import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//public class GameGUI extends JFrame implements ActionListener, UserInterface
public class GameGUI extends JFrame implements ActionListener
{   private JTextArea display;
    private JTextField inField;
    private TwoPlayerGame game;    // Generic game;
    private JMenuBar mBar = new JMenuBar();
    private JMenu playMenu = new JMenu("Play");
    private JMenuItem nimItem, multItem, tictactoeItem, rockpaperscissorsItem;    
    private DrawingPanel drawingPanel = new DrawingPanel(this);

    public GameGUI(String title)
    {   buildGUI();
        buildMenuBar();
        setTitle(title);
        pack();
        setVisible(true);
        setSize(600,300);
     } // GameGUI()

    public Drawable getGame() { return (Drawable)game; }

    private void buildMenuBar() {
        mBar.add(playMenu);
        nimItem = new JMenuItem("OneRowNim");
        nimItem.addActionListener(this);
        multItem = new JMenuItem("MultiplicationGame");
        multItem.addActionListener(this);
        tictactoeItem = new JMenuItem("TicTacToe");
        tictactoeItem.addActionListener(this);
        rockpaperscissorsItem = new JMenuItem("RockPaperScissors");
        rockpaperscissorsItem.addActionListener(this);
  	playMenu.add(nimItem);
        playMenu.add(multItem);
        playMenu.add(tictactoeItem);
        playMenu.add(rockpaperscissorsItem);
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
         contentPane.add("East", scroll);
         contentPane.add("South", inputPanel);
         contentPane.add("Center", drawingPanel);
     } // buildGUI

    public void init() {
	display.setText(game.getRules());
        display.append(((GUIPlayableGame)game).reportGameState());
        display.append(((GUIPlayableGame) game).getGamePrompt());
    }
   
     public void actionPerformed(ActionEvent e) {   
	 if (e.getSource() == nimItem) {
             game = new OneRowNim();
             inField.setEnabled(true);
             init();        
             inField.requestFocus();
	     repaint();
	 } 
	 if (e.getSource() == multItem) {
	     //             game = new MultiplicationGame();
             inField.setEnabled(true);
             init();        
             inField.requestFocus();
	 } 
	 if (e.getSource() == tictactoeItem) {
	     //             game = new TicTacToe();
             inField.setEnabled(true);
             init();        
             inField.requestFocus();
	 } 
         
	 if (e.getSource() == rockpaperscissorsItem) {
	     //             game = new RockPaperScissors();
             inField.setEnabled(true);
             init();        
             inField.requestFocus();
	 } 
         
	 if (e.getSource() == inField)
         {   String s = ((GUIPlayableGame)game).submitUserMove(inField.getText());
             inField.setText("");
             display.append(s);
             inField.requestFocus();
             if (game.gameOver()) 
		 inField.setEnabled(false);
             repaint();
         } //if
     } //actionPerformed()

    public static void main(String args[]) {
        GameGUI gui = new GameGUI("GamePlayerGUI");
    }
} // GameGUI
