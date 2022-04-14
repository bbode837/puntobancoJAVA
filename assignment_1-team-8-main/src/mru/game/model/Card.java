package mru.game.model;

/**
 * This class represents an individual card
 *
 * @author scott and brandon
 */
public class Card {

  private int rank;
  private String suit;
  private int weight;

  /**
   * Constructs and individual card
   *
   * @param rank number associated with card name
   * @param suit suit of the card
   * @param weight value used to calculate point
   */
  public Card(int rank, String suit, int weight) {
    this.rank = rank;
    this.suit = suit;
    this.weight = weight;
  }

  /** Default constructor */
  public Card() {
    this.rank = 0;
    this.suit = " ";
    this.weight = 0;
  }

  /**
   * rank getter method
   *
   * @return rank
   */
  public int getRank() {
    return rank;
  }

  /**
   * rank setter method
   *
   * @param rank the rank to set
   */
  public void setRank(int rank) {
    this.rank = rank;
  }

  /**
   * suit getter method
   *
   * @return the suit
   */
  public String getSuit() {
    return suit;
  }

  /**
   * suit setter method
   *
   * @param suit the suit to set
   */
  public void setSuit(String suit) {
    this.suit = suit;
  }

  /**
   * weight getter method
   *
   * @return the weight
   */
  public int getWeight() {
    return weight;
  }

  /**
   * weight setter method
   *
   * @param weight the weight to set
   */
  public void setWeight(int weight) {
    this.weight = weight;
  }

  /**
   * This method overrides the toString method and shows the dat in the format we want
   *
   * @return name + suit. Creates a string of name + suit
   */
  public String toString() {

    String name = " ";

    if (rank >= 2 && rank <= 10) name = rank + " of ";
    else if (rank == 1) name = "Ace of ";
    else if (rank == 11) name = "Jack of ";
    else if (rank == 12) name = "Queen of ";
    else if (rank == 13) name = "King of ";
    else if (rank == 0) {
      name = " ";
      suit = " ";
    }

    return name + suit;
  }
}
