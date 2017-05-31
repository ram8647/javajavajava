public class RockPaperScissorsPlayer implements IPlayer
{   private RockPaperScissors game;
    public RockPaperScissorsPlayer (RockPaperScissors game) {   
	this.game = game;
    }
    public String makeAMove(String prompt) {   return ""+ (int)(Math.random() * 3);
    }
} // RockPaperScissorsPlayer
