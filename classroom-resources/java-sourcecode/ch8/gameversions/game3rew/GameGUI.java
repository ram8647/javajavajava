import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener
{   private JTextArea display;
    private JTextField inField;
    private TwoPlayerGame game;    // Generic game;
    private JMenuBar mBar = new JMenuBar();
    private JMenu playMenu = new JMenu("Play");
    private JMenuItem nimItem, multItem;

    public GameGUI(String title)
    {   buildGUI();
        buildMenuBar();
        setTitle(title);
        pack();
        setVisible(true);
    } // GameGUI()

//    public void callBack(TwoPlayerGame game)
//   {   this.game = game;
//       display.setText(game.getRules());
//       display.append(game.report());
//  }

    public void startGame()
    {   display.setText(game.getRules());
        display.append(game.report());
        display.append(game.prompt());
    }

    private void buildMenuBar()
    {   mBar.add(playMenu);
        nimItem = new JMenuItem("OneRowNim");
        nimItem.addActionListener(this);
        multItem = new JMenuItem("MultiplicationGame");
        multItem.addActionListener(this);
        playMenu.add(nimItem);
        playMenu.add(multItem);
        this.setJMenuBar(mBar);
    }

    private void buildGUI()
    {   Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        display = new JTextArea(20,30);
        JScrollPane scroll = new JScrollPane(display);
        inField = new JTextField(10);
        inField.addActionListener(this);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input: "));
        inputPanel.add(inField);
	     //  contentPane.add("Center", display);
        contentPane.add("Center", scroll);
        contentPane.add("South", inputPanel);
    } // buildGUI

    public void actionPerformed(ActionEvent e)
    {   if (e.getSource() == nimItem)
        {   game = new OneRowNim();
            startGame();
//          ((Playable) game).play(this);
            inField.setEnabled(true);
        } //if
        if (e.getSource() == multItem)
        {   game = new MultiplicationGame();
            startGame();
//          ((Playable) game).play(this);
            inField.setEnabled(true);
        } //if
        if (e.getSource() == inField)
        {   String s = game.move(inField.getText());
            inField.setText("");
            display.append(s);
            if (game.gameOver())
                inField.setEnabled(false);
        } //if
    } //actionPerformed()

    public static void main(String args[])
    {   GameGUI gui = new GameGUI("GamePlayerGUI");
    } //main()

} // GameGUI class

