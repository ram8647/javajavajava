import javax.swing.*;

public class SimpleGUI extends JFrame
{
     public SimpleGUI(String title)
     {   setSize(200,150);
         setLocation(100, 150);
         setTitle("My GUI");
         setVisible(true); //displays the JFrame
     } // SimpleGUI()

     public static void main(String args[])
     {   new SimpleGUI("My GUI");
     } // main()
} // SimpleGUI class