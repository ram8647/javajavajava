/*
 * File: ReferenceCall.java
 * Author: Java, Java, Java
 * Description: This application illustrates what happens when
 *  a parameter of a reference type (OneRowNim) is modified within
 *  a method. For reference types (as opposed to primitive types)
 *  any changes to the parameter take effect in the object that the
 *  parameter refers to, and so will persist after the method is done.

 *  In this case the number of sticks stored in OneRowNim's nSticks
 *  variable will be changed as a result of calling myMethod(game) in main(). 
 *  The output produced when this program is run will be:
        main: Number of sticks: 10
        myMethod: Number of sticks: 10
        myMethod: Number of sticks: 7
        main: Number of sticks: 7

 *  NOTE: That when you compile and run this program, you must have a
 *   copy of the OneRowNim class in the same directory.
 */

public class ReferenceCall
{
    public static void myMethod(OneRowNim g)
    {   System.out.print("myMethod: Number of sticks: ");
        System.out.println(g.getSticks());
        g.takeSticks(3);
        System.out.print("myMethod: Number of sticks: ");
        System.out.println(g.getSticks());
    } // myMethod()

    public static void main(String argv[])
    {   OneRowNim game = new OneRowNim(10);
         System.out.print("main: Number of sticks: ");
         System.out.println(game.getSticks());
         myMethod(game);
         System.out.print("main: Number of sticks: ");
         System.out.println(game.getSticks());
    }// main()
} // ReferenceCall
