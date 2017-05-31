/*
 * File: StringProcessor.java
 * Author: Java, Java, Java
 * Description:  This class solves self-study exercises 7.12 aadn 7.13/
 *  It also contains some of the other methods described in Chapter 7.
 */

public class StringProcessor{

    /**
     * getName() extracts the name portion of a name:password string.
     * @param str, a String of the form name:password
     * @return a String containing all letters preceding the colon in name:password
     */
    public static String getName(String str) {
	int posColon = str.indexOf(':');  // Find the delimiter
	String result = str.substring(0, posColon); // Get name
	return result;
    }

    /**
     * getPassword() extracts the password portion of a name:password string.
     * @param str, a String of the form name:password
     * @return a String containing all letters following the colon in name:password
     */ 
   public static String getPassword(String str) {
	int posColon = str.indexOf(':');  // Find the delimiter
	String result = str.substring(posColon + 1); // Get passwd
	return result;
    }

    /**
     * Pre:  s and keyword are any Strings
     * Post: keywordSearch() returns a String containing the
     *  number of occurrences of keyword in s, followed
     *  by the starting location of each occurrence
     * @param s, a String to be searched.
     * @param keyword, a String to search for
     * @return a String the number of occurrences and locations of keyword in s
     */
    public String keywordSearch(String s, String keyword) {
	StringBuffer resultStr = new StringBuffer();  	// Create StringBuffer
	int count = 0;
	int ptr = s.indexOf(keyword);
	while (ptr != -1) {
	    ++count;
	    resultStr.append(ptr + " ");  // Append to buffer
	    ptr = s.indexOf(keyword, ptr + 1);
	}
	resultStr.insert(0, count + ": ");
	return resultStr.toString(); // Convert buffer to String
    } // keywordSearch()

    /**
    * Precondition: str is not null
    * Postcondition: the letters in str will have been printed
    */
    public static void printLetters(String str) {
        for (int k = 0; k < str.length(); k++)// For each character
            System.out.println(str.charAt(k)); // Print it
    } // printLetters


    /**
    * Precondition: Neither str nor ch are null
    * Postcondition: countchar() == the number of ch in str
    */
    public static int countChar(String str, char ch) {
        int counter = 0; // Initialize a counter
        for (int k = 0; k < str.length(); k++)// For each character
            if (str.charAt(k) == ch) // If it's a ch
                counter++; // count it
        return counter; // Return the result
    } // countChar()


    /**
    * Pre: s is any non null string
    * Post: s is returned in reverse order
    */
    public static String reverse(String s) {
        StringBuffer result = new StringBuffer();
        for (int k = s.length()-1; k >= 0; k--) {
            result.append(s.charAt(k));
        } //for
        return result.toString();
    } // reverse()

    /**
    * Pre: s is any non null string
    * Post: s is returned with only its initial letter capitalized
    */
    public static String capitalize(String s) {
        if (s.length() == 0) // Special case: empty string
            return s;
        StringBuffer result = new StringBuffer();
        result.append(s.toUpperCase().charAt(0)); // Convert first letter
        s = s.toLowerCase(); // Convert other letters
        for (int k = 1; k < s.length(); k++) {  // Add them to result
            result.append(s.charAt(k));
        } //for
        return result.toString();
    } // capitalize()

    /**
     * precedes() returns true if s1 comes before s2 in lexicographic order.
     * @param s1, the first String
     * @param s2, the second String
     * @return true or false depending on whether s1 < s2
     */
    public boolean precedes(String s1, String s2) {
	// Pick shorter length
	int minlen = Math.min(s1.length(), s2.length()); 
	// For each char in shorter string}
	for (int k=0; k < minlen; k++) { 
	    if (s1.charAt(k) != s2.charAt(k))// If chars unequal
		//  return true if s1's char precedes s2's
		return s1.charAt(k) < s2.charAt(k); 
	}
	// If all characters so far are equal
        //  then s1 < s2 if it is shorter than s2
	return s1.length() < s2.length();  
    } // precedes()}  

    /**
     * removeBlanks() removes blank letters from a string, s
     *  Pre: s is a non null string
     *  Post: s is returned with all its blanks removed
     * @param s, String from which blanks are removed
     * @return the string s with no blanks
     */
    public String removeBlanks(String s) {
	StringBuffer result = new StringBuffer();
	for (int k = 0; k < s.length();  k++)
	    if (s.charAt(k) != ' ')      // If this is not a blank
		result.append(s.charAt(k));  //  append it to result
	return result.toString();
    } // removeBlanks()

} // StringProcessor class
