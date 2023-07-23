/***************************************************************************
*********************************************************************************
 * Title:       Global Text Replace Lab
*Prtogram Name:	Replace.java							*
*Description:  This class replaces a target string with a replacement string
* @author    CPSC115						        	*
* Modified : Dinkins 4/04							*
*********************************************************************************
*********/

public class Replace
{
/******************************************************************
 * Default Constructor	  					  *

*******************************************************************/
	
	public Replace()
	{
	  
	} // end constructor
	
	
/******************************************************************
 * Replaces a target string with a replacement string	  
 * Algorithm:  This uses two pointers: pos, which is set initially to the
   beginning str, and ptr, which is set to the first location of str1.
   Pos will iterate through each character in str.
   On each iteration of the loop, we either append another character
   from str into the result buffer and increment pos by 1 or, if pos
   is at the location of the target string,  we append
   the replacement string to the result buffer and increment pos so it
   points just past the target string.
 * @param str - document input string				  
 * @param str1 - target string 				  
 * @param str2 - replacement string				  
 * @ result -Passes the modified string to the GlobalReplaceApplet class 
*******************************************************************/
	
public String Find_Replace(String str,String str1,String str2) {
  StringBuffer result = new StringBuffer();
   
  int pos = 0;                  // Beginning of str
  int ptr = str.indexOf(str1);  // First location of str1 in str
     
  while (pos < str.length())  { // Go character by character
      if(pos == ptr)         { // If pos has reached a location of str1
	  result.append(str2 );           // Append str2
	  ptr = str.indexOf(str1,ptr+1);  //  Find next occurrence of str1
	  pos = pos+str1.length();       //  Skip over str1
      } else {               // Otherwise
	  result.append(str.charAt(pos) ); // Just append another character  
	  pos++;  // increase by 1
      } // end else
        
  }//end while
  return result.toString();
} // end Find_Replace()
  
}// end Replace class


