import java.io.*;
/**
 * Generic Game Player Keyboard Application Program. Will play any
   subclass of TwoPlayerGame that implements CLUIPlayable.
   If a reference to an implementation of ComputerPlayable is also
   passed into a constructor, computer moves will be made for one
   or both players.
 */

public class CLUIGamePlayer
{   TwoPlayerGame game;
    KeyboardReader kb;
    CLUIPlayable clui; // For a second reference to the game object.
    ComputerPlayable computer1; // Optional references to objects
    ComputerPlayable computer2; // implementing ComputerPlayable.

    /** Constructor that assumes two persons will play game.
    @param g is object implementing TwoPlayerGame and CLUIPlayable.
    */
    public CLUIGamePlayer(TwoPlayerGame g)
    {   game = g;
        kb = new KeyboardReader();
        clui = (CLUIPlayable)game;
        computer1 = null;
        computer2 = null;
    } //CLUIGamePlayer() constructor1

    /** Constructor assuming a person and computer will play game.
    @param g is object implementing TwoPlayerGame and CLUIPlayable.
    @param cp is object implementing ComputerPlayable.
    */
    public CLUIGamePlayer(TwoPlayerGame g, ComputerPlayable cp)
    {   game = g;
        kb = new KeyboardReader();
        clui = (CLUIPlayable)game;
        computer1 = null;  //The person will play first
        computer2 = cp;
    } //CLUIGamePlayer() constructor2

    /** Constructor that assumes two computerss will play game.
    @param g is object implementing TwoPlayerGame and CLUIPlayable.
    @param cp1 is an object implementing ComputerPlayable.
    @param cp2 is an object implementing ComputerPlayable.
    */
    public CLUIGamePlayer(TwoPlayerGame g, ComputerPlayable cp1,
        ComputerPlayable cp2)
    {   game = g;
        kb = new KeyboardReader();
        clui = (CLUIPlayable)game;
        computer1 = cp1;
        computer2 = cp2;
    } //CLUIGamePlayer() constructor3

    /** Plays an entire game with the objects given the constructor.
    Plays games with two persons, person versus computer or two computers.
    */
    public void play()
    {   String inStr; //For keyboard input.
        kb.report(game.getRules());
        kb.report(clui.reportState());
        while(!game.gameOver())
        {   if ((game.getPlayer() == TwoPlayerGame.PLAYER_ONE) &&
                (computer1 != null)) // Player 1 is a computer
            {   kb.prompt("\nHit return for Player 1 computer move.");
                inStr = kb.getUserInput();
                kb.report(computer1.computerMove()); // move
                kb.report(clui.reportState());
	          } else if ((game.getPlayer() == TwoPlayerGame.PLAYER_TWO) &&
                (computer2 != null)) // Player 2 is a computer
            {   kb.prompt("\nHit return for Player 2 computer move.");
                inStr = kb.getUserInput();
                kb.report(computer2.computerMove()); //  move
                kb.report(clui.reportState());
	          } else //The player is a person
            {   kb.prompt(clui.prompt());
                inStr = kb.getUserInput();
                kb.report(clui.move(inStr)); //move
                kb.report(clui.reportState());
            } //else
        } // while
        kb.report("\nThe Game is now over!");
        kb.report("\n" + game.getWinner() + " has won!");
    }  //play()

} //CLUIGamePlayer class
