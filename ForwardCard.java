package NewRobotTurtle;

/**
 * Class ForwardCard
 */
public class ForwardCard extends Card {

  //
  // Fields
  //
   private String cardName;

  
  //
  // Constructors
  //
  public ForwardCard(){
    //TODO faire avancer la tortue, et verifier si le déplacement est possible
    System.out.println("Carte avancer");
    cardName = "forwardCard";
  }

  public String getCardName(){
      return this.cardName;
  }
}
