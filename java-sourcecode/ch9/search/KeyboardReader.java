import java.io.*;

public class KeyboardReader
{    private BufferedReader reader;

     public KeyboardReader()
     {   reader = new BufferedReader(
            new InputStreamReader(System.in));
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

    public String getUserInput() {
        return getKeyboardInput();
    }

    public void prompt(String s)    
     {   System.out.print(s);
     }

    public void report(String s)    
     {   System.out.print(s);
     }

     public void display(String s)
     {   System.out.print(s);
     }

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
