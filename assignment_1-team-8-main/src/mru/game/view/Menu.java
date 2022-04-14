package mru.game.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Card;
import mru.game.model.Player;

/**
 * User interface
 *
 * @author scott and brandon
 */
public class Menu {

  Scanner kb;

  /** This constructor initiates the Scanner kb */
  public Menu() {
    kb = new Scanner(System.in);
  }

  /**
   * Method that prints out main menu, asking for a choice of play game, search, exit.
   *
   * @return ans . the corresponding char that equals an option
   */
  public char printMenu() {

    System.out.println("Select one of these options: \n");

    System.out.println("\t(P) Play Game");
    System.out.println("\t(S) Search");
    System.out.println("\t(E) Exit \n");
    // asks for input from the player for which option they want to choose
    System.out.println("Enter a choice: ");
    String text = kb.nextLine().trim();
    // input must be 1 char in length
    while (text.length() > 1) {
      System.out.println("\nInvalid entry");
      System.out.println("Enter a choice: ");
      text = kb.nextLine().trim();
    }

    while (text.length() == 0) {
      System.out.println("\nInvalid entry");
      System.out.println("Enter a choice: ");
      text = kb.nextLine().trim();
    }

    // converts all answers to upper case

    char ans = text.toUpperCase().charAt(0);

    // char must be either P, S or E to continue
    while (ans != 'P' && ans != 'S' && ans != 'E') {
      System.out.println("\nInvalid entry");
      System.out.println("Enter a choice: ");
      ans = kb.nextLine().trim().toUpperCase().charAt(0);
    }

    return ans;
  }

  /**
   * Method that prints out search menu, asking for a choice of top player, name lookup, main menu.
   *
   * @return ans . the corresponding char that equals an option
   */
  public char printSubMenu() {
    System.out.println("Select on of these options: \n");

    System.out.println("\t(T) Top player (Most number of wins)");
    System.out.println("\t(N) Looking for a Name");
    System.out.println("\t(B) Back to Main menu\n");
    // asks for input from the player for which option they want to choose
    System.out.println("Enter a choice: ");
    String text = kb.nextLine().trim();
    // input must be 1 char in length
    while (text.length() > 1 || text.length() == 0) {
      System.out.println("\nInvalid entry");
      System.out.println("Enter a choice: ");
      text = kb.nextLine().trim();
    }
    // converts all answers to upper case
    char ans = text.toUpperCase().charAt(0);
    // char must be either T, N or B to continue
    while (ans != 'T' && ans != 'N' && ans != 'B') {
      System.out.println("\nInvalid entry");
      System.out.println("Enter a choice: ");
      ans = kb.nextLine().trim().toUpperCase().charAt(0);
    }

    return ans;
  }

  /**
   * Method that prints a formatted list of the top players based on the number of wins
   *
   * @param topPlayerList . Array of top players
   */
  public void printTopPlayerMenu(ArrayList<Player> topPlayerList) {

    printTopPlayerHeader();

    printAllTopPlayers(topPlayerList);

    System.out.println(" ");
    // pressing enter brings back to main menu
    System.out.println("Press \"Enter\" to continue. . .");
    kb.nextLine();
  }
  /**
   * Method prints out the top players
   *
   * @param topPlayerList . Array of top player
   */
  private void printAllTopPlayers(ArrayList<Player> topPlayerList) {
    for (Player p : topPlayerList) {
      // prints top players
      printTopPlayer(p);
    }
  }
  /**
   * Method prints out formatted lines with top players name and number of wins.
   *
   * @param p . top player p from arraylist
   */
  private void printTopPlayer(Player p) {
    System.out.format("| %-17s | %-20d |%n", p.getName(), p.getNumWins());
    System.out.println("+===================+======================+");
  }

  /** Method that prints out the head of the top player menu */
  private void printTopPlayerHeader() {
    System.out.println("              - TOP PLAYERS -               ");
    System.out.println("+===================+======================+");
    System.out.println("| NAME              | # WINS               |");
    System.out.println("+===================+======================+");
  }
  /**
   * Method that prompts user to enter their name.
   *
   * @return name . name that is inputed by user.
   */
  public String promptName() {
    String name;
    System.out.println("What is your name: \n");
    System.out.println("Press \"Enter\" to continue. . .");

    name = kb.nextLine().trim().toUpperCase();

    return name;
  }

  /**
   * Method that brings out a welcome line for new players with initial balance
   *
   * @param currentPlayer . Player that is playing the game
   */
  public void welcome(Player currentPlayer) {

    final String dollar = "$";

    System.out.println("*************************************************************************");
    System.out.format(
        "***   Welcome %s     ---    Your initial balance is: %d %-2s      ***%n",
        currentPlayer.getName().toUpperCase(), currentPlayer.getBalance(), dollar);
    System.out.println("*************************************************************************");
  }
  /**
   * Method that brings out a welcome line for returning players with balance
   *
   * @param currentPlayer . Player that is playing the game
   */
  public void welcomeBack(Player currentPlayer) {

    final String dollar = "$";

    System.out.println("*************************************************************************");
    System.out.format(
        "***   Welcome back %s     ---    Your balance is: %d %-5s      ***%n",
        currentPlayer.getName().toUpperCase(), currentPlayer.getBalance(), dollar);
    System.out.println("*************************************************************************");
  }

  /**
   * Method that prints out player info in a formatted list with name, number of wins and balance
   *
   * @param foundPlayer . returning player that is playing the game
   */
  public void playerInfo(Player foundPlayer) {

    final String dollar = "$";

    System.out.println("                      - PLAYER INFO -                        ");
    System.out.println("+==================+===============+======================+");
    System.out.println("| NAME             | # WINS        | BALANCE              |");
    System.out.println("+==================+===============+======================+");
    System.out.format(
        "| %-16s | %-13d | %-7d %-12s | %n",
        foundPlayer.getName(), foundPlayer.getNumWins(), foundPlayer.getBalance(), dollar);

    System.out.println("+==================+===============+======================+");
    System.out.println(" ");

    System.out.println("Press \"Enter\" to continue. . .");
    kb.nextLine();
  }

  /**
   * Method that asks the user who they want to bet on
   *
   * @return ans . char that is inputed by user
   */
  public char betOn() {

    System.out.println("Who do you want to bet on? \n");

    System.out.println("\t(P) Player Wins");
    System.out.println("\t(B) Banker Wins");
    System.out.println("\t(T) Tie Game \n");
    // asks user for input on who they want to bet on
    System.out.println("Enter your Choice: ");
    char ans = kb.nextLine().trim().toUpperCase().charAt(0);
    // input must be P, B or T
    while (ans != 'P' && ans != 'B' && ans != 'T') {
      System.out.println("Invalid choice");
      System.out.println("Enter your Choice: ");
      ans = kb.nextLine().trim().toUpperCase().charAt(0);
    }

    return ans;
  }

  /**
   * Method that returns the amount the user wants to bet on the game
   *
   * @return amnt . the amount bet on the game
   */
  public int betAmount() {
    String amount;
    int amnt = 0;
    int d = 0;
    boolean flag = false;

    System.out.println("How much do you want to bet this round? ");
    amount = kb.nextLine().trim();
    // validating input
    if (amount == null) {
      flag = false;
    }
    try {
      d = Integer.parseInt(amount);
    } catch (NumberFormatException nfe) {
      flag = false;
    }

    amnt = d;

    while (amnt == 0) {

      if (flag == false) {
        System.out.println("Enter a number!!");
        amount = kb.nextLine().trim();
        try {
          d = Integer.parseInt(amount);
        } catch (NumberFormatException nfe) {
          flag = false;
        }

        amnt = d;
      }
    }

    return amnt;
  }
  /** Method exits the game */
  public void exitGame() {
    System.exit(0);
  }
  /**
   * Method asks user if they want to play again
   *
   * @return ans . char that represents yes or no
   */
  public char playAgain() {

    char ans;
    System.out.println("Do you want to play again (Y/N)?");
    String text = kb.nextLine().trim();

    while (text.length() == 0) {
      System.out.println("Invalid Input");
      System.out.println("Do you want to play again (Y/N)?");
      text = kb.nextLine().trim();
    }
    ans = text.toUpperCase().charAt(0);
    // input must be Y or N
    while (ans != 'Y' && ans != 'N') {
      System.out.println("Invalid Input");
      System.out.println("Do you want to play again (Y/N)?");
      text = kb.nextLine().trim();
      ans = text.toUpperCase().charAt(0);
    }

    return ans;
  }
  /** Method that tells user that the name is not in file */
  public void printError() {
    System.out.println("That name does not exist.");
  }
  /**
   * Method that prints formatted list of punto banco game
   *
   * @param playerHand . players cards in hand
   * @param bankerHand . bankers cards in hand
   * @param playerSum . the sum of the players card in mod 10
   * @param bankerSum . the sum of the bankers cards in mod 10
   */
  public void printBox(
      ArrayList<Card> playerHand, ArrayList<Card> bankerHand, int playerSum, int bankerSum) {

    System.out.println("                 - PUNTO BANCO -               ");
    System.out.println("+=======================+=====================+");
    System.out.println("||PLAYER                |BANKER              ||");
    System.out.println("+=======================+=====================+");
    System.out.format("| %-21s | %-19s |%n", playerHand.get(0), bankerHand.get(0));
    System.out.println("+-----------------------+---------------------+");
    System.out.format("| %-21s | %-19s |%n", playerHand.get(1), bankerHand.get(1));
    System.out.println("+-----------------------+---------------------+");
    System.out.format("| %-21s | %-19s |%n", playerHand.get(2), bankerHand.get(2));
    System.out.println("+-----------------------+---------------------+");
    System.out.format("| PLAYER POINTS: %-6s | Banker POINTS:  %-2s  |%n", playerSum, bankerSum);
    System.out.println("+=======================+=====================+");
    System.out.println("");
  }

  /**
   * Method that shows if the play won/lose and how much they won/lose.
   *
   * @param text . value of either Win or Lose
   * @param stakes . the amount of money won or lost
   */
  public void printWinBox(String text, int stakes) {

    System.out.println("\t $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.format("\t $      PLAYER %4s %6d$     $%n", text, stakes);
    System.out.println("\t $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
  }

  /** this method prints a goodbye statement */
  public void printGoodbye() {
    System.out.println("Thank you for playing!\n");
  }

  /** this method prints a please leave message */
  public void printPleaseLeave() {
    System.out.println("You are out of money, please leave the Casino.\n");
  }
}
