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
    String state = this.game.getGameState();
    System.out.println("Etat de la variable : "+state);
    System.out.println("Coordonnées : "+e.getX()+" "+e.getY());
    if(state.equals("Turn"))
    {

      // WallChoice

      if (e.getX() >= 820+12 && e.getX() <= 820+12+95 && e.getY() >= 12 && e.getY() <= 12+95) {
        game.setGameState("ChooseTile");
        game.getPlayers()[game.getCurrentPlayer()].setSelectedWall('S');
        System.out.println("TEEEEEEEEEEEEEEEEEST 1");
      }
      if (e.getX() >= 820+12+95+4+95+4+20 && e.getX() <= 820+12+95+4+95+4+20+95 && e.getY() >= 12 && e.getY() <= 12+95)
      {
        game.setGameState("ChooseTile");
        game.getPlayers()[game.getCurrentPlayer()].setSelectedWall('I');
        System.out.println("TEEEEEEEEEEEEEEEEEST 2");
      }
    }
      //Choix de la case
    if(state.equals("ChooseTile")) {
      if (e.getX() >= 12 && e.getX() <= 12+(95+4)*7 && e.getY() >= 12 && e.getY() <= 12+(95+4)*8) {
        int x = (e.getX()-12)/(95+4);
        int y = (e.getY()-12)/(95+4);
        game.getPlayers()[game.getCurrentPlayer()].placeWall(x,y,game.getPlayers()[game.getCurrentPlayer()].getSelectedWall());
      }

      }

      //Ajouter une carte au programme
      if(state.equals("Turn") || state.equals("AddCard") || state.equals("Discard"))
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
              this.game.getPlayers()[this.game.getCurrentPlayer()].chooseCard(i);
              if(!state.equals("Discard"))
              {
                  this.game.setGameState("AddCard");
              }
            }
          }
        }
      }

      //Retirer une carte du bench ou validation
      if(state.equals("AddCard") || state.equals("Discard"))
      {
        //Retirer une carte du bench
        int offsetX = 820+12;
        int length = 135;
        int betweenX = 4;

        int offsetY = 146+200+51+200+51;
        int height = 200;

        for(int i=0;i<5;i++)
        {
          if(e.getX()>= offsetX + i*(length+betweenX) && e.getX()<= offsetX + length + i*(length+betweenX))
          {
            if(e.getY()>= offsetY && e.getY()<= offsetY+height)
            {
              //Clic sur une carte à retirer du bench
              this.game.getPlayers()[this.game.getCurrentPlayer()].removeCardFromBench(i);

            }
          }
        }

        //Valider l'ajout de carte ou de la défausse
        offsetX = 820+12+(135+4)*4+15;
        length = 120;

        offsetY = 176;
        height = 40;

        if(e.getX()>= offsetX && e.getX()<= offsetX+length)
        {
          if(e.getY() >= offsetY && e.getY() <= offsetY + height)
          {
            if(state.equals("AddCard"))
            {
              this.game.getPlayers()[this.game.getCurrentPlayer()].addToProgram();
            }
            else
            {
              this.game.getPlayers()[this.game.getCurrentPlayer()].discard();
            }
          }
        }
      }



      //Executer le programme
      if(state.equals("Turn"))
      {
        //Valider la défausse
        int offsetX = 820+12+(135+4)*4+15;
        int length = 120;

        int offsetY = 176;
        int height = 40;

        if(e.getX()>= offsetX && e.getX()<= offsetX+length)
        {
          if(e.getY() >= offsetY && e.getY() <= offsetY + height)
          {
            this.game.getPlayers()[this.game.getCurrentPlayer()].executeProgram();
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
