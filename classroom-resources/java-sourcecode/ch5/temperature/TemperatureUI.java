public class TemperatureUI
{   private KeyboardReader reader;       // Handles command line I/O
 
    public TemperatureUI() 
    {   reader = new KeyboardReader();   // Create a reader object
    }

    /**
     * Implements an input-process-output algorithm to convert temperatures.
     */
    public void run() 
    {   reader.prompt("This program will convert Fahrenheit to Celsius and vice versa.\n");
        reader.prompt("Input a temperature in Fahrenheit > ");  
        double tempIn = reader.getKeyboardDouble();
        double tempResult = Temperature.fahrToCels(tempIn);
        reader.display(tempIn + " F = " + tempResult + " C\n"); 

        reader.prompt("Input a temperature in Celsius > ");  
        tempIn = reader.getKeyboardDouble();
        tempResult = Temperature.celsToFahr(tempIn);
        reader.display(tempIn + " C = " + tempResult + " F\n "); 
   }
   public static void main(String args[])
    {   TemperatureUI ui = new TemperatureUI();   // Create an interface object
        ui.run();                                 //   and run it.
   }
}
