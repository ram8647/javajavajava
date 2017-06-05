import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToggleFrame extends JFrame
                            implements ActionListener {
  private ToggleButton lightSwitch;  

  public ToggleFrame() {
    lightSwitch = new ToggleButton ("off","on");
    getContentPane().add(lightSwitch);
    lightSwitch.addActionListener(this);
  } // init()

  public void actionPerformed(ActionEvent e)  {
    setTitle("The light is " + lightSwitch.getText());
  } // actionPerformed()

   public static void main(String args[]) 
   {  
      JFrame f = new ToggleFrame();
      f.setSize(200,200);
      f.setVisible(true);
   }
} // ToggleFrame
