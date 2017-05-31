/*
 * File: OneRowNimApp.java
 * Author: Java Java Java
 * Description: This application uses a KeyboardReader 
 *  to play One Row Nim via a command-line interface.
 */
public class OneRowNimApp 
{   private KeyboardReader reader;
    private OneRowNim game;

    public OneRowNimApp() 
    {   reader = new KeyboardReader();
        game = new OneRowNim(21);
    } //OneRowNim()
    
    public void run() 
    {   int sticksLeft = game.getSticks();
        reader.display("Let's play One Row Nim. You go first.\n");
        reader.display("There are " + sticksLeft + 
                                       " sticks left.\n");
        reader.display("You can pick up 1, 2, or 3 at a time\n.");
        while (game.gameOver() == false)       
        {   if (game.getPlayer() == 1)  userMove();
            else computerMove();
            sticksLeft = game.getSticks();
            reader.display("There are " + sticksLeft + " sticks left.\n");
        } // while
        if (game.getWinner() == 1) 
            reader.display("Game over. You win. Nice game.\n");
         else  
            reader.display("Game over. I win. Nice game.\n");
    } //run()
    
    private void userMove() 
    {   reader.prompt("Do you take 1, 2, or 3 sticks?: ");
        int userTakes = reader.getKeyboardInteger();
        if (game.takeSticks(userTakes)) 
        {   reader.display("You take " + userTakes + ".\n");
        } else 
        {   reader.display("You can't take " + userTakes + ". Try again\n");
        } // else
    } //userMove()
    
    private void computerMove() 
    {   game.takeSticks(1);  // Temporary strategy.
        reader.display("I take 1 stick. ");
    } //computerMove()
    
    public static void main(String args[]) 
    {   OneRowNimApp app = new OneRowNimApp();
        app.run();
    } //main()
} // OneRowNimApp
