package mru.game.controler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.model.PuntoBanco;
import mru.game.view.Menu;

/**
 * Controler for Punto Banco Game
 *
 * @author scott and Brandon
 */
public class Controler {

  /**
   * players holds the player data from CasinoInfo.txt gMenu calls the Menu print methods pb calls
   * methods from PuntoBanco currentPlayer is the current player
   */
  private final String FILE_PATH = "res/CasinoInfo.txt";

  ArrayList<Player> players;
  Menu gMenu;
  PuntoBanco pb;
  private Player currentPlayer;

  /**
   * constructor initiates the ArrayList, and Menu and PuntoBanco classes
   *
   * @throws Exception exception
   */
  public Controler() throws Exception {
    players = new ArrayList<>();
    gMenu = new Menu();
    pb = new PuntoBanco();

    loadData();
    launchApplication();
  }

  /**
   * this method loads data from CasinoInfo.txt
   *
   * @throws Exception exception
   */
  private void loadData() throws Exception {
    File db = new File(FILE_PATH);
    String currentLine;
    String[] splittedLine;

    if (db.exists()) {
      Scanner fileReader = new Scanner(db);
      while (fileReader.hasNextLine()) {
        currentLine = fileReader.nextLine();
        splittedLine = currentLine.split(";");
        Player p =
            new Player(
                splittedLine[0],
                Integer.parseInt(splittedLine[1]),
                Integer.parseInt(splittedLine[2]));
        players.add(p);
      }
      fileReader.close();
    }
  }

  /**
   * this method launches the application. Calls the Main Menu and processes user input.
   *
   * @throws Exception exception
   */
  private void launchApplication() throws Exception {

    boolean flag = true;
    char ans;

    while (flag) {
      ans = gMenu.printMenu();

      switch (ans) {
        case 'P':
          playGame();
          break;
        case 'S':
          search();
          break;
        case 'E':
          save();
          flag = false;
      }
    }
  }

  /**
   * this method writes the updated player data back to CasinoInfo.txt
   *
   * @throws IOException exception
   */
  private void save() throws IOException {
    File db = new File(FILE_PATH);
    PrintWriter pw = new PrintWriter(db);

    System.out.println("Saving");

    for (Player p : players) {
      pw.println(p.format());
    }

    pw.close();
  }

  /** This method processes subMenu */
  public void search() {
    boolean flag = true;
    Player ply;
    int highScore;

    while (flag) {

      // Print subMenu
      char ans = gMenu.printSubMenu();

      switch (ans) {

          // Top Score
        case 'T':
          ArrayList<Player> topPlayerList = new ArrayList<>();
          highScore = findTopScore();
          topPlayerList = findTopPlayers(highScore);
          gMenu.printTopPlayerMenu(topPlayerList);
          flag = false;
          break;

          // Search by Name
        case 'N':
          String name = gMenu.promptName();
          ply = searchByName(name);
          if (ply == null) {
            gMenu.printError();
          } else {
            gMenu.playerInfo(ply);
          }
          flag = false;
          break;

          // Go Back to Main Menu
        case 'B':
          flag = false;
          break;
        default:
          System.out.println("Invalid option");
      }
    }
  }

  /**
   * this method searches the ArrayList "players" by name
   *
   * @param name player name
   * @return ply the player found in the list
   */
  public Player searchByName(String name) {

    Player ply = null;
    for (Player p : players) {
      if (p.getName().equals(name)) {
        ply = p;
        break;
      }
    }
    return ply;
  }

  /**
   * this method finds the highest score from CasinoInfo.txt
   *
   * @return highScore the highest score
   */
  public int findTopScore() {

    int highScore;
    highScore = 0;
    for (Player p : players) {
      // checks if the player has a higher number of wins then the high score
      if (p.getNumWins() > highScore) {
        highScore = p.getNumWins();
      }
    }
    return highScore;
  }

  /**
   * this method finds the players with the highScore and puts them in an ArrayList
   *
   * @param highScore the highest score
   * @return topPlayers ArrayList of the top players
   */
  public ArrayList<Player> findTopPlayers(int highScore) {
    ArrayList<Player> topPlayers = new ArrayList<>();
    for (Player p : players) {
      if (p.getNumWins() == highScore) {
        topPlayers.add(p);
      }
    }
    return topPlayers;
  }

  /**
   * creates a new player in the database
   *
   * @param newName first name of the player being created
   * @return newPlayer with a new name
   */
  public Player createNew(String newName) {
    Player newPlayer = new Player(newName);
    players.add(newPlayer);

    return newPlayer;
  }

  /**
   * this method loads the player data and launches the PuntoBanco game
   *
   * @throws Exception exception
   */
  public void playGame() throws Exception {
    String searchName;
    PuntoBanco pb = new PuntoBanco();

    currentPlayer = null;

    // Prompting the user for their name
    searchName = gMenu.promptName();
    currentPlayer = searchByName(searchName);

    /*
     * if the name does not exist, create a new player.
     * if it does exist, set currentPlayer to the searched name
     */
    if (currentPlayer == null) {
      currentPlayer = createNew(searchName);
      gMenu.welcome(currentPlayer);
    } else {
      gMenu.welcomeBack(currentPlayer);
    }

    // Launch Punto Banco
    pb.launchGame(currentPlayer);
  }
}
