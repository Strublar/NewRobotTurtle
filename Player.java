<<<<<<< HEAD
package NewRobotTurtle;

import java.util.*;


/**
 * Class Player
 */
public class Player {

  //
  // Fields
  //

  private int nbStoneWall;
  private int nbIceWall;
  /**
   * liste de char
   */
  private ArrayList deck;
  /**
   * liste de char
   */
  private ArrayList hand;
  /**
   * lsite de char
   */
  private ArrayList graveyard;
  /**
   * ArrayDeque de char
   */
  private ArrayList program;
  private Turtle turtle;

  private int playerID;

  //
  // Constructors
  //
  public Player () { };

  //
  // Methods
  //


  //
  // Accessor methods
  //


  public ArrayList getGraveyard() {
    return graveyard;
  }


  public int getPlayerID() {
    return playerID;
  }

  public void setPlayerID(int playerID) {
    this.playerID = playerID;
  }

  /**
   * Set the value of nbStoneWall
   * @param newVar the new value of nbStoneWall
   */
  private void setNbStoneWall (int newVar) {
    nbStoneWall = newVar;
  }

  /**
   * Get the value of nbStoneWall
   * @return the value of nbStoneWall
   */
  private int getNbStoneWall () {
    return nbStoneWall;
  }

  /**
   * Set the value of nbIceWall
   * @param newVar the new value of nbIceWall
   */
  private void setNbIceWall (int newVar) {
    nbIceWall = newVar;
  }

  /**
   * Get the value of nbIceWall
   * @return the value of nbIceWall
   */
  private int getNbIceWall () {
    return nbIceWall;
  }

  /**
   * Set the value of deck
   * liste de char
   * @param newVar the new value of deck
   */
  private void setDeck (ArrayList newVar) {
    deck = newVar;
  }

  /**
   * Get the value of deck
   * liste de char
   * @return the value of deck
   */
  private ArrayList getDeck () {
    return deck;
  }

  /**
   * Set the value of hand
   * liste de char
   * @param newVar the new value of hand
   */
  private void setHand (ArrayList newVar) {
    hand = newVar;
  }

  /**
   * Get the value of hand
   * liste de char
   * @return the value of hand
   */
  private ArrayList getHand () {
    return hand;
  }

  /**
   * Set the value of graveYard
   * lsite de char
   * @param newVar the new value of graveYard
   */
  private void setGraveyard (ArrayList newVar) {
    graveyard = newVar;
  }

  /**
   * Get the value of graveYard
   * lsite de char
   * @return the value of graveYard
   */
  private ArrayList getGraveYard () {
    return graveyard;
  }

  /**
   * Set the value of program
   * ArrayDeque de char
   * @param newVar the new value of program
   */
  private void setProgram (ArrayList newVar) {
    program = newVar;
  }

  /**
   * Get the value of program
   * ArrayDeque de char
   * @return the value of program
   */
  private ArrayList getProgram () {
    return program;
  }

  /**
   * Set the value of turtle
   * @param newVar the new value of turtle
   */
  private void setTurtle (Turtle newVar) {
    turtle = newVar;
  }

  /**
   * Get the value of turtle
   * @return the value of turtle
   */
  private Turtle getTurtle () {
    return turtle;
  }

  //
  // Other methods
  //

  /**
   */
  public void turn()
  {
	  System.out.println("Tour du joueur " + playerID);
	  //TODO Suite du tour
	  this.choiceTurn();
  }


  /**
   * retourne les positions X Y en array
   * @return       array
   */
  public ArrayList chooseTile()
  {
    ArrayList<Integer> Coord = new ArrayList<Integer>();
    //TODO vérifier si la case est valide, et renvoyer les coordonées
    System.out.println("Emplacement du mur choisis");
    return (Coord);
  }


  /**
   * pour le bug
   */
  public void chooseTarget()
  {
  }


  /**
   */
  public void drawCard()
  {
  }


  /**
   */
/*
  private void choiceTurn()
  {
	  System.out.println("Le joueur "+this.playerID+" fais sont choix");
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("1 : Poser un mur, 2 : ajouter des cartes au programme, 3: executer le programme");
	  int choix = scanner.nextInt();
	  switch(choix)
	  {
	     case 1:
	    	 chooseWall();
	    	 break;
	     case 2:
	    	 addCard();
	    	 break;
	     case 3:
	    	 executeProgram();
	    	 break;
	  }
  }
*/

  /**
   */


  private void placeWall(int[] coord,char wallType)
  {
    //char wallType = chooseWall();
    game.board[coord] = wallType;
    System.out.println("Mur placé");
  }


  /**
   */
  private void addCard()
  {
    //TODO ajout d'une carte
    //addToProgram(Card chooseCard());
  }


  /**
   */
  private void executeProgram()
  {
  }


  /**
   * @param        card
   */
  private void discard(Card card)
  {
  }


  /**
   */
 /* private char chooseWall()
  {
    //TODO Choix du mur, et vérifier si il en reste
    if (this.nbStoneWall == 0) && (this.nbIceWall == 0) {
      System.out.println("Plus aucun mur disponible!");
  } else {
    Window.setWindowState(String "WallChoice");
    char choix = mouseClicked();
    if (choix == "S") {
      this.nbStoneWall--;
      return choix;
    } else if (choix = "I"){
      this.nbIceWall--;
      return choix;
    } else if (choix = "E"){
      choiceTurn();
    }

  }
*/

  /**
   */
  private void chooseCard()
  {
    //TODO Choix de la carte et vérification si elle est dans la main
    System.out.println("Carte choisis");
   // return (new LeftCard());
  }


  /**
   * @param        card
   */
  private void addToProgram(Card card)
  {
    //TODO ajouter une carte au programme
    System.out.println("Carte ajoutée");
  }


  /**
   */
  private void shuffle()
  {
  }


  /**
   */
  private void fullHand()
  {
  }


}
=======
package NewRobotTurtle;

import java.util.*;


/**
 * Class Player
 */
public class Player {

  //
  // Fields
  //

  private int nbStoneWall;
  private int nbIceWall;
  /**
   * liste de char
   */
  private ArrayList deck;
  /**
   * liste de char
   */
  private ArrayList hand;
  /**
   * lsite de char
   */
  private ArrayList graveyard;
  /**
   * ArrayDeque de char
   */
  private ArrayList program;
  private Turtle turtle;

  private int playerID;
  private String playerState;

  //
  // Constructors
  //
  public Player () { };

  //
  // Methods
  //


  //
  // Accessor methods
  //


  public String getPlayerState() {
    return playerState;
  }

  public void setPlayerState(String playerState) {
    this.playerState = playerState;
  }

  public ArrayList getGraveyard() {
    return graveyard;
  }


  public int getPlayerID() {
    return playerID;
  }

  public void setPlayerID(int playerID) {
    this.playerID = playerID;
  }

  public int getNbIceWall() {
    return nbIceWall;
  }

  public void setNbIceWall(int nbIceWall) {
    this.nbIceWall = nbIceWall;
  }

  public int getNbStoneWall() {
    return nbStoneWall;
  }

  public void setNbStoneWall(int nbStoneWall) {
    this.nbStoneWall = nbStoneWall;
  }

  public ArrayList getDeck() {
    return deck;
  }

  public void setDeck(ArrayList deck) {
    this.deck = deck;
  }

  public ArrayList getHand() {
    return hand;
  }

  public void setHand(ArrayList hand) {
    this.hand = hand;
  }

  public void setGraveyard(ArrayList graveyard) {
    this.graveyard = graveyard;
  }

  public ArrayList getProgram() {
    return program;
  }

  public void setProgram(ArrayList program) {
    this.program = program;
  }

  public Turtle getTurtle() {
    return turtle;
  }

  public void setTurtle(Turtle turtle) {
    this.turtle = turtle;
  }
//
  // Other methods
  //

  /**
   */
  public void turn()
  {
	  System.out.println("Tour du joueur " + playerID);
	  //TODO Suite du tour
	  this.choiceTurn();
  }


  /**
   * retourne les positions X Y en array
   * @return       array
   */
  public ArrayList chooseTile()
  {
    ArrayList<Integer> Coord = new ArrayList<Integer>();
    //TODO vérifier si la case est valide, et renvoyer les coordonées
    System.out.println("Emplacement du mur choisis");
    return (Coord);
  }


  /**
   * pour le bug
   */
  public void chooseTarget()
  {
  }


  /**
   */
  public void drawCard()
  {
  }


  /**
   */
  private void choiceTurn()
  {
	  System.out.println("Le joueur "+this.playerID+" fais sont choix");
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("1 : Poser un mur, 2 : ajouter des cartes au programme, 3: executer le programme");
	  int choix = scanner.nextInt();
	  switch(choix)
	  {
	     case 1:
	    	 chooseWall();
	    	 break;
	     case 2:
	    	 addCard();
	    	 break;
	     case 3:
	    	 executeProgram();
	    	 break;
	  }
  }


  /**
   */
  private void placeWall()
  {
    chooseWall();
    chooseTile();
    System.out.println("Mur placé");
    //TODO placer le mur sur la carte
  }


  /**
   */
  private void addCard()
  {
    //TODO ajout d'une carte
    //addToProgram(Card chooseCard());
    this.playerState = "AddCard";
  }


  /**
   */
  private void executeProgram()
  {
  }


  /**
   * @param        card
   */
  private void discard(Card card)
  {
  }


  /**
   */
  private char chooseWall()
  {
    //TODO Choix du mur, et vérifier si il en reste
    System.out.println("Type de mur choisis");
    return ('I');
  }


  /**
   */
  private void chooseCard()
  {
    //TODO Choix de la carte et vérification si elle est dans la main
    System.out.println("Carte choisis");
   // return (new LeftCard());
  }


  /**
   * @param        card
   */
  private void addToProgram(Card card)
  {
    //TODO ajouter une carte au programme
    System.out.println("Carte ajoutée");
  }


  /**
   */
  private void shuffle()
  {
  }


  /**
   */
  private void fullHand()
  {
  }


}
>>>>>>> d7ba0b5a1a86f1e584b02c91b6d0b9b478e792dd
