public abstract class Player  {   
    public static final int COMPUTER=0;
    public static final int HUMAN=1;
    protected int id = -1;       // An int between 0 and nPlayers-1
    protected int kind = HUMAN;

    public Player() { }
    public Player(int id, int kind) {
        this.id = id;
        this.kind = kind;
    }
    public void setID(int k) {
        id = k;
    }
    public int getID() {
        return id;
    }
    public void setKind(int k) {
        kind = k;
    }
    public int getKind() {
        return kind;
    }
    public boolean isComputer() {
        return kind == COMPUTER;
    }
    public abstract String makeAMove(String prompt);
} // Player

