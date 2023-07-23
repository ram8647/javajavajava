/*
 * File: StringPuns.java
 * Author: Java Java Java
 * Description: A program that prints silly string puns.
 */

public class StringPuns 
{
    public static void main(String args[]) 
    {   String s = new String("string");
        String s1 = s.concat(" puns.");
        System.out.println("Here are the top 5 " + s1);
        String s2 = "5. Hey baby, wanna ";
        String s3 = s + " along with me.";
        System.out.println(s2 + s3);
        System.out.println("4. I've got the world on a " + 
                                                 s + ".");
        String s4 = new String("two");
        String s5 = ". You have more class than a ";
        System.out.print(s4.length());
        System.out.println(s5 + s + " of pearls.");
        System.out.print("2. It is ");
        System.out.print(s.equals("string"));
        System.out.println(" that I am no " + s + " bean.");
        String s6 = " quintet.";
        System.out.println("1. These puns form a " + s + s6);        
    } // main()
} //  StringPuns class
