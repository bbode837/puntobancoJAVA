package mru.game.model;

import mru.game.controler.Controler;
import mru.game.view.Menu;

/**
 * PuntoBanco Game
 *
 * @author scott and brandon
 */
public class PuntoBanco {

  Menu menu;
  Controler c1;
  CardInHand inHand;

  /**
   * Constructor instantiates menu and card in hand
   *
   * @throws Exception exception
   */
  public PuntoBanco() throws Exception {
    menu = new Menu();
    inHand = new CardInHand();
  }

  /**
   * This method launches the PuntoBanco game.
   *
   * @param currentPlayer Current Player info
   */
  public void launchGame(Player currentPlayer) {

    boolean cont = true;

    do {

      inHand.getPlayerHand().clear();
      inHand.getBankerHand().clear();

      // declaring all local variables
      char winCode;
      char choice;
      char betCode;
      int currentBalance;
      int newBalance;
      int stakes;
      int playerSum;
      int bankerSum;
      String text;
      Card pCardDrawn1;
      Card bCardDrawn1;
      Card pCardDrawn2;
      Card bCardDrawn2;
      Card pCardDrawn3;
      Card bCardDrawn3;

      // initializing local variables

      currentBalance = currentPlayer.getBalance();
      playerSum = 0;
      bankerSum = 0;
      pCardDrawn3 = new Card();
      bCardDrawn3 = new Card();

      /*
       * Prompt user for who they want to bet on
       * and how much they want to bet
       */

      betCode = menu.betOn();
      stakes = menu.betAmount();

      // Validating the users bet amount against their balance.

      while (stakes > currentBalance || stakes < 0) {
        System.out.println("You can't bet more than your worth.");
        stakes = menu.betAmount();
      }

      // FIRST CARD DRAW

      pCardDrawn1 = inHand.playerDrawCard();
      playerSum = playerSum + pCardDrawn1.getWeight();

      bCardDrawn1 = inHand.bankerDrawCard();
      bankerSum = bankerSum + bCardDrawn1.getWeight();

      // SECOND CARD DRAW

      pCardDrawn2 = inHand.playerDrawCard();
      playerSum = playerSum + pCardDrawn2.getWeight();

      bCardDrawn2 = inHand.bankerDrawCard();
      bankerSum = bankerSum + bCardDrawn2.getWeight();

      playerSum = playerSum % 10;
      bankerSum = bankerSum % 10;

      // Calculate if a THIRD CARD DRAW is necessary

      if (playerSum <= 5) {
        pCardDrawn3 = inHand.playerDrawCard();
        playerSum = playerSum + pCardDrawn3.getWeight();

        if (pCardDrawn3.getWeight() == 2 || pCardDrawn3.getWeight() == 3) {
          if (bankerSum <= 4) {
            bCardDrawn3 = inHand.bankerDrawCard();
            bankerSum = bankerSum + bCardDrawn3.getWeight();
          }
        } else if (pCardDrawn3.getWeight() == 4 || pCardDrawn3.getWeight() == 5) {
          if (bankerSum <= 5) {
            bCardDrawn3 = inHand.bankerDrawCard();
            bankerSum = bankerSum + bCardDrawn3.getWeight();
          }

        } else if (pCardDrawn3.getWeight() == 6 || pCardDrawn3.getWeight() == 7) {
          if (bankerSum <= 6) {
            bCardDrawn3 = inHand.bankerDrawCard();
            bankerSum = bankerSum + bCardDrawn3.getWeight();
          }
        } else if (pCardDrawn3.getWeight() == 8) {
          if (bankerSum <= 2) {
            bCardDrawn3 = inHand.bankerDrawCard();
            bankerSum = bankerSum + bCardDrawn3.getWeight();
          }
        } else if (pCardDrawn3.getWeight() == 1 || pCardDrawn3.getWeight() == 0) {
          if (bankerSum <= 3) {
            bCardDrawn3 = inHand.bankerDrawCard();
            bankerSum = bankerSum + bCardDrawn3.getWeight();
          }
        }
      }

      // constructing Player and Banker Hands

      inHand.setPlayerHand(pCardDrawn1, pCardDrawn2, pCardDrawn3);
      inHand.setBankerHand(bCardDrawn1, bCardDrawn2, bCardDrawn3);

      // Calculating final player and banker points

      playerSum = playerSum % 10;
      bankerSum = bankerSum % 10;
      menu.printBox(inHand.getPlayerHand(), inHand.getBankerHand(), playerSum, bankerSum);

      // calculating who won

      if (playerSum > bankerSum) {
        winCode = 'P';
      } else if (bankerSum > playerSum) {
        winCode = 'B';
      } else {
        winCode = 'T';
      }

      // Paying the player if they won
      if (winCode == betCode) {
        if (betCode == 'T') {
          stakes = stakes * 5;
          newBalance = currentBalance + stakes;
          currentPlayer.setBalance(newBalance);
          currentPlayer.setNumWins(currentPlayer.getNumWins() + 1);
          text = "WON";
        } else {
          newBalance = currentBalance + stakes;
          currentPlayer.setBalance(newBalance);
          currentPlayer.setNumWins(currentPlayer.getNumWins() + 1);
          text = "WON";
        }

        // Taking money out of current player balance
      } else {
        if (betCode == 'T') {
          newBalance = currentBalance - stakes;
          currentPlayer.setBalance(newBalance);
          text = "LOST";
        } else {
          newBalance = currentBalance - stakes;
          currentPlayer.setBalance(newBalance);
          text = "LOST";
        }
      }

      // Print the results of the game
      menu.printWinBox(text, stakes);

      // Ask if user wants to play again
      choice = menu.playAgain();

      if (choice == 'N') {
        cont = false;
      }

    } while (cont == true && currentPlayer.getBalance() > 0);

    if (cont == false) {
      menu.printGoodbye();
    } else if (currentPlayer.getBalance() <= 0) {
      menu.printPleaseLeave();
    }
  }
}
