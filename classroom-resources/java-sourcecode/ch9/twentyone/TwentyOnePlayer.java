//public class TwentyOnePlayer extends Player implements IPlayer {   
public class TwentyOnePlayer extends Player {   
    private TwentyOne game;
    private Card myCards[] = new Card[10]; // Up to 10 cards per hand
    private int nCards = 0;
    private int points = 0;

    public TwentyOnePlayer (TwentyOne game) {   
	this.game = game;
    }
    public TwentyOnePlayer (TwentyOne game, int kind, int id) {   
        super(id, kind);
	this.game = game;
    }
    public String makeAMove(String prompt)  {   
	if (totalCards() <= 16)
	    return "HIT";
        return "STAY";
    }     
    public void newHand() {
        nCards = 0;
    }
    public void deal(Card card) {
        myCards[nCards++] = card;
    }
    public int totalCards() {
        int sum = 0;
        for (int k = 0; k < nCards; k++)
	    sum += game.getFaceValue(myCards[k].value);
        return sum;
    }
    public String getHand() {
        StringBuffer result = new StringBuffer();
        for (int k = 0; k < nCards; k++)
	    result.append(myCards[k].toString() + " ");
        result.append(" Total= " + totalCards());
        return result.toString();
    }
    public int getPoints() {
        return points;
    }
    public void updatePoints(int n) {
        points += n;
    }
    public String toString() {
        StringBuffer result = new StringBuffer();
        if (kind == HUMAN)
	    result.append("Human (");
        else
            result.append(this.getClass().toString().substring(6) + " (");
        result.append(points + " points) ");
        return result.toString();
    }
} // TwentyOnePlayer

