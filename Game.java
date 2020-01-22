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
  private String gameState;
  private Window window;


    //

  
  //
  // Methods
  //

    //
    // Constructors
    //
    public Game() {
        board = new char[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]=' ';

            }
        }

        board[2][3]='I';
        board[6][5]='S';
        board[3][7]='G';


        players = new Player[2];
        //TODO modifier ce qu'il y a en dessous
        players[0] = new Player(this);
        players[1] = new Player(this);
        players[0].setPlayerID(1);
        players[1].setPlayerID(2);
        currentPlayer = -1;

    }

    ;

    //
    // Methods
    //


  //
  // Accessor methodss
  //
    public Window getWindow() {
      return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

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

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    //
    // Other methods
    //

    /**
     *
     */
    public void startGame(int playerNumber) {
        System.out.println("ON cr�e une partie avec " + playerNumber + " joueurs");
        this.initGame();
    }


    /**
     *
     */
    private void initGame() {
        System.out.println("On initialise la partie");
        //TODO initialisation des variables de la partie


        System.out.println("D�but de la partie");
        this.distributeTurn();
    }


    /**
     *
     */
    public void distributeTurn() {

	System.out.println("On distribue le tour");
	currentPlayer ++;
	if(currentPlayer>=players.length)
	{
		currentPlayer = 0;
	}

	gameState = "Turn";
        players[currentPlayer].turn();
    }


    /**
     * @return boolean
     */




    public boolean wallTest(int xWall, int yWall) {
        this.map = this.board;

        //TODO: faire une boucle pour tout les joueurs

        int turtleX = Player.getturtle().positionX;
        int turtleY = Player.getturtle().positionY;
        //On commence par tester si l'emplacement est libre
        if (this.board[xWall][yWall] != ' ') {
            return false;
        }

        this.map[yWall][xWall] = 'w';

        int xMax = this.board[0].length - 1;
        int yMax = this.board.length - 1;

        //on prend comme coordonnées de départ celles de la tortue
        int x = turtleX;
        int y = turtleY;

        int nV = 0; //nVest le nombre de cases visités après la maj
        int nVBefore = 0; //nVest le nombre de cases visités la maj
        this.map[turtleY][turtleX] = 'v'; //la 1ere case visitée est celle sur laquelle est placé la tortue
        do {
            //affichage de la map pour les tests
            /*
            for (int k = 0; k <= yMax; k++) {
                System.out.print(this.map[k]);
                System.out.print("\n");
            } */

    nVBefore = nV;

            for (int i = 0; i <= yMax; i++) { //pour chaque ligne
        for (int j = 0; j <= xMax; j++) { //pour chaque colonne
            if (this.map[i][j] == 'v') { //si on est sur une case visitée
                int[] resMaj = majAdj(j, i); //on met a jour les cases adjacentes
                if (resMaj[0] == 1) { //si la mise à jour trouve la gemme on renvoie true
                    System.out.print("OK!");
                    return true;
                }
                nV = nV + resMaj[1];
            }
        }
    }
    //affichage  pour les tests
    //System.out.print("\n\n");
} while (nVBefore != nV);

        //si on sort de la boucle c'est que le nombre de sommet ne change plus, et donc qu'il n'y à pas de chemin possible
        System.out.print("Impossible !");
        return false;
        }

    //fonction permettant de mettre à jour les cases adjacentes à celle de coordonnée x,y
//renvoie un couple (win,nV) avec win prenant la valeur 1 si on à trouver la gemme et 0 sinon
//et nV le nombre de cases adjacentes changées en "sommet visité"
    private int[] majAdj(int x, int y) {
        int xMax = this.board[0].length - 1;
        int yMax = this.board.length - 1;

        int nV = 0;
        int n = 0;
        int m = 0;

        //boucle permettant de tester les 4 cases adjacentesà celle de coordonnées x,y
        for (int i = 1; i <= 4; i++) {

            if (i == 1) {
                n = 1;
                m = 0;
            } else if (i == 2) {
                n = -1;
                m = 0;
            } else if (i == 3) {
                n = 0;
                m = 1;
            } else if (i == 4) {
                n = 0;
                m = -1;
            }

            //on commence par tester si la coordonnée existe
            if ((x + n >= 0) && (y + m >= 0) && (x + n <= xMax) && (y + m <= yMax)) {
                if (this.map[y + m][x + n] == 'g') { //si oui et c'est la gemme, on renvoie "1"
                    return (new int[]{1, 0});
                } else if (this.map[y + m][x + n] == ' ') { //sinon si c'est une case vide on la marque comme "visitée"
                    this.map[y + m][x + n] = 'v';
                    nV = nV + 1;
                }
            }
        }
        //on renvoie 0 (car pas de gemmme trouvé) et le nombre de cases visitées ajoutés
        return (new int[]{0, nV});
    }
}

