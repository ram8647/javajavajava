import javax.swing.*;
import java.awt.*;
public class DrawingPanel extends JPanel {
    private GameGUI gui;

    public DrawingPanel(GameGUI gui) {
        this.gui = gui;
        setBackground(Color.yellow);
        setForeground(Color.blue);
        setVisible(true);
    }
    public void paintComponent(Graphics g) {
        Drawable game = gui.getGame();
	g.setColor(Color.yellow);
        if (game != null)
	    game.draw(g);
        else {
	    g.fillRect(0,0,this.getWidth(), this.getHeight());
	}
		       
        
   }
}
