package mru.game.model;

import java.util.ArrayList;

/**
 * This class represents the player and banker's hand
 *
 * @author Scott and Brandon
 */
public class CardInHand {

  /** */
  private ArrayList<Card> playerHand = new ArrayList<>();

  private ArrayList<Card> bankerHand = new ArrayList<>();
  public CardDeck cd = new CardDeck();

  /** Default constructor */
  public CardInHand() {}

  /**
   * Method to return the cards that are in the players hand
   *
   * @return playerHand
   */
  public ArrayList<Card> getPlayerHand() {
    return playerHand;
  }

  /**
   * Method to return the cards that are in the bankers hand
   *
   * @return bankerHand
   */
  public ArrayList<Card> getBankerHand() {
    return bankerHand;
  }

  /**
   * players hand setter method with 2 cards
   *
   * @param c1 (the first card)
   * @param c2 (the second card)
   */
  public void setPlayerHand(Card c1, Card c2) {
    playerHand.add(c1);
    playerHand.add(c2);
  }

  /**
   * players hand setter method with 3 cards
   *
   * @param c1 (the first card)
   * @param c2 (the second card)
   * @param c3 (the third card)
   */
  public void setPlayerHand(Card c1, Card c2, Card c3) {
    playerHand.add(c1);
    playerHand.add(c2);
    playerHand.add(c3);
  }

  /**
   * bankers hand setter method with 2 cards
   *
   * @param c1 (the first card)
   * @param c2 (the second card)
   */
  public void setBankerHand(Card c1, Card c2) {
    bankerHand.add(c1);
    bankerHand.add(c2);
  }

  /**
   * bankers hand setter method with 3 cards
   *
   * @param c1 (the first card)
   * @param c2 (the second card)
   * @param c3 (the third card)
   */
  public void setBankerHand(Card c1, Card c2, Card c3) {
    bankerHand.add(c1);
    bankerHand.add(c2);
    bankerHand.add(c3);
  }

  /**
   * player drawing card method
   *
   * @return temp . new card added to players hand
   */
  public Card playerDrawCard() {
    Card temp;
    temp = cd.getDeck().remove(0);
    cd.checkDeckLength();
    return temp;
  }

  /**
   * banker drawing card method
   *
   * @return temp . new card added to bankers hand
   */
  public Card bankerDrawCard() {
    Card temp;
    temp = cd.getDeck().remove(0);
    cd.checkDeckLength();
    return temp;
  }
}
