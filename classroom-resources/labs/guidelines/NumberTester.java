/*****************************************************
file: NumberTester.java                               
@author cpsc115 staff                           
date:  September 27,1997                           
course: cpsc 115 -- fall 1997
description: This class stores a integer and determines
  whether it is odd or even.
********************************************************
*/

import java.awt.*;

/**
 * A class that stores an odd or even integer
 */

public class NumberTester {
  private boolean isEven;	     // true if number is even
  private int number = 0;	     // the number itself

 /**
  * Constructs a NumberTester object
  */

 NumberTester( ) {
   isEven = true;      // THE intial value, 0, is even
 } // NumberTEster()

 /**
  * Assigns its int parameter to number and
  *  records whether it is even or not in the
  *  isEven instance variable
  * @param -- an int n is input to this method
  */

 public void setNumber ( int n )	{  
   number = n;
   if ( number % 2 == 0 )
     isEven = true;
   else
     isEven = false;
 } // setNumber()

 /**
  * Gets the number 
  * @return -- this method returns the value of number
  */

 public int getNumber ( ) {
   return number;
 } // getNumber()
 
 /**
  * Returns the number and whether it is even or odd
  * @return -- the String returned reports whether 
  *  the object's number is odd or even
  */

 public String toString() { // converts this Number object to a String
   if ( isEven )
     return number + " is EVEN ";
   else 
     return number + " is ODD ";
 } // toString()
 			
} // NumberTester class       
