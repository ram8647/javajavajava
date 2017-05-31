/*
 * File: TestScanner.java
 * Author: Java Java Java
 * Description: A main program that creates a Scanner object
 *   and uses it to read an integer from the keyboard.
 */
import java.util.Scanner;

public class TestScanner 
{
    public static void main(String[] args) 
    {                                          
        Scanner sc = new Scanner(System.in);   // Create Scanner object
        System.out.print("Input an integer:"); // Prompt
        int num = sc.nextInt();                // Read an integer
        System.out.println(num + " squared = " + num*num);
    } //main()
} // TestScanner class
