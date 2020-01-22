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
    //System.out.println("mouse clicked at x:"+(e.getX()-8)+" y:"+(e.getY()-30));

  }

  /**
   * Invoked when a mouse button has been pressed on a component.
   * @param e the event to be processed
   */
  public void mousePressed(MouseEvent e){
    //System.out.println("mouse pressed at x:"+(e.getX()-8)+" y:"+(e.getY()-30));





    String state = this.game.getGameState();
    System.out.println("Etat de la variable : "+state);
    System.out.println("Coordonnées : "+(e.getX()-8)+" "+(e.getY()-30));
    if(state.equals("Turn"))
    {

      // WallChoice

      if ((e.getX()-8) >= 1026+12 && (e.getX()-8) <= 1026+12+115 && (e.getY()-30) >= 12 && (e.getY()-30) <= 12+115) {
        game.setGameState("ChooseTile");
        game.getPlayers()[game.getCurrentPlayer()].setSelectedWall('S');
        System.out.println("TEEEEEEEEEEEEEEEEEST 1");
      }
      if ((e.getX()-8) >= 1026+12+115+4+115+4+20 && (e.getX()-8) <= 1026+12+115+4+115+4+20+115 && (e.getY()-30) >= 12 && (e.getY()-30) <= 12+115)
      {
        game.setGameState("ChooseTile");
        game.getPlayers()[game.getCurrentPlayer()].setSelectedWall('I');
        System.out.println("TEEEEEEEEEEEEEEEEEST 2");
      }
    }
    //Choix de la case
    if(state.equals("ChooseTile")) {
      if ((e.getX()-8) >= 12 && (e.getX()-8) <= 12+(115+4)*8 && (e.getY()-30) >= 12 && (e.getY()-30) <= 12+(115+4)*8) {

        int x = ((e.getX()-8)-12)/(115+4);
        int y = ((e.getY()-30)-12)/(115+4);
        if(readPositionOnBoard((e.getX()-8),(e.getY()-30))) game.getPlayers()[game.getCurrentPlayer()].placeWall(x,y,game.getPlayers()[game.getCurrentPlayer()].getSelectedWall());
      }

    }

    //Ajouter une carte au programme
    if(state.equals("Turn") || state.equals("AddCard") || state.equals("Discard"))
    {

      int offsetX = 1026+12;
      int length = 160;
      int betweenX = 4;

      int offsetY =  146+250+15;
      int height = 250;
      for(int i=0;i<5;i++)
      {
        if((e.getX()-8)>= offsetX + i*(length+betweenX) && (e.getX()-8)<= offsetX + length + i*(length+betweenX))
        {
          if((e.getY()-30)>= offsetY && (e.getY()-30)<= offsetY+height)
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
      int offsetX = 1026+12;
      int length = 160;
      int betweenX = 4;

      int offsetY = 146+250+15+250+15;
      int height = 250;

      for(int i=0;i<5;i++)
      {
        if((e.getX()-8)>= offsetX + i*(length+betweenX) && (e.getX()-8)<= offsetX + length + i*(length+betweenX))
        {
          if((e.getY()-30)>= offsetY && (e.getY()-30)<= offsetY+height)
          {
            //Clic sur une carte à retirer du bench
            this.game.getPlayers()[this.game.getCurrentPlayer()].removeCardFromBench(i);

          }
        }
      }

      //Valider l'ajout de carte ou de la défausse
      offsetX = 1026+12+115+4+115+4+115+15+115-10-25;
      length = 1920-(1026+12+115+4+115+4+115+15+115-10)-12+25;

      offsetY = 12+40+10+5;
      height = 50;

      if((e.getX()-8)>= offsetX && (e.getX()-8)<= offsetX+length)
      {
        if((e.getY()-30) >= offsetY && (e.getY()-30) <= offsetY + height)
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




      //g.fillRect(1026+12+115+4+115+4+115+15+115-10-25, 12+40+10+5, 1920-(1026+12+115+4+115+4+115+15+115-10)-12+25, 50);
      //Valider la défausse
      int offsetX = 1026+12+115+4+115+4+115+15+115-10-25;
      int length = 1920-(1026+12+115+4+115+4+115+15+115-10)-12+25;

      int offsetY = 12+40+10+5;
      int height = 50;

      if((e.getX()-8)>= offsetX && (e.getX()-8)<= offsetX+length)
      {
        if((e.getY()-30) >= offsetY && (e.getY()-30) <= offsetY + height)
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
    //System.out.println("mouse released at x:"+(e.getX()-8)+" y:"+(e.getY()-30));
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
  /**
   * Lire quelle case a été cliquée sur le board
   * @param x
   * @param y
   */
  private boolean readPositionOnBoard(int x, int y){
    System.out.println("X : "+(x-8)+" Y : "+(y-8));
    int positionX = (x-8)/119, positionY = (y-8)/119, abscisseX = (x-8)%119, ordonneeY = (y-8)%119;
    System.out.println("position : "+positionX+" "+positionY);

    System.out.println("position mod : "+abscisseX+" "+ordonneeY);
    if((abscisseX>=1 && abscisseX<=4)||(ordonneeY>=1 && ordonneeY<=4)){
      System.out.println("dans la marge :(");
      return false;
    }
    else{
      System.out.println("dans la case ! :)");
      return true;
    }
  }

}