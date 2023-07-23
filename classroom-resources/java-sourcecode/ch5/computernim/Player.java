public class Player
{
     public static void main(String argv[])
     {   KeyboardReader kb = new KeyboardReader();
         OneRowNim game = new OneRowNim(OneRowNim.MAX_STICKS);
         while(game.gameOver() == false)
         {   kb.prompt(game.report());               // Prompt the user
             kb.prompt("You can pick up between 1 and " + OneRowNim.MAX_PICKUP + " :");
             int sticks = kb.getKeyboardInteger(); // Get move
             game.takeSticks(sticks);   // Do move
             System.out.println();
         } // while
         kb.display(game.report());  // The game is now over
         System.out.print("Game won by player ");
         System.out.println(game.getWinner());
     } // main()
} // TestOneRowNim
