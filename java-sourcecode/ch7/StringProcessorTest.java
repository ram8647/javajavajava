/*
 * File: StringProcessor.java
 * Author: Java, Java, Java
 * Description:  A class to test methods contained in StringProcessor.
 */

public class StringProcessorTest {
   
    public static void main(String[] args) {
        KeyboardReader kb = new KeyboardReader();
        kb.display("Testing static method getName() and getPassword()\n");
	kb.display(StringProcessor.getName("agent007:yrrsr") + " is the name in agent007:yrrsr\n");
	kb.display(StringProcessor.getPassword("agent007:yrrsr") + " is the password in agent007:yrrsr\n");

	StringProcessor processor = new StringProcessor();
        kb.display("Search for all occurrences of 'is' in 'this is a test'\n");
	kb.display(processor.keywordSearch("this is a test", "is") + "\n");

        kb.display("Testing precedes()\n");
        kb.display("precedes('hello','goodbye') is " + processor.precedes("hello", "goodbye") + "\n");
        kb.display("precedes('aardvark','aaron') is " + processor.precedes("aardvark", "aaron") + "\n");

        kb.prompt("Input a String or - stop - to quit: ");
        String str = kb.getKeyboardInput();
        while (!str.equals("stop")){
            kb.display("Testing printLetters()\n");
            StringProcessor.printLetters(str);
            kb.display("testing countChars()\n");
            kb.display("Total occurences of e = ");
            kb.display(StringProcessor.countChar(str,'e') + "\n");
            kb.display("Testing reverse()\n");
            kb.display(StringProcessor.reverse(str)+ "\n");
            kb.display("Testing capitalize()\n");
            kb.display(StringProcessor.capitalize(str) + "\n");
            kb.display("Testing removeBlanks()\n");
	    kb.display(processor.removeBlanks(str) + "\n\n");
            kb.prompt("Input a String or - stop - to quit: ");
            str = kb.getKeyboardInput();
        } // while
    } //main()

} // StringProcessorTest class
