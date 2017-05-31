/*
 * File: CLUIPlayabelGame.java
 * Author: Java, Java, Java
 * Description: This abstract interface extends the IGame interface
 *  and defines the play() method. A CLUIPlayableGame is one that
 *  can be played via a command-line user interface. 
 */
public interface CLUIPlayableGame extends IGame {

    /**
     * play() implements the play loop for a game that
     *  interfaces to a UserInterface. It is meant to
     *  be implented by games that support a command-line
     *  interface. 
     */
    public abstract void play(UserInterface ui);
}



