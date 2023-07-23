public class ShowDownPlayer extends Player {   
    public static final int INIT_POINTS = 3;
    private ShowDown game;
    private Card myCard;
    private boolean inGame = true;
    private int points = INIT_POINTS;
    public ShowDownPlayer (ShowDown game) {   
	this.game = game;
    }

    public ShowDownPlayer (ShowDown game, int kind) {   
	this.game = game;
        this.kind = kind;
    }

    public String makeAMove(String prompt)  {   
	if (Math.random() > 0.5) 
	    return "FOLD";
        return "CALL";
    }     

    public int getPoints() {
        return points;
    }

    public void loseAPoint() {
        --points;
        inGame =  points > 0;
    }
    public void gainAPoint() {
        ++points;
    }
    public boolean inGame() { return inGame; }
    public boolean inHand() { return myCard != null; }

    public void deal(Card card) {
        myCard = card;
    }
    public Card showCard() {
        return myCard;
    }
    public void fold() {
        myCard = null;   // Throw in your card
    }
    public String toString() {
        if (kind == HUMAN)
	    return "Human player";
        String className = this.getClass().toString(); 
        return "Computer " + className.substring(5);                 
    }
} // ShowDownPlayer

