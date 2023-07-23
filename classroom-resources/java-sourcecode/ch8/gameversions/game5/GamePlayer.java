import java.io.*;
/**
 * Generic GamePlayer  Keyboard Application Program. Will play any 
   Playable game that uses a Keyboard interface.
 */
public class GamePlayer {
    public static int MAX_GAMES = 10;
    public static void main(String args[]) throws Exception {
        Playable game;
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
	}
        kb.prompt("What is your choice? ");
        int choice = kb.getKeyboardInteger();
        kb.prompt("\n");
        String className = gameNames[choice-1];
        game = (Playable)Class.forName(className).newInstance();
        game.play(kb);
    }
}
