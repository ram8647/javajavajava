/*
 * File: Deck.java
 * Author: Java, Java, Java
 * Description: This class uses an array to store 52 Card objects.
 *  It provides methods to shuffle and sort the deck.
 */
public class Deck {	
    public static final int NCARDS = 52;	// Class constant

    private Card deck[] = new Card [NCARDS];  // 52 card array
    private int top = 0;                      // Position of top card

    public Deck() {
	deck = new Card[NCARDS];
        top = 0;
	for (int k = 0; k < deck.length; k++) {  // Make the cards
            deck[k] = new Card( k );	
	}
    }
    public Card dealOne() {
        Card card = deck[top];
        top = (top + 1) % NCARDS;
        return card;
    }
    public void shuffleDeck() {
        top = 0;
        Card temp;
        for (int k = 0; k < NCARDS / 2; k++) {
           int i = (int) ( Math.random() * NCARDS ); // Pick two cards from the deck
           int j = (int) ( Math.random() * NCARDS );
           temp = deck[i];                           // Swap them
           deck[i] = deck[j];
           deck[j] = temp;
        } // 
   } // shuffleDeck()
   public void sortDeck() {
      int smallest;                         // Keeps track of smallest card
      for (int count = 0; count < deck.length-1; count++) {  // 51 iterations
          smallest = count;
          for (int current = count+1; current < deck.length; current++) 
              if (deck[current].rank < deck[smallest].rank) 
                  smallest = current;
          if (smallest != count) {             // Swap smallest and count
              Card temp = deck[smallest];      
              deck[smallest] = deck[count];	
              deck[count] = temp;
          } // if
      } // outer for
   } // sortDeck()
} // Deck
