package NewRobotTurtle;

/**
 * Class ShootCard
 */
public class ShootCard extends Card {

  //
  // Fields
  //
   private String cardName;

  
  //
  // Constructors
  //
  public ShootCard (){
    //TODO faire tirer la tortue, et différencier les cas selon l'objet en face (vide/mure de pierre,tortue,mure de glace,joyeau)
    cardName = "shootCard";
  };

  public String getCardName(){
      return this.cardName;
  }
}
