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

  //
  // Constructors
  //
  public Window (String newWindowState, Game game) {
        this.setTitle("jeu");
        //this.setSize(820+1100,820);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        world = new World(game);
        this.setContentPane(world);
        mousy = new Mousy(this,game);
        this.addMouseListener(mousy);
        
        //this.setUndecorated(true);
        this.setVisible(true);
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
