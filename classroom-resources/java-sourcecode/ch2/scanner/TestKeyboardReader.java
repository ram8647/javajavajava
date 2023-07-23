/*
 * File: TestKeyboardReader.java
 * Author: Java Java Java
 * Description: A main program that creates a KeyboardReader object
 *   and uses it to read an integer from the keyboard. The KeyboardReader
 *   class is developed in Chapter 4.
 */
public class TestKeyboardReader 
{
    public static void main(String[] args) 
    {             
        KeyboardReader kb = new KeyboardReader();  // Create KeyboardReader object
        System.out.print("Input an integer:");     // Prompt
        int num = kb.getKeyboardInteger();         // Read an integer
        System.out.println(num + " squared = " + num*num);
    } // main()
} // TestKeyboardReader class
