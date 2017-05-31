/* 
 * File: GreeterGUI2.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 4.3. 
 * Exercise: Modify the RiddleFileReader class so that
 *  it will input numbers from a file named "numbers.txt"
 *  and calculate the sum of the squares of the numbers.
 */ 

import java.io.*;
import java.util.Scanner;

public class NumberFileReader
{   private Scanner fileScan; // For file input
   
    public NumberFileReader(String fName)
    {   try
        {   File theFile = new File(fName);
            fileScan = new Scanner(theFile);
        } catch (IOException e)
        {    e.printStackTrace();
        } //catch()
    } //NumberFileReader() 

    public void readNumbers()
    {   int num = 0;      // To store integers read
        int sum = 0;      // To store sum of squares
        while (fileScan.hasNextInt()) 
        {   num = fileScan.nextInt();
            sum = sum + num * num;
        } // while
        System.out.println("The sum of squares = " + sum);
    } // readNumbers()

    public static void main(String[] args)
    {   NumberFileReader nfr = new NumberFileReader("numbers.txt");
        nfr.readNumbers();
    } //main()
} // NumberFileReader 
