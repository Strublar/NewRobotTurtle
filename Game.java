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
  private char[][] map;
  private String gameState;
  private Window window;
  private int playerCount;


    //


  //
  // Methods
  //

    //
    // Constructors
    //
    public Game() {
        board = new char[8][8];
        players = new Player[1];
        players[0] = new Player(this);
        playerCount = 0;
        this.gameState="Menu";
    }

    

    //
    // Methods
    //


  //
  // Accessor methodss
  //
    public int getPlayerCount(){
        return this.playerCount;
    }
    public void setPlayerCount(int playerCount){
        this.playerCount = playerCount;
    }
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
    public void startGame(int playerCount) {
        switch(playerCount)
        {
            case 2:
                //définition des joueurs
                players = new Player[2];
                players[0] = new Player(this);
                players[1] = new Player(this);
                players[0].setPlayerID(1);
                players[1].setPlayerID(2);
                currentPlayer = -1;
                //placement des joueurs

                players[0].getTurtle().setSpawnX(1);
                players[0].getTurtle().setSpawnY(0);
                players[1].getTurtle().setSpawnX(5);
                players[1].getTurtle().setSpawnY(0);
                players[0].getTurtle().respawn();
                players[1].getTurtle().respawn();

                //Placement de la gemme
                board[3][7] = 'G';

                //placement des murs
                board[7][0] = 'S';
                board[7][1] = 'S';
                board[7][2] = 'S';
                board[7][3] = 'S';
                board[7][4] = 'S';
                board[7][5] = 'S';
                board[7][6] = 'S';
                board[7][7] = 'S';
                break;
            case 3:
                //définition des joueurs
                players = new Player[3];
                players[0] = new Player(this);
                players[1] = new Player(this);
                players[2] = new Player(this);

                players[0].setPlayerID(1);
                players[1].setPlayerID(2);
                players[2].setPlayerID(3);
                currentPlayer = -1;
                //placement des joueurs

                players[0].getTurtle().setSpawnX(0);
                players[0].getTurtle().setSpawnY(0);
                players[1].getTurtle().setSpawnX(3);
                players[1].getTurtle().setSpawnY(0);
                players[2].getTurtle().setSpawnX(6);
                players[2].getTurtle().setSpawnY(0);
                players[0].getTurtle().respawn();
                players[1].getTurtle().respawn();
                players[2].getTurtle().respawn();
                //Placement de la gemme
                board[0][7] = 'G';
                board[3][7] = 'G';
                board[6][7] = 'G';

                //placement des murs
                board[7][0] = 'S';
                board[7][1] = 'S';
                board[7][2] = 'S';
                board[7][3] = 'S';
                board[7][4] = 'S';
                board[7][5] = 'S';
                board[7][6] = 'S';
                board[7][7] = 'S';
                break;
            case 4:
                //définition des joueurs
                players = new Player[4];
                players[0] = new Player(this);
                players[1] = new Player(this);
                players[2] = new Player(this);
                players[3] = new Player(this);

                players[0].setPlayerID(1);
                players[1].setPlayerID(2);
                players[2].setPlayerID(3);
                players[3].setPlayerID(4);
                currentPlayer = -1;
                //placement des joueurs

                players[0].getTurtle().setSpawnX(0);
                players[0].getTurtle().setSpawnY(0);
                players[1].getTurtle().setSpawnX(2);
                players[1].getTurtle().setSpawnY(0);
                players[2].getTurtle().setSpawnX(5);
                players[2].getTurtle().setSpawnY(0);
                players[3].getTurtle().setSpawnX(7);
                players[3].getTurtle().setSpawnY(0);
                players[0].getTurtle().respawn();
                players[1].getTurtle().respawn();
                players[2].getTurtle().respawn();
                players[3].getTurtle().respawn();
                //Placement de la gemme
                board[1][7] = 'G';
                board[6][7] = 'G';

                break;
        }
        window.getWorld().assignTurtlesAndColors();
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



    public boolean wallCollisionTest(int xWall, int yWall) {

        for (Player player : players)
        {
            this.map = new char[8][8];
            int turtleX = player.getTurtle().getPositionX();
            int turtleY = player.getTurtle().getPositionY();

            if ( (this.board[xWall][yWall] != ' ') || ((xWall==turtleX)&& (yWall==turtleY)) ) {
                return false;
            }
        }
        return true;
    }

    public boolean wallPathTest(int xWall, int yWall) {

        if (this.board[xWall][yWall] != ' ') {
            return false;
        }


        for (Player player : players) {
            this.map = new char[8][8];

            System.out.print("\n");
            System.out.print("nouveau joueur");
            System.out.print("\n\n");

            int turtleX = player.getTurtle().getPositionX();
            int turtleY = player.getTurtle().getPositionY();

            //On commence par tester si l'emplacement est libre

            this.board[xWall][yWall] = 'w';

            int xMax = this.board[0].length - 1;
            int yMax = this.board.length - 1;

            //on prend comme coordonnées de départ celles de la tortue
            int x = turtleX;
            int y = turtleY;

            int nV = 0; //nVest le nombre de cases visités après la maj
            int nVBefore = 0; //nVest le nombre de cases visités la maj
            this.map[turtleX][turtleY] = 'v'; //la 1ere case visitée est celle sur laquelle est placé la tortue
            boolean possiblePath = false; //vartiable passant à true si il existe un chemin


            do {
                //si on à trouvé un chemin on sort de la boucle
                if (possiblePath) {
                    break;
                }

                nVBefore = nV;

                for (int i = 0; i <= xMax; i++) { //pour chaque ligne
                    //si on à trouvé un chemin on sort de la boucle
                    if (possiblePath) {
                        break;
                    }
                    for (int j = 0; j <= yMax; j++) { //pour chaque colonne
                        if (possiblePath) {
                            break;
                        }
                        if (this.map[i][j] == 'v') { //si on est sur une case visitée

                            //affichage de la map pour les tests
                            for (int k = 0; k <= xMax; k++) {
                                System.out.print(this.map[k]);
                                System.out.print("\n");
                            }
                            //affichage  pour les tests
                            System.out.print("\n\n");

                            int[] resMaj = majAdj(i, j); //on met a jour les cases adjacentes
                            if (resMaj[0] == 1) { //si la mise à jour trouve la gemme on renvoie true
                                System.out.print("Chemin OK!");
                                possiblePath=true;
                                break;
                            }
                            nV = nV + resMaj[1];
                        }
                    }
                }

            } while (nVBefore != nV);

            //si on à trouvé aucun chemin possible on retourne false
            if (possiblePath==false) {
                System.out.print("Aucun chemin !");
                return false;
            }
        }
        //si tout les joueurs peuvent accéder à la gemme
        return true;
    }

    //fonction permettant de mettre à jour les cases adjacentes à celle de coordonnée x,y
    //renvoie un couple (win,nV) avec win prenant la valeur 1 si on à trouver la gemme et 0 sinon
    //et nV le nombre de cases adjacentes changées en "sommet visité"
    private int[] majAdj(int x, int y) {
        int xMax = this.board[0].length - 1;
        int yMax = this.board.length - 1;

        int nV = 0;

        //boucle permettant de tester les 4 cases adjacentesà celle de coordonnées x,y
        int n = 0;
        int m = 0;
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
                if (this.board[x + n][y + m] == 'G') { //si oui et c'est la gemme, on renvoie "1"
                    return (new int[]{1, 0});
                } else if ((this.board[x + n][y + m] == ' ')&& (this.map[x + n][y + m]=='\u0000')) { //sinon si c'est une case vide on la marque comme "visitée"
                    this.map[x + n][y + m] = 'v';
                    nV = nV + 1;
                }
            }
        }
        //on renvoie 0 (car pas de gemmme trouvé) et le nombre de cases visitées ajoutés
        return (new int[]{0, nV});
    }
}