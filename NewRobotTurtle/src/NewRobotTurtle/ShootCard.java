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
  };

  @Override
  public void effect(Turtle turtle) {
    turtle.shoot();
  }
}
