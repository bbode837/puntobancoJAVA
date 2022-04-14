package mru.game.model;

/**
 * Player Class
 *
 * @author scott and brandon
 */
public class Player {

  // Declaring instance variables
  private String name;
  private int balance;
  private int numWins;

  /** default constructor used for testing */
  public Player() {}

  /**
   * paramaterized constructor used to create a new player
   *
   * @param name name of new player
   */
  public Player(String name) {
    this.name = name.toUpperCase();
    this.balance = 100;
    this.numWins = 0;
  }

  /**
   * paramaterized constructor used for existing players
   *
   * @param name player name
   * @param balance balance
   * @param wins number of wins
   */
  public Player(String name, int balance, int wins) {
    this.name = name.toUpperCase();
    this.balance = balance;
    this.numWins = wins;
  }

  /**
   * name getter
   *
   * @return name user name
   */
  public String getName() {
    return name;
  }

  /**
   * balance getter
   *
   * @return balance user balance
   */
  public int getBalance() {
    return balance;
  }

  /**
   * numWins getter
   *
   * @return numWins number of wins
   */
  public int getNumWins() {
    return numWins;
  }

  /**
   * name setter
   *
   * @param name user name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * balance setter
   *
   * @param balance user balance
   */
  public void setBalance(int balance) {
    this.balance = balance;
  }

  /**
   * numWins setter
   *
   * @param numWins number of wins
   */
  public void setNumWins(int numWins) {
    this.numWins = numWins;
  }

  /**
   * toString Player helper method
   *
   * @return formated string for fileWriting
   */
  public String format() {
    return name + ";" + balance + ";" + numWins;
  }
}
