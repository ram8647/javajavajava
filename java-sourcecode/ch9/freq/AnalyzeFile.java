/*
 * File: AnalyzeFile.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 9-7.
 * Problem: Using the AnalyzeFreq class, write a program
 *  that will count and report letter frequencies from a 
 *  text file.
 */

import java.io.*;
import java.util.Scanner;

public class AnalyzeFile {

    public static void main(String[] argv) {
        Scanner fileScan;                    // To read lines of text from the file
        String str;                          // To store the line of text
        AnalyzeFreq af = new AnalyzeFreq();
        try {                                  // Create a Scanner      
            File theFile = new File("freqtest.txt");
            fileScan = new Scanner(theFile);   
            fileScan = fileScan.useDelimiter("\r\n"); // For Windows
            while (fileScan.hasNext()) {              // Read and count
              str = fileScan.next();
              af.countLetters(str);
            } // while
            af.printArray();                    // Print frequencies
        } catch (Exception e) {
             e.printStackTrace();
        } // catch()
    } // main()
} // AnalyzeFile
