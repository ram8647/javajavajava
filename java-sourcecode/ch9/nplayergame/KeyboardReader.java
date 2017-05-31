/*
 * File: KeyboardReader.java
 * Author: Java, Java, Java
 * Description: This version of KeyboardReader implements the UserInterface
 *  methods report(), getUserInput(), and prompt().
 */
import java.io.*;

public class KeyboardReader implements UserInterface
{    private BufferedReader reader;

    /**
     * KeyboardReader() constructor creates a BufferedReader that
     *  is used for command-line and console I/O.
     */
     public KeyboardReader()
     {   reader = new BufferedReader(new InputStreamReader(System.in));
     }

    /**
     * getKeyboardInput() returns input read from the keyboard.
     */
     public String getKeyboardInput()
     {   return readKeyboard();
     }

    /**
     * getKeyboardInput() returns an integer read from the keyboard.
     */
     public int getKeyboardInteger()
     {   return Integer.parseInt(readKeyboard());
     }

    /**
     * getKeyboardInput() returns a double value read from the keyboard.
     */
     public double getKeyboardDouble()
     {   return Double.parseDouble(readKeyboard());
     }

    /**
     * getUserInput() is a method of the UserInterface class. It
     *  returns input read from the keyboard.
     */
    public String getUserInput() {
        return getKeyboardInput();
    }

    /**
     * prompt() is a method of the UserInterface class. It
     *  prints its parameter.
     * @param s is the String prompt
     */
    public void prompt(String s)    
     {   System.out.print(s);
     }

    /**
     * prompt() is a method of the UserInterface class. It
     *  prints its parameter.
     * @param s is a String representing the state of the game.
     */
    public void report(String s)    
     {   System.out.print(s);
     }

    /**
     * display() prints its parameter.
     */
     public void display(String s)
     {   System.out.print(s);
     }

    /**
     * readKeyboard() reads a line of input from the keyboard
     *   where reader is a BufferedReader.
     * @return a String storing a line read from the keyboard.
     */
     private String readKeyboard()
     {   String line = "";
         try
         {   line = reader.readLine();
         } catch (IOException e)
         {   e.printStackTrace();
         }
         return line;
     }

}
