package NewRobotTurtle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class MouseListener
 */
public class Mousy implements MouseListener{

  //
  // Fields
  //
  private Window window;
  
  //
  // Constructors
  //
  public Mousy (Window newWindow) {
    this.window = newWindow;
  };
  
  //
  // Methods
  //
    /**
     * Invoked when the mouse is pressed and released rapidly
     * @param e 
     */
    public void mouseClicked(MouseEvent e){
        //System.out.println("mouse clicked at x:"+e.getX()+" y:"+e.getY());
    String state = this.window.getWindowState();
    if(state.equals("Menu"))
    {
      //Faire les tests relatifs aux menus
    }
    else if(state.equals("Choice"))
    {
      //Faire les tests relatifs au choix de l'action du tour du joueur
    }
    else if(state.equals("Turn"))
    {
      //Faire les tests relatifs au tour du jeu (choisir carte/clic sur le terrain
    }
    }
  
    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
    public void mousePressed(MouseEvent e){
        //System.out.println("mouse pressed at x:"+e.getX()+" y:"+e.getY());
    }
    
    
    /**
     * Invoked when a mouse button has been released on a component.
     * @param e the event to be processed
     */
    public void mouseReleased(MouseEvent e){
        //System.out.println("mouse released at x:"+e.getX()+" y:"+e.getY());
    }

    /**
     * Invoked when the mouse enters a component.
     * @param e the event to be processed
     */
    public void mouseEntered(MouseEvent e){
        //System.out.println("mouse entered");
    }

    /**
     * Invoked when the mouse exits a component.
     * @param e the event to be processed
     */
    public void mouseExited(MouseEvent e){
        //System.out.println("mouse exited");
    }
  
  //
  // Other methods
  //
  
}
