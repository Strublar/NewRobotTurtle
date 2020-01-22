package NewRobotTurtle;


/**
 * Class Card
 */
public class Card {

  //
  // Fields
  //

  protected String cardName;
  
  //
  // Constructors
  //

  public Card(){
      cardName = "default";
  }
  public Card(int maxNumber) {
    cardName = "default";
  }

  //
  // Methods
  //


  //
  // Accessor methods
  //


  public String getCardName(){
      return this.cardName;
  }


  //
  // Other methods
  //

  /**
   */
  public void effect(Turtle turtle)
  {
  }


}
