public class Mora extends Game implements Playable {
    private int sum;

    public Mora(int n) {
        super(n);
    }

    public boolean gameOver() {
        return false;
    }
    public String getWinner() {
        return "";
    }
    public String report(){
        return "";
    }
    public String move(String s) {
        return "";
    }
    public String prompt() {
        return "Throw fingers and shout a sum";
    }
    public void play(KeyboardReader kb) {
    }
    public void play(GameGUI gui) {
    }
}
