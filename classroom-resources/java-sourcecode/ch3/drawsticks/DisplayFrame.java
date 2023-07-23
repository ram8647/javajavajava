import java.awt.Canvas;
import javax.swing.JFrame;

public class DisplayFrame {
    // every java program needs a main to run!
    public static void main(String[] args){
	if (args.length < 1) {
	    System.out.println("Usage: java DisplayFrame <FrameClassName>" +
			       " [ width height]");
	    return;
	}
	int width = 400;
	int height = 400;
	try {
	    if (args.length == 3) {
		width = Integer.parseInt(args[1]);
		height = Integer.parseInt(args[2]);
	    }
	    Class c = Class.forName(args[0]);
	    JFrame f = null;
	    if (c.getSuperclass() == Canvas.class) {
		Canvas can = (Canvas) c.newInstance();
		f = new JFrame(args[0]);
		f.add(can);
	    } else if (c.getSuperclass() == JFrame.class) {
		f = (JFrame) c.newInstance();
	    }
	    if (f != null) {
		f.setSize(width,height);
		f.setVisible(true);
	    }
	} catch(InstantiationException e) {
	    e.printStackTrace();
	} catch(ClassNotFoundException cnfe) {
	    cnfe.printStackTrace();
	} catch(IllegalAccessException iae) {
	    iae.printStackTrace();
	}
    }

}
