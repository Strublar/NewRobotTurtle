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

  private ArrayList<Card> deck;
  /**
   * liste de char
   */
  private Card[] hand;
  /**
   * lsite de char
   */
  private ArrayList<Card> graveyard;
  /**
   * ArrayDeque de char
   */
  private ArrayList<Card> program;
  private Turtle turtle;

  private int playerID;
  private String playerState;
  private Card selectedCard;
  //
  // Constructors
  //
  public Player () {
  nbStoneWall=5;
  nbIceWall=2;
  deck=new ArrayList();
  graveyard=new ArrayList();
  hand = new Card[5];
  program = new ArrayList();
  playerID = 1;
  playerState = "gné";
  selectedCard = null;
  
  };

  //
  // Methods
  //


  //
  // Accessor methods
  //



  public Card getSelectedCard() {
    return selectedCard;
  }

  public void setSelectedCard(Card selectedCard) {
    this.selectedCard = selectedCard;
  }

  public String getPlayerState() {
    return playerState;
  }

  public void setPlayerState(String playerState) {
    this.playerState = playerState;
  }

  public ArrayList<Card> getGraveyard() {

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

  public ArrayList<Card> getDeck() {
    return deck;
  }

  public void setDeck(ArrayList deck) {
    this.deck = deck;
  }

  public Card[] getHand() {
    return hand;
  }

  public void setHand(Card[] hand) {
    this.hand = hand;
  }

  public void setGraveyard(ArrayList graveyard) {
    this.graveyard = graveyard;
  }

  public ArrayList<Card> getProgram() {
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



  private void placeWall(int[] coord,char wallType) {
    if game.wallTest(coord) {
      game.board[coord] = wallType;
      System.out.println("Mur placé");
    } else{
      System.out.println("Emplacement non valide");
    }
  }


  /**
   */
  private void addCard()
  {
    //TODO ajout d'une carte

    this.playerState = "AddCard";

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





  public void chooseCard(int select)
  {
    System.out.println("Carte choisis");
    this.selectedCard = this.hand[select];
  }
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

  
*/



  public void addToProgram()
  {
    //TODO ajouter une carte au programme et la retirer de la main
    System.out.println("Carte ajoutée");
  }



  private void shuffle()
  {
  }


  private void fullHand()
  {
  }
}


