/*
 *  File: Card.java
 *  Author: Java, Java, Java
 *  Description: This class implements a representation of a
 *   playing card of the sort that would be used in Blackjack,
 *   or Solitaire. A card is represented by an integer that
 *   gives its rank, from 0 to 51. This enables cards easily 
 *   to be sorted. Simple arithmetic can be used to derive a
 *   card's suit (clubs, diamonds, etc.) and face value (ace,
 *   king, etc.) from its rank. Thus rank, suit, and value are
 *   defined as instance variables.
 *
 *  A card is also represented by a String, with CDHS standing
 *   for suit names and 2..A standing for face value. Finally
 *   a card is also represented by two images, one for its face
 *   value, and one for its back. 
 */

import java.awt.*;

public class Card implements Comparable {
     // The following string literals store letters that are used to
     // construct a String representation of the card.

    private final String suitStr = "CDHS";  // C=club,D=diamond,H=heart,S=spade
    private final String valueStr = "??23456789TJQKA";  // 2 through Ace

    public int rank;	 // 0..51
    public int value;	 // face value 2,3,,,10,11(jack),14(ace)
    public int suit;	 // 0=club,1=diamond,2=heart,3=spade
    private boolean faceUp;      // True when face-up
	
    /**
     *  The Card() constructor assigns the card a face value and suit,
     *   and records its rank. Initially the card is face up.
     *  @param rank -- an integer between 0 and 51
     */
    public Card (int rank) {
        this.rank = rank;               
        suit = rank / 13;          // Gives a number between 0..3
        value = 2 + rank % 13;     // Gives a number between 2..14 
        faceUp = true;
    } // Card()
	
    /**
     *  isBetween() returns true if this card is between
     *   c1 and c2 based on their face values
     *  @param c1, c2 -- two Cards, no order assumed
     *  @return true if and only if c1 < this < c2 or c1 > this > c2
     */
    public boolean between(Card c1, Card c2) {
        if (c1.value < c2.value ) {                // c1 < c2
            return c1.value < this.value  && this.value < c2.value;
        } else                                     // c1 >= c2
            return c1.value > this.value && this.value >  c2.value;
    } // isBetween()

    /**
     *  showCard() changes a card's state to faceUp, a boolean
     *  @param up -- true for up and false for down
     */
    public void showCard( boolean up ) {
        faceUp = up;
    } // showCard

    /**
     *  Goal: Return a 2 character representation of the card. For
     *    example, "2c" means 2 of clubs, "jd" is jack of diamonds.
     * Algorithm: the instance variables, suit, and value,
     *  are used as indexes into strings that store the correct letters
     */
    public String toString() {
        if (faceUp)
	    return "" +  valueStr.charAt(value) + suitStr.charAt(suit);
        else 
            return "??";
    } // toString

    /** 
     * compareTo() -- from the Comparable interface. This method's
     *  implementation is left as an lab exercise.
     */
    public int compareTo(Object o) {
        int oRank = ((Card) o).rank;  // Cast o into a Card reference
        return 0;
    }
} // Card
