//Matteo est passé par là
package newrobotturtle;
import java.util.*;


/**
 * Class Game
 */
public class Game {

  //
  // Fields
  //

  private int currentPlayer;
  /**
   * tableau de joueurs
   */
  private Player[] players;
  /**
   * matrice de char
   */
  private char[][] board;
  
  //
  // Constructors
  //
  public Game () {
	  board = new char[8][8];
	  players = new Player[2];
	  //TODO modifier ce qu'il y a en dessous
	  players[0] = new Player();
	  players[1] = new Player();
	  players[0].setPlayerID(1);
	  players[1].setPlayerID(2);
	  currentPlayer = -1;
  };
  
  //
  // Methods
  //


  //
  // Accessor methodss
  //

  /**
   * Set the value of joueurEnCours
   * @param newVar the new value of joueurEnCours
   */
  private void setJoueurEnCours (int newVar) {
    currentPlayer = newVar;
  }

  /**
   * Get the value of joueurEnCours
   * @return the value of joueurEnCours
   */
  private int getJoueurEnCours () {
    return currentPlayer;
  }



  //
  // Other methods
  //

  /**
   */
  public void startGame(int playerNumber)
  {
	  System.out.println("ON crée une partie avec "+playerNumber+" joueurs");
	  this.initGame();
  }


  /**
   */
  private void initGame()
  {
	  System.out.println("On initialise la partie");
	  //TODO initialisation des variables de la partie
	  
	  
	  System.out.println("Début de la partie");
	  this.distributeTurn();
  }


  /**
   */
  private void distributeTurn()
  {
	System.out.println("On distribue le tour");
	currentPlayer ++;
	if(currentPlayer>=players.length)
	{
		currentPlayer = 0;
	}
	
	players[currentPlayer].turn();
  }


  /**
   * @return       boolean
   */
  private boolean testVictory()
  {
      return false;
  }


}
