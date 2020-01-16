package NewRobotTurtle;

import javax.swing.JFrame;

/**
 * Class Window
 */
public class Window extends JFrame{

  //
  // Fields
  //
  World world;
  Mousy mousy;
  String windowState;
  
  //
  // Constructors
  //
  public Window (String newWindowState, Game game) {
        this.setTitle("jeu");
        //this.setSize(820+1100,820);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        world = new World();
        this.setContentPane(world);
        mousy = new Mousy(this,game);
        this.addMouseListener(mousy);
        
        //this.setUndecorated(true);
        this.setVisible(true);
        this.windowState = newWindowState;
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Mousy getMousy() {
        return mousy;
    }

    public void setMousy(Mousy mousy) {
        this.mousy = mousy;
    }

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
