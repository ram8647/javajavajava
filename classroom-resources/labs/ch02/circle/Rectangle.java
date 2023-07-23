/*
 * File: Rectangle.java
 * Author: Java, Java, Java
 * Description: This program represents a geometric rectangle.
 *  This class is not runnable, because it does not have a main() method.
 */

public class Rectangle 
{
    private double length;     // Instance variables
    private double width;

    public Rectangle(double l, double w)  // Constructor method
    {
        length = l;
        width = w;
    } // Rectangle() constructor

    public double calculateArea()         // Access method
    {
        return length * width;
    } // calculateArea()

} // Rectangle
