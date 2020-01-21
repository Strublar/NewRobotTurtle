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
            turtleImages.add(turtleBeepImage);
            colors.add(new Color(47,84,151)); //blue
            turtleImages.add(turtlePangleImage);
            colors.add(new Color(106,101,48)); //green
            turtleImages.add(turtleDotImage);
            colors.add(new Color(187,67,151)); //pink
            turtleImages.add(turtlePiImage);
            colors.add(new Color(201,51,44)); //red

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
        g.fillRect(0, 0, 820, 1000);

        g.drawImage(boardImage, 12, 12, this);

        g.setColor(new Color(255,255,255,127));
        int x = 17, y=17;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                g.fillRect(x, y, 95, 95);
                y=y+95+4;
            }
            x=x+95+4;
            y=17;
        }

        drawBoard(g);

        drawTurtle(g);




        //partie joueur
        g.setColor(Color.darkGray);
        g.fillRect(820, 0, 800, 1000);

        //bouton option
        g.setColor(Color.lightGray);
        g.fillRect(820+12+(135+4)*4+135-40, 12, 40, 40);



        //murs
        drawWalls(g,current);

        //deck de pioche et defausse
        drawDecks(g,current);

        g.setColor(Color.lightGray);
        //bouton fin du tour
        g.fillRect(820+12+(135+4)*4+15, 146, 120, 40);

        //bouton discard utilisé que dans la phase 5
        g.fillRect(820+12+(135+4)*4+15, 146-40+200, 120, 40);


        //main du joueur
        g.fillRect(820+12, 146+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*1, 146+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*2, 146+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*3, 146+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*4, 146+200+51, 135, 200);


        //commandes du joueur
        g.fillRect(820+12, 146+200+51+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*1, 146+200+51+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*2, 146+200+51+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*3, 146+200+51+200+51, 135, 200);
        g.fillRect(820+12+(135+4)*4, 146+200+51+200+51, 135, 200);

        drawHandAndBench(g,current);

        super.repaint();

    }
    private void drawBoard(Graphics g){
        int x, y;
        char[][] board = game.getBoard();
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                switch(board[i][j]){
                    case 'I': //icewall
                        x=17+(95+4)*i;
                        y=17+(95+4)*j;
                        g.drawImage(this.iceWallImage, x, y, this);
                        break;
                    case 'S': //stonewall
                        x=17+(95+4)*i;
                        y=17+(95+4)*j;
                        g.drawImage(this.stoneWallImage, x, y, this);
                        break;
                    case 'M': //melted icewall
                        x=17+(95+4)*i;
                        y=17+(95+4)*j;
                        g.drawImage(this.iceWallMeltedImage, x, y, this);
                        break;
                    case 'G': //gem
                        x=17+(95+4)*i;
                        y=17+(95+4)*j;
                        g.drawImage(this.gemImage, x, y, this);
                        break;
                }
            }
        }
    }
    private void drawTurtle(Graphics g){
        for(Player player : game.getPlayers()){
            Turtle turtle = player.getTurtle();
            g.drawImage(turtle.getTurtleImage(), 17+turtle.getPositionX()*(95+4), 17+turtle.getPositionY()*(95+4), this);
        }
    }
    private void drawHandAndBench(Graphics g,Player current){
        //dessin des cartes de la main
        for(int i=0;i<current.getHand().size();i++){
            if(getCardImage(current.getHand().get(i))!=null)g.drawImage(this.getCardImage(current.getHand().get(i)), 820+12+(135+4)*i, 146+200+51, this);
        }
        //dessin des cartes sur le banc
        for(int i=0;i<current.getBench().size();i++){
            g.drawImage(this.getCardImage(current.getBench().get(i)), 820+12+(135+4)*i, 146+200+51+200+51, this);
        }
    }


    private void drawDecks(Graphics g, Player current){
        g.setColor(Color.lightGray);
        g.fillRect(820+12, 146, 135, 200); //deck de pioche
        g.fillRect(820+12+(135+4)*2, 146, 135, 200); //deck de défausse

        if(current.getDeck().isEmpty()){
            //deck vide donc on met rien
        }
        else{
            //deck pas vide donc on met un dos de carte
            g.drawImage(this.cardBackImage,820+12,146,this);
        }

        if(current.getGraveyard().isEmpty()){
            //défausse vide donc on met rien
        }
        else{
            //défausse pas vide donc on met l'image de la dernière carte
            g.drawImage(getCardImage(current.getGraveyard().get(current.getGraveyard().size()-1)),820+12+(135+4)*2,146,this);
        }
    }

    private void drawWalls(Graphics g, Player current){
        g.setColor(Color.lightGray);
        g.drawImage(stoneWallImage, 820+12, 12, this);

        g.setColor(Color.red);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 95));
        char [] numberWall = { 'x',Character.forDigit(current.getNbStoneWall(), 10) };
        g.drawChars(numberWall, 0, 2, 820+12+95, 95);

        g.drawImage(iceWallImage, 820+12+95+4+95+4+20, 12, this);
        char [] numberIce = { 'x',Character.forDigit(current.getNbIceWall(), 10) };
        g.drawChars(numberIce, 0, 2, 820+12+95+4+95+4+95+20, 95);
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