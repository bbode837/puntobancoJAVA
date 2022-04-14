package mru.game.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.game.model.Card;

class CardTest {

  @Test
  void testCard() {
    Card card = new Card(1, "Spades", 1);
    card.getRank();
    card.getSuit();
    card.getWeight();
    assertEquals(1, card.getRank());
    assertEquals("Spades", card.getSuit());
    assertEquals(1, card.getWeight());
  }

  @Test
  void testToString() {
    String c1;
    String c2;
    String c3;
    String c4;

    Card card1 = new Card(1, "Spades", 1);
    Card card2 = new Card(11, "Diamonds", 1);
    Card card3 = new Card(12, "Clubs", 1);
    Card card4 = new Card(13, "Hearts", 1);

    c1 = card1.toString();
    c2 = card2.toString();
    c3 = card3.toString();
    c4 = card4.toString();

    assertEquals("Ace of Spades", c1);
    assertEquals("Jack of Diamonds", c2);
    assertEquals("Queen of Clubs", c3);
    assertEquals("King of Hearts", c4);
  }
}
