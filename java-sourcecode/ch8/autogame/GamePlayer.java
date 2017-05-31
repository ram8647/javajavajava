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
	}
        kb.prompt("What is your choice? ");
        int choice = kb.getKeyboardInteger();
        kb.prompt("\n");
        String className = gameNames[choice-1];
        game = (TwoPlayerGame)Class.forName(className).newInstance();
        kb.prompt("How many computers are playing, 0, 1, or 2? ");
        int computers = kb.getKeyboardInteger();
        for (int k = 0; k < computers; k++) {
            kb.prompt("Type in the name of the computer: ");
	    String player = kb.getUserInput();
            Class params[] = new Class[1]; 
            params[0] = game.getClass();
            Object g[] = new Object[1];
            g[0] = game;
            IPlayer computer  = 
		(IPlayer)Class.forName(player).getConstructor(params).newInstance(g);
	    //            IPlayer computer = (IPlayer)Class.forName(player).newInstance();
            game.addComputerPlayer(computer);
	}
	//        ((TwoPlayerGame)game).setNComputers(computers);
        ((CLUIPlayableGame) game).play(kb);
    }
}
