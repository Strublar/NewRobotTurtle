package NewRobotTurtle;

/**
 * Class ShootCard
 */
public class ShootCard extends Card {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public ShootCard (){
    cardName = "shootCard";
  };

  @Override
  public void effect(Turtle turtle) {
    turtle.shoot();
  }
}
