package mru.game.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a card deck
 *
 * @author khosro salmani, Scott, Brandon
 * @version 1.0
 */
public class CardDeck {

  public ArrayList<Card> deck;

  /** deck holds all of the cards that currently are in the current deck */

  /**
   * This constructor initiate the arraylist and calls the repective methods to create a new deck
   */
  public CardDeck() {
    deck = new ArrayList<Card>();
    createDeck();
    shuffleDeck();
  }

  /** This method creates the deck */
  public void createDeck() {
    // suits holds the name of the suits
    String[] suits = {"Spades", "Diamond", "Clubs", "Hearts"};
    int w = 0;
    /*
     * The for loop creates a whole new deck based on their suit and rank
     */
    for (int i = 0; i < 4; i++) {
      for (int j = 1; j <= 13; j++) {

        if (j <= 9) {
          w = j;

        } else if (j >= 10) {
          w = 0;
        }
        // adds card to the deck
        deck.add(new Card(j, suits[i], w));
      }
    }
  }

  /** this method shuffle the deck after creating a new deck */
  public void shuffleDeck() {
    Collections.shuffle(deck);
  }

  /**
   * The deck getter method
   *
   * @return the deck
   */
  public ArrayList<Card> getDeck() {
    return deck;
  }

  /** Method to check how many card are left in the deck. */
  public void checkDeckLength() {
    if (deck.size() == 0) {
      createDeck();
      shuffleDeck();
      System.out.println("Shuffling new deck...");
    }
  }
}
