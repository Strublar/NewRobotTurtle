package NewRobotTurtle;

/**
 * Class RightCard
 */
public class RightCard extends Card {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public RightCard (){
    cardName = "rightCard";
  };

  @Override
  public void effect(Turtle turtle) {
    turtle.right();
  }
  public String getCardName(){
      return this.cardName;
  }
}
