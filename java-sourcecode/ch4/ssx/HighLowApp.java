/* 
 * File: HighLowApp.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 4.1. 
 * Exercise: Design and implement an application that
 *   plays a guessing game with the user via a command
 *   line interface. 
 */ 

public class HighLowApp 
{   private KeyboardReader reader;
    private int secretNumber;

    public HighLowApp() 
    {   reader = new KeyboardReader();
        secretNumber = 1 + (int)(Math.random() * 100);  // Create a random number.
    } // HighLowApp() constructor
    
    public void run() 
    {   int userGuess = -1;
        reader.display("Guess my secret number between 1 and 100.");
        while (userGuess != secretNumber)
        {   reader.prompt("Please input your guess here > ");
            userGuess = reader.getKeyboardInteger();
            if (userGuess > secretNumber)
            reader.display("Your guess was too high.");
            if (userGuess < secretNumber)
                reader.display("Your guess was too low.");
        } // while
        reader.display("Congratulations. Your guess was correct.");
    } // run()
     
    public static void main(String args[]) 
    {   HighLowApp app = new HighLowApp();
        app.run();
    } // main()
} // HighLowApp
