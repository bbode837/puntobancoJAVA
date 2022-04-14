package mru.game.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import mru.game.model.Card;
import mru.game.model.CardInHand;

class CardInHandTest {

  @Test
  void testSetPlayerHandCardCard() {
    Card c1 = new Card(2, "Hearts", 2);
    Card c2 = new Card(5, "Diamonds", 5);
    CardInHand inHand = new CardInHand();
    inHand.setPlayerHand(c1, c2);
    ArrayList<Card> temp = new ArrayList<Card>();

    temp = inHand.getPlayerHand();

    Card ct = temp.remove(0);

    assertEquals("Hearts", ct.getSuit());
  }

  @Test
  void testPlayerDrawCard() {
    CardInHand inHand = new CardInHand();
    Card pDrawCard = new Card();
    String suit = "Spades";

    pDrawCard = inHand.playerDrawCard();
    pDrawCard.setSuit(suit);

    assertEquals("Spades", pDrawCard.getSuit());
  }
}
