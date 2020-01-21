/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewRobotTurtle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    BufferedImage iceWallImage, stoneWallImage, gemImage;
    BufferedImage cardBackImage, cardLeftImage, cardForwardImage, cardRightImage, cardShootImage;
    
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
            stoneWallImage = ImageIO.read(new File("images/stoneWall.png"));
            turtleBeepImage = ImageIO.read(new File("images/turtleBeep.png"));
            turtleDotImage = ImageIO.read(new File("images/turtleDot.png"));
            turtlePangleImage = ImageIO.read(new File("images/turtlePangle.png"));
            turtlePiImage = ImageIO.read(new File("images/turtlePi.png"));
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        Player current = game.getPlayers()[game.getCurrentPlayer()];
        /*
        à récup :
        deck pioche
        deck défausse
        murs
        nom
        hand
        bench
        
        */
        current.getDeck();
        current.getGraveyard();
        current.getHand();
        current.getNbIceWall();
        current.getNbStoneWall();
        
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
            g.drawImage(getCardImage(current.getGraveyard().get(current.getGraveyard().size()-1)),820+12,146,this);
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