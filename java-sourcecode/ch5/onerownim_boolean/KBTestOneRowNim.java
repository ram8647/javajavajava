public class KBTestOneRowNim
{
     public static void main(String argv[])
     {   KeyboardReader kb = new KeyboardReader();
         OneRowNim game = new OneRowNim(11);
         while(game.gameOver() == false)
         {   game.report();  // Prompt the user
             System.out.print("Input 1, 2, or 3: ");
             int sticks = kb.getKeyboardInteger(); // Get move
             game.takeSticks(sticks);   // Do move
             System.out.println();
         } // while
         game.report();  // The game is now over
         System.out.print("Game won by player ");
         System.out.println(game.getWinner());
     } // main()
} // TestOneRowNim