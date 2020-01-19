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
    private char[][] map;
    //
    // Constructors
    //
    public Game() {
        board = new char[8][8];
        players = new Player[2];
        //TODO modifier ce qu'il y a en dessous
        players[0] = new Player();
        players[1] = new Player();
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

    public char[][] getBoard() {
        return this.board;
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

    //

    /**
     * Set the value of joueurEnCours
     *
     * @param newVar the new value of joueurEnCours
     */
    private void setJoueurEnCours(int newVar) {
        currentPlayer = newVar;
    }

    /**
     * Get the value of joueurEnCours
     *
     * @return the value of joueurEnCours
     */
    private int getJoueurEnCours() {
        return currentPlayer;
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
    private void distributeTurn() {
        System.out.println("On distribue le tour");
        currentPlayer++;
        if (currentPlayer >= players.length) {
            currentPlayer = 0;
        }

        players[currentPlayer].turn();
    }


    /**
     * @return boolean
     */
    private boolean testVictory() {
        return false;
    }



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

        int xMax = this.board[0].length-1;
        int yMax = this.board.length-1;

        int x = turtleX;
        int y = turtleY;

        int tileCounter = 0;
        int scearch = ' ';
        int nV = 0;
        this.map[turtleY][turtleX] = 'v';
        while (true) {
            for (int k = 0; k <= yMax; k++) {
                System.out.print(this.map[k]);
                System.out.print("\n");
            }

            int nVBefore = nV;

            for (int i = 0; i <= yMax; i++) {
                for (int j = 0; j <= xMax; j++) {
                    if (this.map[i][j] == 'v') {
                        int[] resMaj = majAdj(j, i);
                        if (resMaj[0] == 1) {
                            System.out.print("OK!");
                            return true;
                        }
                        nV = nV + resMaj[1];
                    }
                }
            }

            if (nVBefore == nV) {
                break;
            }
            System.out.print("\n\n");
        }
        System.out.print("Impossible !");
        return false;
    }

    private int[] majAdj(int x, int y) {
        int xMax = this.board[0].length-1;
        int yMax = this.board.length-1;

        int nV = 0;
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

            if ((x + n >= 0) && (y + m >= 0) && (x + n <= xMax) && (y + m <= yMax)) {
                if (this.map[y + m][x + n] == 'g') {
                    return (new int[]{1, 0});
                } else if (this.map[y + m][x + n] == ' ') {
                    this.map[y + m][x + n] = 'v';
                    nV = nV + 1;
                }
            }
        }
        return (new int[]{0, nV});
    }
}
