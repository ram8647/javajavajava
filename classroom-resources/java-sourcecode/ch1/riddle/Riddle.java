/* 
 * File: Riddle.java
 * Author: Java, Java, Java
 * Description: Defines a simple riddle.
 */
public class Riddle            // Class header
{                              // Begin class body
    private String question;   // Instance variables
    private String answer;

    public Riddle(String q, String a) // Constructor method
    {   question = q;
        answer = a;
    } // Riddle()

    String getQuestion()       // Instance method
    {
        return question;
    } // getQuestion()

    String getAnswer()         // Instance method
    {
        return answer;
    } // getAnswer()
} // Riddle class              // End of class body
