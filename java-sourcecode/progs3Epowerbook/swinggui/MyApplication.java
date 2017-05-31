//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class MyApplication extends JFrame {

	private SimpleGUI gui;

	public static void main(String args[]) {
	    MyApplication f = new MyApplication();
	    f.init();
        f.pack();
//		f.setSize(200,200);
		f.setTitle("My Application");
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.show();
	}
	
	public void init() {
	    gui = new SimpleGUI(this);
	}
	
}
