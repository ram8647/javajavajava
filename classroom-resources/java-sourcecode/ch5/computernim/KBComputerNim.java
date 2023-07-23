public class KBComputerNim
{
     public static void main(String argv[])
     {   KeyboardReader kb = new KeyboardReader();
         OneRowNim game = new OneRowNim(OneRowNim.MAX_STICKS);
         NimPlayer computer = new NimPlayer(game);
         System.out.println("Let's play One Row Nim");
         while(game.gameOver() == false)  {   
             if (game.getPlayer() == game.PLAYER_ONE) {
                 kb.prompt("Sticks left = " + game.getSticks() + " Your move. ");  // Prompt the user
                 kb.prompt("You can pick up between 1 and " + 
                     Math.min(game.MAX_PICKUP,game.getSticks()) + " :");
                 int sticks = kb.getKeyboardInteger(); // Get move
                 game.takeSticks(sticks);   // Do move
             } else {
                 kb.prompt("Sticks left = " + game.getSticks() + " My move. "); 
                 int sticks = computer.move();
                 game.takeSticks(sticks);
                 System.out.println("I take " + sticks);
	     }
         } // while
         kb.display("Sticks left = " + game.getSticks());  // The game is now over
         if (game.getWinner() == game.PLAYER_ONE)
	     System.out.println(" You win. Nice game!");
	 else
	     System.out.println(" I win. Nice game!");
     } // main()
} // KBComputerNim
