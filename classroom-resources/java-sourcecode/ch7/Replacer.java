/**
 * Title:       Global Text Replace Lab
 * Program Name:	Replacer.java
 * Description:  This class contains the findReplace() method, which 
 *   replaces a target string with a replacement string
 * @author    CPSC115		
 * Modified : B. Dinkins  and R. Morelli 4/04
 */

public class Replacer {
    /**
     * Default Constructor 
     */
    public Replacer() { } // end constructor

    /**
     * Replaces all occurrences of str1 with str2 in text.
     * Algorithm: We use a pointer, pos, to point initially to the start
     *  of text, and a second pointer to point initially to the first location 
     *  of str1 in text. On each iteration we update, so that pos
     *  starts just after an occurence of str1, and ptr points to
     *  the location of the next location of str1. When the loop exits,
     *  we append the rest of text to the result and return the result.
     *
     * @param text - document input string
     * @param str1 - substring to be replaced
     * @param str2 - replacement substring
     * @return - Returns a string with every occurrence of str1 replaced
     *   by str2 in text.
     */
	
    public String findReplace(String text, String str1, String str2)  {
        StringBuffer result = new StringBuffer();
   
        int pos = 0;                   // Starting position
        int ptr = text.indexOf(str1);  // Location of first occurrence, if any
 
        while (ptr != -1)  {
            result.append(text.substring(pos,ptr) + str2); // Append prefix and new string
            pos = ptr + str1.length();                     // Adjust starting position
            ptr = text.indexOf(str1, ptr+str1.length());   // Find next occurrence
        }//end while
        result.append(text.substring(pos));    // Append rest of the string
        return result.toString();
    }// end findReplace()
	
    /**
     * main() is used to test the findReplace() method. Several test cases are
     *  presented.
     */
    public static void main(String args[]) {
        String s = "To be or not to be that is the question";
        String s1 = "Do not fear to be eccentric in opinion, for every " +
                    "opinion now accepted was once eccentric. -- Bertrand Russell";
        Replacer replacer = new Replacer();
        System.out.println(s);
        System.out.println(replacer.findReplace(s,"be","me"));
        System.out.println(replacer.findReplace(s,"on",""));
        System.out.println(replacer.findReplace(s,"bee","wee"));
        System.out.println(s1);
        System.out.println(replacer.findReplace(replacer.findReplace(s1,"eccentric","bold"), 
                                                            "Bertrand Russell", "R. Morelli"));
    }  
}// end Replace class


