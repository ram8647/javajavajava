import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class YoyoApplet extends JApplet implements ActionListener 
{  private Yoyo theYoyo = new Yoyo();
   private JButton go = new JButton("Throw");
   private JTextField pause = new JTextField("100", 10);
   private int x=20, y=20;

   public void init() {
       JPanel control = new JPanel();
       control.add(new JLabel("Pause: "));
       control.add(pause);
       control.add(go);
       getContentPane().add(control, "South");
       go.addActionListener(this);
   }
    public  void paint(Graphics g) {
        g.drawString("Watch the yoyo", x,y);
        y += 5;
        theYoyo.throwYoyo(g, 1, Integer.parseInt(pause.getText()));
    } // paint()
    public void actionPerformed(ActionEvent e) {
	if (e.getSource()==go)
          repaint();        
    }
} // YoyoApplet
