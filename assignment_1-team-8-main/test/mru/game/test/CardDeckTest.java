package mru.game.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.game.model.CardDeck;

class CardDeckTest {

  @Test
  void testCardDeck() {

    CardDeck car = new CardDeck();
    int length = car.deck.size();
    assertEquals(52, length);
  }

  @Test
  public void testShuffled() {
    CardDeck deck = new CardDeck();
    CardDeck testDeck = new CardDeck();
    deck.shuffleDeck();
    assertFalse(deck.equals(testDeck));
  }
}
