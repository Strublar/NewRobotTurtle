package NewRobotTurtle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Ariel Nora
 */
public class World extends JPanel{

    BufferedImage boardImage;
    BufferedImage turtleBeepImage, turtleDotImage, turtlePangleImage, turtlePiImage;
    ArrayList<BufferedImage> turtleImages;
    BufferedImage iceWallImage,iceWallMeltedImage, stoneWallImage, gemImage;
    BufferedImage cardBackImage, cardLeftImage, cardForwardImage, cardRightImage, cardShootImage;
    ArrayList<Color> colors;
    ArrayList<String> names;
    Game game;


    public World(Game game){
        this.game=game;
        try {
            gemImage = ImageIO.read(new File("images/gem.png"));
            boardImage = ImageIO.read(new File("images/board.png"));
            cardBackImage = ImageIO.read(new File("images/cardBack.png"));
            cardForwardImage = ImageIO.read(new File("images/cardForward.png"));
            cardRightImage = ImageIO.read(new File("images/cardRight.png"));
            cardLeftImage = ImageIO.read(new File("images/cardLeft.png"));
            cardShootImage = ImageIO.read(new File("images/cardShoot.png"));

            iceWallImage = ImageIO.read(new File("images/iceWall.png"));
            iceWallMeltedImage = ImageIO.read(new File("images/iceWallMelted.png"));
            stoneWallImage = ImageIO.read(new File("images/stoneWall.png"));
            turtleBeepImage = ImageIO.read(new File("images/turtleBeep.png"));
            turtleDotImage = ImageIO.read(new File("images/turtleDot.png"));
            turtlePangleImage = ImageIO.read(new File("images/turtlePangle.png"));
            turtlePiImage = ImageIO.read(new File("images/turtlePi.png"));

            turtleImages = new ArrayList();
            colors = new ArrayList();
            names = new ArrayList();
            turtleImages.add(turtleBeepImage);
            names.add("Beep");
            colors.add(new Color(47,84,115)); //blue
            turtleImages.add(turtlePangleImage);
            names.add("Pangle");
            colors.add(new Color(106,101,48)); //green
            turtleImages.add(turtleDotImage);
            names.add("Dot");
            colors.add(new Color(187,67,115)); //pink
            turtleImages.add(turtlePiImage);
            names.add("Pi");
            colors.add(new Color(151,15,44)); //red

            //test pour positionner les tortues
            
            game.getPlayers()[0].getTurtle().setPositionX(0);
            game.getPlayers()[0].getTurtle().setPositionY(2);
            game.getPlayers()[1].getTurtle().setPositionX(3);
            game.getPlayers()[1].getTurtle().setPositionY(1);
            

            assignTurtlesAndColors();

        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void assignTurtlesAndColors(){
        for(Player player : game.getPlayers()){
            int randomNum = ThreadLocalRandom.current().nextInt(0, this.turtleImages.size());
            player.getTurtle().setTurtleImage(turtleImages.get(randomNum));
            turtleImages.remove(randomNum);
            player.getTurtle().setColor(colors.get(randomNum));
            colors.remove(randomNum);
            player.getTurtle().setName(names.get(randomNum));
            names.remove(randomNum);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        Player current = game.getPlayers()[game.getCurrentPlayer()];
        /*
        current.getDeck();
        current.getGraveyard();
        current.getHand();
        current.getNbIceWall();
        current.getNbStoneWall();

        */
        //plateau de jeu
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1026, 1096);

        g.drawImage(boardImage, 8, 8, this);
        
        g.setColor(new Color(255,255,255,127));
        int x = 12, y=12;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                g.fillRect(x, y, 115, 115);
                y=y+115+4;
            }
            x=x+115+4;
            y=12;
        }

        drawBoard(g);

        drawTurtle(g);

        


        //partie joueur
        g.setColor(Color.darkGray);
        g.fillRect(1026, 0, 1000, 1096);
        
        /*
        //bouton option
        g.setColor(Color.lightGray);
        g.fillRect(1915-12-40, 12, 40, 40);
        */


        //murs
        drawWalls(g,current);

        //nom joueur
        drawName(g,current);
        
        //deck de pioche et defausse
        drawDecks(g,current);

/*
        //bouton discard utilisé que dans la phase 5
        g.fillRect(1026+12+(160+4)*4+15, 146-40+250, 115, 40);
*/  
        
        drawEndTurn(g,current);


        //main du joueur
        g.fillRect(1026+12, 146+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*1, 146+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*2, 146+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*3, 146+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*4, 146+250+15, 160, 250);


        //commandes du joueur
        g.fillRect(1026+12, 146+250+15+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*1, 146+250+15+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*2, 146+250+15+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*3, 146+250+15+250+15, 160, 250);
        g.fillRect(1026+12+(160+4)*4, 146+250+15+250+15, 160, 250);

        drawHandAndBench(g,current);
        
        drawPhase(g,current);
        
        super.repaint();

    }
    private void drawName(Graphics g,Player current){
        //1026+12+115+4+115+4+115+15
        g.setColor(current.getTurtle().getColor());
        g.fillRect(1026+12+115+4+115+4+115+15+115-10-25+12, 12, 1920-(1026+12+115+4+115+4+115+15+115-10)-12, 45);
        
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.setColor(Color.white);
        String phraseNom = "Joueur "+(game.getCurrentPlayer()+1)+" : "+current.getTurtle().getName();
        
        g.drawString(phraseNom,12+1026+12+115+4+115+4+115+15+115-25, 50-2);
        
        
        
    }
    
    private void drawEndTurn(Graphics g,Player current){
        
        g.setColor(new Color(100,72,44));
        //bouton fin du tour
        
        g.fillRect(1026+12+115+4+115+4+115+15+115-10-25, 12+40+10+5, 1920-(1026+12+115+4+115+4+115+15+115-10)-12+25, 50);
        g.setColor(Color.black);
        g.drawRect(1026+12+115+4+115+4+115+15+115-10-25, 12+40+10+5, 1920-(1026+12+115+4+115+4+115+15+115-10)-12+25, 50);
        g.drawRect(1026+12+115+4+115+4+115+15+115-10-25-1, 12+40+10+5-1, 1920-(1026+12+115+4+115+4+115+15+115-10)-12+25+2, 50+2);
        
        
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.setColor(Color.white);
        
        if(game.getGameState().equals("Turn")){ //bouton devient lancer commandes
            g.drawString("Executer programme", 1026+12+115+4+115+4+115+15+115-10-25+12, 12+40+10+40+3);
        }
        else if(game.getGameState().equals("AddCard")){ //bouton devient lancer commandes
            g.drawString("Compléter programme", 1026+12+115+4+115+4+115+15+115-10-25, 12+40+10+40+3);
        }
        else{ //bouton devient fin de tour
            g.drawString("Fin de tour", 1026+12+115+4+115+4+115+15+115-10+95-25+12, 12+40+10+40+3);
            
            
            g.setColor(new Color(100,72,44));
            g.fillRect(1026+12+115+4+115+4+115+15+115-10+45-25, 12+40+10+5+50, 1920-(1026+12+115+4+115+4+115+15+115-10)-12-90+25, 40);
            g.setColor(Color.black);
            g.drawRect(1026+12+115+4+115+4+115+15+115-10+45-25, 12+40+10+5+50, 1920-(1026+12+115+4+115+4+115+15+115-10)-12-90+25, 40);
            g.drawRect(1026+12+115+4+115+4+115+15+115-10+45-25-1, 12+40+10+5+50-1, 1920-(1026+12+115+4+115+4+115+15+115-10)-12-90+25+2, 40+2);
            
            g.setColor(Color.white);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g.drawString("et défausser le banc", 1026+12+115+4+115+4+115+15+115-10+46-25+12, 12+40+10+40+3+40);
            
        }
            g.setColor(Color.lightGray);
        
    }
    
    private void drawPhase(Graphics g,Player current){
        g.setColor(current.getTurtle().getColor());
        g.fillRect(1026+12,146+250+15+250+15+250+15,1920-(1026+12)-12,55);
        
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        
        game.getGameState();
        switch(game.getGameState()){
            case "Turn" :
                g.drawString("Faites votre choix", 1026+12+250+15, 146+250+15+250+15+250+15+40);
                break;
            case "AddCard" :
                g.drawString("Ajoutez des cartes au programme", 1026+12+112, 146+250+15+250+15+250+15+40);
                break;
            case "Discard" :
                g.drawString("Choisissez les cartes à défausser", 1026+12+125, 146+250+15+250+15+250+15+40);
                break;
            case "ChooseTile" :
                g.drawString("Choisissez la case pour le mur", 1026+12+200-35-5, 146+250+15+250+15+250+15+40);
                break;
            case "Menu" :
                //g.drawString("Faites votre choix", WIDTH, WIDTH);
                break;
            case "Victory" :
                //g.drawString("Victoire", WIDTH, WIDTH);
                break;
        }
        
    }
    
    
    private void drawBoard(Graphics g){
        int x, y;
        char[][] board = game.getBoard();
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                switch(board[i][j]){
                    case 'I': //icewall
                        x=12+(115+4)*i;
                        y=12+(115+4)*j;
                        g.drawImage(this.iceWallImage, x, y, this);
                        break;
                    case 'S': //stonewall
                        x=12+(115+4)*i;
                        y=12+(115+4)*j;
                        g.drawImage(this.stoneWallImage, x, y, this);
                        break;
                    case 'M': //melted icewall
                        x=12+(115+4)*i;
                        y=12+(115+4)*j;
                        g.drawImage(this.iceWallMeltedImage, x, y, this);
                        break;
                    case 'G': //gem
                        x=12+(115+4)*i;
                        y=12+(115+4)*j;
                        g.drawImage(this.gemImage, x, y, this);
                        break;
                }
            }
        }
    }
    private void drawTurtle(Graphics g){
        for(Player player : game.getPlayers()){
            Turtle turtle = player.getTurtle();
            g.drawImage(turtle.getTurtleImage(), 12+turtle.getPositionX()*(115+4), 12+turtle.getPositionY()*(115+4), this);
        }
    }
    private void drawHandAndBench(Graphics g,Player current){
        //dessin des cartes de la main
        for(int i=0;i<current.getHand().size();i++){
            if(getCardImage(current.getHand().get(i))!=null) g.drawImage(this.getCardImage(current.getHand().get(i)), 1026+12+(160+4)*i, 146+250+15, this);
        }
        //dessin des cartes sur le banc
        for(int i=0;i<current.getBench().size();i++){
            g.drawImage(this.getCardImage(current.getBench().get(i)), 1026+12+(160+4)*i, 146+250+15+250+15, this);
        }
    }


    private void drawDecks(Graphics g, Player current){
        g.setColor(Color.lightGray);
        g.fillRect(1026+12, 146, 160, 250); //deck de pioche
        g.fillRect(1026+12+(160+4)*2, 146, 160, 250); //deck de défausse
        g.fillRect(1026+12+(160+4)*4, 146, 160, 250); //commandes

        if(current.getDeck().isEmpty()){
            //deck vide donc on met rien
        }
        else{
            //deck pas vide donc on met un dos de carte
            g.drawImage(this.cardBackImage,1026+12,146,this);
        }

        if(current.getGraveyard().isEmpty()){
            //défausse vide donc on met rien
        }
        else{
            //défausse pas vide donc on met l'image de la dernière carte
            g.drawImage(getCardImage(current.getGraveyard().get(current.getGraveyard().size()-1)),1026+12+(160+4)*2,146,this);
        }
        
        if(current.getProgram().isEmpty()){
            //commandes vides donc on met rien
        }
        else{
            //commandes pas vides donc on met un dos de carte
            g.drawImage(this.cardBackImage,1026+12+(160+4)*4,146,this);
        }
        
    }

    private void drawWalls(Graphics g, Player current){
        g.setColor(Color.lightGray);
        g.drawImage(stoneWallImage, 1026+12, 12, this);

        g.setColor(Color.red);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        char [] numberWall = { 'x',Character.forDigit(current.getNbStoneWall(), 10) };
        g.drawChars(numberWall, 0, 2, 1026+12+115, 90);

        g.drawImage(iceWallImage, 1026+12+115+4+115+4+15-25, 12, this);
        char [] numberIce = { 'x',Character.forDigit(current.getNbIceWall(), 10) };
        g.drawChars(numberIce, 0, 2, 1026+12+115+4+115+4+115+15-25, 90);
        
        //murs sélectionnés
        g.setColor(Color.cyan);
        if(game.getGameState().equals("ChooseTile")){
            if(current.getSelectedWall()=='S'){
                g.drawRect(1026+12, 12, 115, 115);
                g.drawRect(1026+12-1, 12-1, 115+2, 115+2);
            }
            else if(current.getSelectedWall()=='I'){
                g.drawRect(1026+12+115+4+115+4+15-25, 12, 115, 115);
                g.drawRect(1026+12+115+4+115+4+15-25-1, 12-1, 115+2, 115+2);
            }
        }
    }

    private BufferedImage getCardImage(Card card){
        if(card!=null){
            switch(card.getCardName()){
                case "leftCard" :
                    return this.cardLeftImage;
                case "rightCard" :
                    return this.cardRightImage;
                case "shootCard" :
                    return this.cardShootImage;
                case "forwardCard" :
                    return this.cardForwardImage;
                default :
                    return gemImage; //retourne une image gemme, comme ça ce sera simple à voir si ya un bug
            }
        }
        else{
            return null; //eh ya rien
        }
    }



}