package NewRobotTurtle;

/**
 * Class LeftCard
 */
public class LeftCard extends Card {

  //
  // Fields
  //

  //
  // Constructors
  //
  public LeftCard (){
    cardName = "leftCard";
  }

  @Override
  public void effect(Turtle turtle) {
    turtle.left();
  }


}
