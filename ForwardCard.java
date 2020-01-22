package NewRobotTurtle;

/**
 * Class ForwardCard
 */
public class ForwardCard extends Card {

  //
  // Fields
  //

  
  //
  // Constructors
  //

  public ForwardCard(){
    cardName = "forwardCard";
  }

  @Override
  public void effect(Turtle turtle) {
    //faire avancer la tortue
    turtle.forward();
  }
}
