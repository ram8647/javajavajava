/*
 * File: RiddleFileReader.java
 * Author: Java Java Java
 * Description: This application plays One Row Nim via a GUI interface.
 */
import java.io.*;
import java.util.Scanner;

public class RiddleFileReader
{   private Scanner fileScan; // For file input
    private Scanner kbScan;   // For keyboard input

    public RiddleFileReader(String fName)
    {   kbScan = new Scanner(System.in);
        try
        {   File theFile = new File(fName);
            fileScan = new Scanner(theFile);
            fileScan = fileScan.useDelimiter("\r\n");
	    //            fileScan = fileScan.useDelimiter("\n"); // Uncomment this for Macintosh systems.
        } catch (IOException e)
        {    e.printStackTrace();
        } //catch()
    } //RiddleFileReader() constructor

    public Riddle readRiddle()
    {   String ques = null;
        String ans = null;
        Riddle theRiddle = null;
        if (fileScan.hasNext())
            ques = fileScan.next();
        if (fileScan.hasNext())
        {   ans =  fileScan.next();
            theRiddle = new Riddle(ques, ans);
        } // if
        return theRiddle;
    } // readRiddle()

    public void displayRiddle(Riddle aRiddle)
    {   System.out.println(aRiddle.getQuestion());
        System.out.print("Input any letter to see answer:");
        String str = kbScan .next();  //Ignore KB input
        System.out.println(aRiddle.getAnswer());
        System.out.println();
    } // displayRiddle()

    public static void main(String[] args)
    {   RiddleFileReader rfr = new RiddleFileReader("riddles.txt");
        Riddle riddle = rfr.readRiddle();
        while (riddle != null)
        {   rfr.displayRiddle(riddle);
            riddle = rfr.readRiddle();
        } // while
    } // main()
}  //RiddleFileReader class
