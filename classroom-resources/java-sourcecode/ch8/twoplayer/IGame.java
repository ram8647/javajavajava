/*
 * File: IGame.java
 * Author: Java, Java, Java
 * Description: This abstract interface defines the getGamePrompt() 
 *  and reportGameState() methods, both of which return Strings that
 *  describe specific aspects of a game. These two methods define a
 *  standard form of communication between a game and a user interface.
 */
public interface IGame {
    public String getGamePrompt();
    public String reportGameState();
} //IGame

