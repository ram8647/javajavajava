/*
 * File: KeyboardReader.java
 * Author: Java Java Java
 * Description: This class defines an object that can be used
 *  to perform keyboard and console input and output.
 */
import java.io.*;

public class KeyboardReader 
{   private BufferedReader reader;

    public KeyboardReader() {
        reader = new BufferedReader
           (new InputStreamReader(System.in));
    }
    public String getKeyboardInput() 
    {   return readKeyboard();
    }
    public int getKeyboardInteger() 
    {   return Integer.parseInt(readKeyboard());
    }
    public double getKeyboardDouble() 
    {   return Double.parseDouble(readKeyboard());
    }
    public void prompt(String s) 
    {   System.out.print(s);
    }
    public void display(String s) 
    {   System.out.print(s);
    }
    private String readKeyboard() 
    {   String line = "";
        try 
        {  line = reader.readLine();
        } catch (IOException e) 
        {  e.printStackTrace();
        }
        return line;
    }
}
