/*
 * File: OneRowNimTester.java
 * Author: Java Java Java
 * Description: A main program that creates a OneRowNim object
 *   and uses it to play One Row Nim
 */
public class OneRowNimTester 
{   public static void main(String args[])
    {   OneRowNim game = new OneRowNim();
        game.report();
        game.takeThree();
        game.report();
        game.takeThree();
        game.report();
        game.takeOne();
        game.report();
    } // main()
}
