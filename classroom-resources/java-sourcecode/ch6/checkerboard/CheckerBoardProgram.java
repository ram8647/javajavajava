import java.awt.*;
import javax.swing.*;
public class CheckerBoardProgram {  
   public static void main(String[] args){
       CheckerBoard theBoard = new CheckerBoard();
       JFrame c = new JFrame();
       c.add(theBoard);
       c.setSize(340,360);
       c.setVisible(true);
    }
  } // CheckerBoardProgram
