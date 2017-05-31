//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class MyApplication extends JFrame {

	private SimpleGUI gui;

	public static void main(String args[]) {
	    MyApplication f = new MyApplication();
	    f.start();
 	}
	
	public void start() {
	    gui = new SimpleGUI("My Application");
	}
	
}
