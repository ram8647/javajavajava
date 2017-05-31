import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrivialApplication extends JFrame {

	private SimpleGUI gui;

	public static void main(String args[]) {
	    TrivialApplication f = new TrivialApplication();
	    f.init();
       f.pack();
//		f.setSize(200,200);
	    f.show();
	}
	
	public void init() {
	    gui = new SimpleGUI(this);
	}
	
}
