/*
 * File: AnalyzeFreq.java
 * Author: Java, Java, Java
 * Description: This class counts the letters in a string. It
 *  uses an array of LetterFreq objects to store the frequency
 *  counts.
 */
public class AnalyzeFreq {
    private LetterFreq[] freqArr;  // An array of frequencies

    /**
     * AnalyzeFreq() constructor initializes the array
     */
    public AnalyzeFreq() {
        freqArr = new LetterFreq[26];
        for (int k = 0; k < 26; k++) {
            freqArr[k] = new LetterFreq((char)('A' + k), 0);
        } //for
    }

    /**
     * countLetters() counts the letters in its parameter
     *  and stores the results in the frequency array.
     * @param str is a string of text
     */
    public void countLetters(String str) {
        char let; //For use in the loop.
        str = str.toUpperCase();
        for (int k = 0; k < str.length(); k++) {
            let = str.charAt(k);
            if ((let >= 'A') && (let <= 'Z')) {
                freqArr[let - 'A'].incrFreq();
            } //if
        } //for
    }

    /**
     * printArray() prints the frequency array
     */
    public void printArray() {
        for (int k = 0; k < 26; k++) {
            System.out.print("letter: " + freqArr[k].getLetter());
            System.out.println(" freq: " + freqArr[k].getFreq());
        } //for
    } // printArray()

    /**
     * main() tests the AnalyzeFreq class
     */
    public static void main(String[] argv) {
        AnalyzeFreq af = new AnalyzeFreq();
        af.countLetters("Now is the time for all good students" +
           " to study computer related topics.");
        af.printArray();
    } //main()

} //AnalyzeFreq
