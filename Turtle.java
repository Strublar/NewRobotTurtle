package NewRobotTurtle;

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

  public int getSpawnX() {
    return spawnX;
  }

  public void setSpawnX(int spawnX) {
    this.spawnX = spawnX;
  }

  public int getSpawnY() {
    return spawnY;
  }

  public void setSpawnY(int spawnY) {
    this.spawnY = spawnY;
  }

  public int getPositionX() {
    return positionX;
  }

  public void setPositionX(int positionX) {
    this.positionX = positionX;
  }

  public int getPositionY() {
    return positionY;
  }

  public void setPositionY(int positionY) {
    this.positionY = positionY;
  }

  public char getDirection() {
    return direction;
  }

  public void setDirection(char direction) {
    this.direction = direction;
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
