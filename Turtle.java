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
  private char spawnDirection;
  private int positionX;
  private int positionY;
  private char direction;
  private Game game;
  private BufferedImage turtleImage;
  private Color color;
  private String name;
  //
  // Constructors
  //
  public Turtle (Game newGame) {
    game = newGame;
  }

  public Turtle(int spawnX, int spawnY, char spawnDirection, int positionX, int positionY, char direction, Game game) {
    this.spawnX = spawnX;
    this.spawnY = spawnY;
    this.spawnDirection = spawnDirection;
    this.positionX = positionX;
    this.positionY = positionY;
    this.direction = direction;
    this.game = game;
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  public BufferedImage getTurtleImage() {
    return turtleImage;
  }

  public void setTurtleImage(BufferedImage turtleImage) {
    this.turtleImage = turtleImage;
    this.turtleImage=rotate(this.turtleImage,180);
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }
  
  public String getName(){
      return name;
  }

  public void setName(String name){
      this.name=name;
  }
  
  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public char getSpawnDirection() {
    return spawnDirection;
  }

  public void setSpawnDirection(char spawnDirection) {
    this.spawnDirection = spawnDirection;
  }

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
    int targetX;
    int targetY;
    switch (direction)
    {
      case 'N' :
          //déplacement vers le haut
          targetX = positionX;
          targetY = positionY-1;
          move(targetX,targetY);
          break;
      case 'S' :
          //déplacement vers le bas
          targetX = positionX;
          targetY = positionY+1;
          move(targetX,targetY);
          break;
      case 'E':
          //déplacement vers la droite
          targetX = positionX+1;
          targetY = positionY;
          move(targetX,targetY);
          break;
      case 'W':
          //Déplacement vers la gauche
          targetX = positionX-1;
          targetY = positionY;
          move(targetX,targetY);
          break;
    }
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
      switch (direction)
      {
        case 'N' :
          direction = 'W';
          break;
        case 'S' :
          direction = 'E';
          break;
        case 'E':
          direction = 'N';
          break;
        case 'W':
          direction = 'S';
          break;
      }
      this.turtleImage=rotate(this.turtleImage,-90);
  }


  /**
   */
  public void right()
  {
      System.out.println("turtle right !");
    switch (direction)
    {
      case 'N' :
        direction = 'E';
        break;
      case 'S' :
        direction = 'W';
        break;
      case 'E':
        direction = 'S';
        break;
      case 'W':
        direction = 'N';
        break;
    }
    this.turtleImage=rotate(this.turtleImage,90);
  }


  /**
   */
  public void shoot()
  {
      System.out.println("turtle shoot !");
  }

  private void move(int targetX, int targetY)
  {
      if(testCollisionWithBorder(targetX,targetY))
      {
        respawn();
      }
      else if(testCollisionWithWall(targetX,targetY))
      {
        uTurn();
      }
      else if(testCollisionWithTurtle(targetX,targetY) != null)
      {
        testCollisionWithTurtle(targetX,targetY).respawn();
        respawn();
      }
      else
      {
        //pas de collision
        positionX = targetX;
        positionY = targetY;
      }
  }
  /**
   */
  public void respawn()
  {
    positionX = spawnX;
    positionY = spawnY;
    direction = spawnDirection;
  }


  /**
   */
  public void uTurn()
  {
    switch(direction)
    {
      case 'N':
        direction = 'S';
        break;
      case 'S':
        direction = 'N';
        break;
      case 'E' :
        direction = 'W';
        break;
      case 'W':
        direction = 'E';
        break;
    }

  }


  /**
   * @return       boolean
   * @param        targetX
   * @param        targetY
   */
  public boolean testCollisionWithWall(int targetX, int targetY)
  {
      
      System.out.println("targetX : "+targetX);
      System.out.println("targetY : "+targetY);
      
      if(game.getBoard()[targetX][targetY] == 'I' || game.getBoard()[targetX][targetY] == 'S')
      {
        return true;
      }
      else
      {
        return false;
      }

  }

  public boolean testCollisionWithBorder(int targetX, int targetY)
  {
    //collision avec la bordure
    if(targetX<0 || targetX>7 || targetY<0 || targetY >7)
    {
      return true;
    }
    else
    {
      return false;
    }

  }

  public Turtle testCollisionWithTurtle(int targetX, int targetY)
  {
    for(int i=0;i<game.getPlayers().length;i++)
    {
      if(game.getPlayers()[i].getTurtle().getPositionX()==targetX
              && game.getPlayers()[i].getTurtle().getPositionY()==targetY)
      {
        return game.getPlayers()[i].getTurtle();
      }
    }
    return null;
  }



}
