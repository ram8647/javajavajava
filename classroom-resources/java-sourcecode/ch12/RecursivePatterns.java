import javax.swing.*;
import java.awt.event.*;

public class RecursivePatterns extends JFrame implements ItemListener  {
  private String choices[] = {"Sierpinski Gasket", "Nested Boxes"};
  private JComboBox<String> patterns = new JComboBox<>(choices); // Pattern choices
  private JComboBox<String> levels = new JComboBox<>();          // Level choices
  private Canvas canvas = new Canvas();                // Drawing panel
  private JPanel controls = new JPanel();

  public RecursivePatterns() {
    for (int k=0; k < 10; k++)            // Add 10 levels
      levels.addItem(k + "" );
    patterns.setSelectedItem(choices[0]); // Initialize menus
    levels.setSelectedItem("4");
    canvas.setBorder(BorderFactory.createTitledBorder("Drawing Canvas"));
    controls.add(levels);         // Control panel for menus
    controls.add(patterns);
    getContentPane().add(controls,"North"); // Add controls
    getContentPane().add(canvas,"Center");  // Add drawing panel
    levels.addItemListener(this);   // Register menus with listener
    patterns.addItemListener(this);
    setSize(canvas.WIDTH,canvas.HEIGHT+controls.getSize().width);
  } // init()

  public void itemStateChanged(ItemEvent e) {
    canvas.setPattern(patterns.getSelectedIndex(),
                                     levels.getSelectedIndex());
    repaint();
                               // Repaint the JFrame
  } // itemStateChanged()
  
  public static void main(String args[]) {
      JFrame f = new RecursivePatterns();
      f.setVisible(true);
   }
} // RecursivePatterns
