package mru.game.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import mru.game.model.Player;

class PlayerTest {

  @Test
  void testPlayerStringDoubleInt() {
    Player p1 = new Player("Christopher", 325, 4);
    p1.getName();
    p1.getNumWins();
    assertEquals("CHRISTOPHER", p1.getName());
    assertEquals(325, p1.getBalance(), 0);
    assertEquals(4, p1.getNumWins());
  }
}
