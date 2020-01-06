package NewRobotTurtle;

import javax.swing.JFrame;

/**
 * Class Window
 */
public class Window extends JFrame{

  //
  // Fields
  //

  private String windowState;



  //
  // Constructors
  //
  public Window () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  public String getWindowState() {
    return windowState;
  }

  public void setWindowState(String windowState) {
    this.windowState = windowState;
  }


  //
  // Other methods
  //

  /**
   */
  public void createWindow()
  {
      System.out.println("Window created");
  }


  /**
   */
  public void updateBoard()
  {
      System.out.println("Board updated");
  }


  /**
   */
  public void updatePlayers()
  {
      System.out.println("Players updated");
  }


}
