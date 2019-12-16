package newrobotturtle;

/**
 * Class Turtle
 */
public class Turtle {

  //
  // Fields
  //

  private int spawnX;
  private int spawnY;
  private int positionX;
  private int positionY;
  private char direction;
  
  //
  // Constructors
  //
  public Turtle () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of spawnX
   * @param newVar the new value of spawnX
   */
  private void setSpawnX (int newVar) {
    spawnX = newVar;
  }

  /**
   * Get the value of spawnX
   * @return the value of spawnX
   */
  private int getSpawnX () {
    return spawnX;
  }

  /**
   * Set the value of spawnY
   * @param newVar the new value of spawnY
   */
  private void setSpawnY (int newVar) {
    spawnY = newVar;
  }

  /**
   * Get the value of spawnY
   * @return the value of spawnY
   */
  private int getSpawnY () {
    return spawnY;
  }

  /**
   * Set the value of positionX
   * @param newVar the new value of positionX
   */
  private void setPositionX (int newVar) {
    positionX = newVar;
  }

  /**
   * Get the value of positionX
   * @return the value of positionX
   */
  private int getPositionX () {
    return positionX;
  }

  /**
   * Set the value of positionY
   * @param newVar the new value of positionY
   */
  private void setPositionY (int newVar) {
    positionY = newVar;
  }

  /**
   * Get the value of positionY
   * @return the value of positionY
   */
  private int getPositionY () {
    return positionY;
  }

  /**
   * Set the value of direction
   * @param newVar the new value of direction
   */
  private void setDirection (char newVar) {
    direction = newVar;
  }

  /**
   * Get the value of direction
   * @return the value of direction
   */
  private char getDirection () {
    return direction;
  }

  //
  // Other methods
  //

  /**
   */
  public void forward()
  {
      System.out.println("turtle forward !");
  }


  /**
   */
  public void left()
  {
      System.out.println("turtle left !");
  }


  /**
   */
  public void right()
  {
      System.out.println("turtle right !");
  }


  /**
   */
  public void shoot()
  {
      System.out.println("turtle shoot !");
  }


  /**
   */
  public void respawn()
  {
      System.out.println("respawning turtle");
  }


  /**
   */
  public void uTurn()
  {
      System.out.println("turtle uturn");
  }


  /**
   * @return       boolean
   * @param        targetX
   * @param        targetY
   */
  public boolean testCollision(int targetX, int targetY)
  {
      System.out.println("testing collision with "+targetX+" and "+targetY);
      return false;
  }


}
