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
  private Game game;
  
  //
  // Constructors
  //
  public Mousy (Window newWindow, Game newGame) {
    this.window = newWindow;
    this.game = newGame;
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

    }
  
    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
    public void mousePressed(MouseEvent e){
        //System.out.println("mouse pressed at x:"+e.getX()+" y:"+e.getY());
      String state = this.window.getWindowState();
      if(state.equals("Menu"))
      {

        // WallChoice

        if (e.getX() >= 820+12) && (e.getX() <= 820+12+95) && (e.getY() >= 12) && (e.getY() <= 12+95) {
          Window.setWindowState(String "ChooseTile");
          char wallType='S';
            Player.placeWall(wallType);
        } else if (e.getX() <= 820+12+95+4+95+4+20) && (e.getX() >= 820+12+95+4+95+4+20+95) && (e.getY() <= 12) && (e.getY() >= 12+95)  {
          Window.setWindowState(String "ChooseTile");
          char wallType='I';
            Player.placeWall(wallType);
        }
          // CardChoice

          else if (e.getX() >= 820+12) && (e.getX() <= 820+12+135) && (e.getY() >= 146+200+51) && (e.getY() <= 146+200+51+200) {
          return(1);
        } else if (e.getX() >= 820+12+(135+4)*1) && (e.getX() <= 820+12+(135+4)*1+135) && (e.getY() >= 146+200+51) && (e.getY() <= 146+200+51+200) {
          return(2);
        } else if (e.getX() >= 820+12+(135+4)*2) && (e.getX() <= 820+12+(135+4)*2+135) && (e.getY() >= 146+200+51) && (e.getY() <= 146+200+51+200) {
          return(3);
        } else if (e.getX() >= 820+12+(135+4)*3) && (e.getX() <= 820+12+(135+4)*3+135) && (e.getY() >= 146+200+51) && (e.getY() <= 146+200+51+200) {
          return(4);
        }else if (e.getX() >= 820+12+(135+4)*4) && (e.getX() <= 820+12+(135+4)*4+135) && (e.getY() >= 146+200+51) && (e.getY() <= 146+200+51+200) {
          return(5);
        }

          // Fin de tour

          else if (e.getX() >= 820+12+(135+4)*4+15) && (e.getX() <= 820+12+(135+4)*4+15+120) && (e.getY() >= 146) && (e.getY() <= 146+40)  {
            return (2);
          }
          // Défausse

          else if (e.getX() >= 820+12+(135+4)*1) && (e.getX() <= 820+12+(135+4)*1+135) && (e.getY() >= 146+200+51) && (e.getY() <= 146+200+51+200) {
            return(3);
          }
    }
      //Choix de la case
    else if(state.equals("ChooseTile")) {
      if (e.getX() >= 12) && (e.getX() <= 12+(95+4)*7) && (e.getY() >= 12) && (e.getY() <= 12+(95+4)*8) {
        int x = (e.getX()-12)/(95+4);
        int y = (e.getY()-12)/(95+4);
        return (x,y);
      }

      }
      else if(state.equals("Choice"))
      {
        //Faire les tests relatifs au choix de l'action du tour du joueur
      }
      else if(state.equals("Turn"))
      {
        //Faire les tests relatifs au tour du jeu (choisir carte/clic sur le terrain
        if(this.game.getPlayers()[this.game.getCurrentPlayer()].getPlayerState().equals("AddCard"))
        {
          int offsetX = 820+12;
          int length = 135;
          int betweenX = 4;

          int offsetY =  146 + 200 + 51;
          int height = 200;
          int betweenY = 200+51;
          for(int i=0;i<5;i++)
          {
            if(e.getX()>= offsetX + i*(length+betweenX) && e.getX()<= offsetX + length + i*(length+betweenX))
            {
              if(e.getY()>= offsetY && e.getY()<= offsetY+height)
              {
                //Clic sur une carte à ajouter

              }
              else if(e.getY()>= offsetY+betweenY && e.getY()<= offsetY+height+betweenY)
              {
                //Clic de validation
              }
            }
          }
        }
      }
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

    /*
      if (e.getX() >= 188+397) && (e.getX() <= 188+397+43) && (e.getY() >= 200+92) && (e.getY() <= 200+92+111) {
        return(2);
    } else if (e.getX() >= 188+397+150) && (e.getX() <= 188+397+150+73) && (e.getY() >= 200+92) && (e.getY() <= 200+92+111) {
      return(3);
    } else if (e.getX() >= 188+397+300) && (e.getX() <= 188+397+300+73) && (e.getY() >= 200+92) && (e.getY() <= 200+92+111) {
      return(4);
    } else if (e.getX() >= 188+369) && (e.getX() <= 188+369+428) && (e.getY() >= 200+227) && (e.getY() <= 200+227+54) {
      return(0);
    }
      //Faire les tests relatifs au menu
    }
    */

    /* else if(state.equals("Turn"))
    {
        if (e.getX() >=188+17) && (e.getX() <= 188+17+481) && (e.getY() >= 200+90) && (e.getY() <= 200+90+114) {
        return("placer mur");
      } else if (e.getX() <= 188+611) && (e.getX() >= 188+611+523) && (e.getY() <= 200+90) && (e.getY() >= 200+90+114) {
        return("jouer carte");
      } else if (e.getX() <= 188+198) && (e.getX() >= 188+198+749) && (e.getY() <= 200+181) && (e.getY() >= 200+181+114) {
        return("lancer commandes");
      } else if (e.getX() >= 188+403) && (e.getX() <= 188+403+339) && (e.getY() >= 200+317) && (e.getY() <= 200+317+54) {
          return("valide");
      }
        //Faire les tests relatifs au choix de l'action du tour du joueur
    } */
