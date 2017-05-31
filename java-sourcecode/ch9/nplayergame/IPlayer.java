/*
 * File: IPlayer.java
 * Author: Java, Java, Java
 * Description: This abstract interface defines the makeAMove() method,
 *  which determines how a move is made in a particular game.
 */
public interface IPlayer {

    /**
     * makeAMove() defines how a move is made. It is meant
     *  to be implemented by any object that plays the game.
     * @param prompt is a String that prompts the player for a move.
     * @return a String that describes the player's move
     */
    public String makeAMove(String prompt);
}
