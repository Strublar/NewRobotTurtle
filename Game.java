package NewRobotTurtle;
import org.xguzm.pathfinding.*;

/**
 * Class Game
 */
public class Game {

  //
  // Fields
  //

  private int currentPlayer;

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

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

    public void wallTest(int playerNumber)
    {
        int turtleX = player.getturtle.getpositionX;
        int turtleY = player.getturtle.getpositionY;
        int joyeauX = 5
        int joyeauy = 5
        //these should be stored as [x][y]
        GridCell[][] cells = this.board;

        //create your cells with whatever data you need
        cells = createCells();

        //create a navigation grid with the cells you just created
        NavigationGrid<GridCell> navGrid = new NavigationGrid(cells);

         //create a finder
        AStarGridFinder<GridCell> finder = new AStarGridFinder(GridCell.class);

        List<GridCell> pathToEnd = finder.findPath(getpositionX, getpositionY, 4, 3, navGrid);
    }
}
