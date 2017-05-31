/*
 * File: Riddle.java
 * Author: Java Java Java
 * Description: Represents a riddle with a question and an answer.
 */
public class Riddle
{   private String question; //Instance variables
    private String answer;

    public Riddle(String q, String a) // Constructor
    {   question = q;
        answer = a;
    } // Riddle constructor

    public String getQuestion() // Instance method
    {   return question;
    } // getQuestion()

    public String getAnswer() // Instance method
    {   return answer;
    } // getAnswer()
} // Riddle class
