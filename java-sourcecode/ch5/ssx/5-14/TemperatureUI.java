/*
 * File: TemperatureUI.java
 * Author: Java, Java, Java
 * Description:  The class provides a solution to Self-study exercise 5.14.
 *
 * Problem: Define a command-line user interface that uses the 
 *  KeyboardReader class to interact with a temperature conversion object.
 *
 * NOTE: To compile and run this program, it must have access
 *  to the KeyboardReader and Temperature classes.
 */

public class TemperatureUI
{   private KeyboardReader reader; // Handles command line I/O

    /**
     * TemperatureUI() default constructor
     */
    public TemperatureUI() 
    {   
        reader = new KeyboardReader(); // Create reader object
    }

 
    /**
     * run() implements an input-process-output algorithm to 
     *  convert temperatures. It uses a KeyboardReader object
     *  for user I/O and a Temperature object to perform the
     *  temperature conversion.
     */
    public void run() 
    {   reader.prompt("Converts Fahrenheit and Celsius.\n");
        reader.prompt("Input a temperature in Fahrenheit > ");  
        double tempIn = reader.getKeyboardDouble();
        double tempResult = Temperature.fahrToCels(tempIn);
        reader.display(tempIn + " F = " + tempResult + " C\n"); 
        reader.prompt("Input a temperature in Celsius > ");  
        tempIn = reader.getKeyboardDouble();
        tempResult = Temperature.celsToFahr(tempIn);
        reader.display(tempIn + " C = " + tempResult + " F\n "); 
    } // run()

    /**
     * main() simply creates the user interface and invokes its run() method.
     */
    public static void main(String args[])
    {   TemperatureUI ui = new TemperatureUI();  // Create and
        ui.run();                                //  run the user interface.
    } // main()
} // TemperatureUI
