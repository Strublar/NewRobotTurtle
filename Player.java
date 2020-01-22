package NewRobotTurtle;

import java.awt.*;
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
  private ArrayList<Card> deck;
  private ArrayList<Card> hand;
  private ArrayList<Card> bench;
  private ArrayList<Card> graveyard;
  private ArrayDeque<Card> program;
  private Turtle turtle;

  private int playerID;
  private String playerState;
  private Card selectedCard;
  private char selectedWall;
  private Game game;



  //
  // Constructors
  //
  public Player (Game newGame) {
    nbStoneWall=5;
    nbIceWall=2;
    deck=new ArrayList();
    graveyard=new ArrayList();
    hand = new ArrayList();
    program = new ArrayDeque<Card>();
    bench = new ArrayList();
    playerID = 1;
    selectedCard = null;
    game = newGame;
    turtle = new Turtle(0,0, 'S', 0, 0, 'S', game);

    //Deck initialisation
    int nbForward = 18;
    int nbLeftRight = 8;
    int nbLaser = 3;
    for(int i=0;i<nbForward;i++)
    {
      deck.add(new ForwardCard());
    }
    for(int i=0;i<nbLeftRight;i++)
    {
      deck.add(new RightCard());
      deck.add(new LeftCard());
    }
    for(int i=0;i<nbLaser;i++)
    {
      deck.add(new ShootCard());
    }

  }

  //
  // Methods
  //


  //
  // Accessor methods
  //

  public char getSelectedWall() {
    return selectedWall;
  }

  public void setSelectedWall(char selectedWall) {
    this.selectedWall = selectedWall;
  }

  public ArrayList<Card> getBench() {
    return bench;
  }

  public void setBench(ArrayList<Card> bench) {
    this.bench = bench;
  }


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

  public void setDeck(ArrayList<Card> deck) {
    this.deck = deck;
  }

  public ArrayList<Card> getHand() {
    return hand;
  }



  public void setGraveyard(ArrayList graveyard) {
    this.graveyard = graveyard;
  }

  public ArrayDeque<Card> getProgram() {
    return program;
  }

  public void setProgram(ArrayDeque program) {
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
	  fullHand();
      //game.getWindow().getWorld().drawHandAndBench(,this);
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
      if(deck.size()==0){
        shuffle();
      }

      if(deck.size()>0)
      {
        int index = (int) (Math.random()*deck.size());
        hand.add(deck.get(index));
        deck.remove(index);

      }


  }


  public void placeWall(int targetX, int targetY,char wallType) {

    if (game.wallCollisionTest(targetX, targetY)) {

      if (wallType=='S') {
        if (game.wallPathTest(targetX, targetY)) {

          char[][] newBoard = game.getBoard();
          newBoard[targetX][targetY] = wallType;
          game.setBoard(newBoard);
          System.out.println("Mur placé");
          game.setGameState("Discard");
        } else {
          System.out.println("Emplacement non valide");
        }

      } else {
        char[][] newBoard = game.getBoard();
        newBoard[targetX][targetY] = wallType;
        game.setBoard(newBoard);
        System.out.println("Mur placé");
        game.setGameState("Discard");
      }
    } else {
      System.out.println("Emplacement non valide");
    }
  }


  /**
   */
  private void addCard()
  {
    //TODO ajout d'une carte
  }


  /**
   */
  public void executeProgram()
  {
    while(program.size()>0)
    {
      program.getFirst().effect(turtle);
      program.pollFirst();

    }
    if(!game.getGameState().equals("Victory"))
    {
      game.setGameState("Discard");
    }


  }


  /**
   */
  public void discard()
  {
    for(int i=bench.size()-1;i>=0;i--)
    {
      graveyard.add(bench.get(i));
    }
    bench.clear();
    game.distributeTurn();
  }





  public void chooseCard(int select)
  {
    if(select<hand.size())
    {
      if(bench.size()>=1)
      {
        bench.add(null);
        for(int i=bench.size()-1;i>0;i--)
        {

          bench.set(i,bench.get(i-1));
        }
        bench.set(0,hand.get(select));
      }
      else
      {
        bench.add(hand.get(select));
      }
      hand.remove(select);
    }
    else
    {
      System.out.println("Cette carte n'existe pas");
    }


  }

  public void removeCardFromBench(int select) {
    if (select < bench.size()) {
      System.out.println(bench.size());
      hand.add(bench.get(select));
      bench.remove(select);
      if (bench.size() == 0) {
        game.setGameState("Turn");
      }
    } else {
      System.out.println("Cette carte n'existe pas");
    }
  }






  public void addToProgram()
  {
    for(int i=bench.size()-1;i>=0;i--)
    {
        program.addLast(bench.get(i));
    }
    bench.clear();
    game.setGameState("Discard");
  }



  private void shuffle()
  {
    deck = graveyard;
    graveyard.clear();
  }


  private void fullHand()
  {
    while(hand.size()!=5)
    {
      drawCard();
    }
    System.out.println("Main piochée, nombre de cartes : "+hand.size());
    for(int i=0;i<hand.size();i++)
    {
      System.out.println(hand.get(i).getCardName());
    }
  }



}