package NewRobotTurtle;

/**
 *
 * @author Ariel Nora, Matteo Daluz, Thomas Hercule
 */
public class NewRobotTurtle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game= new Game();
        Window window = new Window("Menu", game);
        game.setWindow(window);
        game.startGame(menu.choosePlayersCount());
    }
    
}
