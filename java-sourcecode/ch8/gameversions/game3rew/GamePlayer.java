import java.io.*;
/**
  * Generic GamePlayer  Keyboard Application Program. Will play any
    Playable game that uses a Keyboard interface.
  */
public class GamePlayer {
     public static int MAX_GAMES = 10;

     public static void main(String args[]) throws Exception {
         TwoPlayerGame game;
         KeyboardReader kb = new KeyboardReader();
         BufferedReader inStream =
	       new BufferedReader(new FileReader("games.txt"));
         String line = inStream.readLine();
         String gameNames[] = new String[MAX_GAMES];
         kb.prompt("Welcome. Here are the games you can play\n");
         int count = 0;
         while (line != null && count < MAX_GAMES) {
             gameNames[count++] = line;
             kb.prompt("" + count + ") " + line + "\n");
             line = inStream.readLine();
	       } //while
         kb.prompt("What is your choice? ");
         int choice = kb.getKeyboardInteger();
         kb.prompt("\n");
         String className = gameNames[choice-1];
//         game = (Playable)Class.forName(className).newInstance();
        game = (TwoPlayerGame)Class.forName(className).newInstance();
        kb.display(game.getRules());
        kb.prompt(game.report());
        kb.prompt(game.prompt());  // Prompt the user
        while(!game.gameOver()) {     
            String str = kb.getKeyboardInput();	          
            kb.display(game.move(str));        
        } // while	      
        kb.display(game.report());  // The game is now over	      
        kb.display("Game won by player " + game.getWinner() + "\n");
     } //main()
} //GamePlayer class
