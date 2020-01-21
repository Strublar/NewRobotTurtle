package NewRobotTurtle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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
  private BufferedImage turtleImage;
  private Color color;
  
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
public void setTurtleImage(BufferedImage turtleImage){
    this.turtleImage=turtleImage;
}
public BufferedImage getTurtleImage(){
    return this.turtleImage;
}
public void setColor(Color color){
    this.color=color;
}
public Color getColor(){
    return this.color;
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
     * fonction pour tourner l'image lorsque la tortue tourne
     * @param img
     * @param angle
     * @return 
     */
    public  BufferedImage rotate(BufferedImage img, double angle){
        System.out.println("rotating");
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
               cos = Math.abs(Math.cos(Math.toRadians(angle)));

        int width = img.getWidth(null), height = img.getHeight(null);

        int newWidth = (int) Math.floor(width*cos + height*sin),
            newHeight = (int) Math.floor(height*cos + width*sin);

        BufferedImage bimg = new BufferedImage(newWidth, newHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bimg.createGraphics();

        g.translate((newWidth-width)/2, (newHeight-height)/2);
        g.rotate(Math.toRadians(angle), width/2, height/2);
        g.drawRenderedImage(img, null);
        g.dispose();

        return bimg;
    }

  /**
   */
  public void left()
  {
      System.out.println("turtle left !");
      this.turtleImage=rotate(this.turtleImage,90);
  }


  /**
   */
  public void right()
  {
      System.out.println("turtle right !");
      this.turtleImage=rotate(this.turtleImage,-90);
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
