public class NWayMultPlayer extends Player implements IPlayer {
    public NWayMultPlayer(UserInterface u) { 
        super(u);
    }
    public NWayMultPlayer (String nm, UserInterface u) {
        super(nm, u);
    }
    public NWayMultPlayer (String nm, int tp) {
        super(nm, tp);
    }
    public NWayMultPlayer (String nm, UserInterface u, int tp) {
        super(nm, u, tp);
    }
    public String move(String prompt) {
        if (type==HUMAN) 
            return ui.getUserInput();
	else 
            return "" + doMultiplication(prompt);
    }
    private int doMultiplication(String prompt) {
        String s1= "";
        String s2= "";
        int k=0;
        while (!Character.isDigit(prompt.charAt(k)) && k < prompt.length()) // Skip nonumerics
	    ++k;
        while (Character.isDigit(prompt.charAt(k)) && k < prompt.length()) {
	    s1 += prompt.charAt(k);
	    ++k;
	}
        while (!Character.isDigit(prompt.charAt(k)) && k < prompt.length()) // Skip nonumerics
	    ++k;
        while (Character.isDigit(prompt.charAt(k)) && k < prompt.length()) {
	    s2 += prompt.charAt(k);
	    ++k;
	}
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        return n1 * n2;
    }
}
