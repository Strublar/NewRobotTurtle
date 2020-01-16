package NewRobotTurtle;


/**
 * Class Game
 */
public class Game {

  //
  // Fields
  //

  private int currentPlayer;
  private Player[] players;
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


    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    //
  // Other methods
  //

  /**
   */
  public void startGame(int playerNumber)
  {
	  System.out.println("ON cr�e une partie avec "+playerNumber+" joueurs");
	  this.initGame();
  }


  /**
   */
  private void initGame()
  {
	  System.out.println("On initialise la partie");
	  //TODO initialisation des variables de la partie
	  
	  
	  System.out.println("D�but de la partie");
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
