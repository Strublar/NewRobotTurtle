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
