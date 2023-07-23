public class MultPlayer implements IPlayer
{   private MultiplicationGame game;
   
    public MultPlayer (MultiplicationGame game)
    {   this.game = game;
    }
    public String makeAMove(String prompt) 
    {   
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
        return ""+ (n1 * n2);
    }
} // MultPlayer
