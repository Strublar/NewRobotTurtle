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
  };

  @Override
  public void effect(Turtle turtle) {
    turtle.right();
  }
}
