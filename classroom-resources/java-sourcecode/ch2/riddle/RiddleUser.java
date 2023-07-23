/*
 * File: RiddleUser.java
 * Author: Java Java Java
 * Description: A main program that creates two Riddle objects
 *   and uses them to display riddles.
 */
public class RiddleUser
{
    public static void main(String argv[])
    { Riddle riddle1 = new Riddle(
        "What is black and white and red all over?",
        "An embarrassed zebra.");
      Riddle riddle2 = new Riddle(
        "What is black and white and read all over?",
        "A newspaper.");
      System.out.println("Here are two riddles:");
      System.out.println(riddle1.getQuestion());
      System.out.println(riddle2.getQuestion());
      System.out.println("The answer to the first riddle is:");
      System.out.println(riddle1.getAnswer());
      System.out.println("The answer to the second is:");
      System.out.println(riddle2.getAnswer());
    } // main()
} // RiddleUser
