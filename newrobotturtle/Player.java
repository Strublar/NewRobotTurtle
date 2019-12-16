package newrobotturtle;
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
    ArrayList<Int> Coord = new ArrayList<Int>();
    cars.add(3);
    cars.add(2);
    //TODO vérifier si la case est valide, et renvoyer les coordonées
    System.out.println("Emplacement du mure choisis");
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
    System.out.println("Mure placé");
    //TODO placer le mure sur la carte
  }


  /**
   */
  private void addCard()
  {
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
  private Char chooseWall()
  {
    //TODO Choix du mure, et vérifier si il en reste
    System.out.println("Type de mure choisis");
    return ('I');
  }


  /**
   */
  private void chooseCard()
  {
  }


  /**
   * @param        card
   */
  private void addToProgram(Card card)
  {
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
