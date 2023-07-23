/*
 * File: SlidingGUI.java
 * Author: Java, Java, Java
 * Description: A graphical user interface for the Sliding Tile puzzle.
 *  The puzzle is represented by an array of labeled JButtons that can
 *  be moved by the user by clicking on the buttons.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlidingGUI extends JFrame implements ActionListener {
    private JButton tile[] = new JButton[7];
    private JButton reset = new JButton("Reset");
    private SlidingTilePuzzle sliding;
    private String puzzleState;
    private Label label;
    private String prompt = "Goal: [LLL RRR]. " +
      " Click on the tile you want to move." +
      " Illegal moves are ignored.";

    /**
     * SlidingGUI() constructor sets the title of the JFrame
     *   and builds the user interface.
     */
    public SlidingGUI(String title) {
        sliding = new SlidingTilePuzzle();
        buildGUI();
        setTitle(title);
        pack();
        setVisible(true);
    } // SlidingGUI()

    /**
     * buildGUI() creates all the elements of the GUI and
     *  lays them out on the JFrame.
     */
    private void buildGUI() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel buttons = new JPanel();
        puzzleState = sliding.reportGameState();
        for (int k = 0; k < tile.length; k++) {
            tile[k] = new JButton(""+puzzleState.charAt(k));
            tile[k].addActionListener(this);
            buttons.add(tile[k]);
        }
        reset.addActionListener(this);
        label = new Label(prompt);
        buttons.add(reset);
        contentPane.add("Center", buttons);
        contentPane.add("South", label);
    } // buildGUI()

    /**
     * labelButtons() labels the buttons on the puzzle
     * @param s is a String containing the button labels in sequence.
     */
    private void labelButtons(String s) {
        for (int k = 0; k < tile.length; k++)
            tile[k].setText(""+ s.charAt(k));
    } // labelButtons()

    /**
     * actionPerformed() handles all action events.
     */
    public void actionPerformed(ActionEvent e) {
        String result = "";
        if (e.getSource() == reset) { // Reset clicked?
            sliding = new SlidingTilePuzzle();
            label.setText(prompt);
        }
        for (int k = 0; k < tile.length; k++) // Tile clicked?
            if (e.getSource() == tile[k])
                result = ((GUIPlayableGame)sliding).submitUserMove(""+ k);
            if (result.indexOf("illegal") != -1)
                java.awt.Toolkit.getDefaultToolkit().beep();
            puzzleState = sliding.reportGameState();
            labelButtons(puzzleState);
            if (sliding.gameOver()) 
                label.setText("You did it! Very nice!");
      } // actionPerformed()

    /**
     * main() starts the puzzle
     */
    public static void main(String args[]) {
        new SlidingGUI("Sliding Tile Puzzle");
    } // main()
} // SlidingGUI
