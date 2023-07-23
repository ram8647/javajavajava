/*
 * File: LetterFreq.java
 * Author: Java, Java, Java
 * Description: This class defines an object that can store
 *  a letter and its frequency. It is used to count letters
 *  in a message or document.
 */
public class LetterFreq {
    private char letter;    // A character being counted
    private int freq;       // The frequency of letter

    /**
     * LetterFreq() constructor initiales the letter and 
     *  its frequency.
     * @param ch the letter
     * @param fre the letter's frequency
     */
    public LetterFreq(char ch, int fre) {
        letter = ch;
        freq = fre;
    }

    /**
     * getLetter() returns the letter
     */
    public char getLetter() {
        return  letter;
    }

    /**
     * getFreq() returns the letter's frequency
     */
    public int getFreq() {
        return  freq;
    }

    /**
     * incrFreq() adds one to this letter's frequency
     */
    public void incrFreq() {
        freq++;
    }
} //LetterFreq
