public class Player {
    public static int COMPUTER=0;
    public static int HUMAN=1;
    protected String name;
    protected int type = HUMAN;
    protected Game game;

    public Player() {} 
    public Player(Game  g) { 
        game = g;}
    public Player (Game g, String nm) {
        game = g;
        name = nm;
    }
    public Player (Game g, String nm, int tp) {
        name = nm;
        game = g;
        type = tp;
    }
    public String toString() {
        String reply = name + ", a ";
        if (type == HUMAN)
            reply += "human";
        else
            reply += "computer";
        return reply;
    }
}
