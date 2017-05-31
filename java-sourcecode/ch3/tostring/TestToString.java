/*
 * File: TestToString.java
 * Author: Java Java Java
 * Description: This main program illustrates the use of the
 *  default toString() method, which is inherited from the Object
 *  class. It is inherited by OneRowNim objects.
 */
public class TestToString
{
    public static void main(String argv[])
    {   OneRowNim g1 = new OneRowNim(11);
        OneRowNim g2 = new OneRowNim(13);
        g1.takeSticks(2);
        System.out.println(g1.toString());
        System.out.println(g2.toString());
    } //main
} //TestToString
