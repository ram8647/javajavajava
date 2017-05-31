public class PlayIt {
    public static void main(String args[])  {  
        TwoPlayerGame game = null;
	KeyboardReader kb = new KeyboardReader();
        kb.prompt("Which game do you want to play\n" +
                   " 1=OneRowNim, 2=WordGuess ?");
	int choice = Integer.parseInt(kb.getUserInput());
        if (choice==1)
	    game = new OneRowNim(11);
        else
            game = new WordGuess();        
        kb.prompt("How many computers are playing, 0, 1, or 2? ");
	int m = kb.getKeyboardInteger();
        game.setNComputers(m);
        ((CLUIPlayableGame)game).play(kb);
    } //main()
}
