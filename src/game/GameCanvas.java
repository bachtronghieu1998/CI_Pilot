package game;

import bases.GameObject;
import input.InputManager;
import players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {


   Player player;
    Player player2;
    BufferedImage backBuffer;
    Graphics backBufferGraphics;
     InputManager inputManager;
     Background backGround;

    public GameCanvas() {
        backGround=new Background(0,0);
        GameObject.add(backGround);
        inputManager= InputManager.instance;
        player=new Player(200,500,"images/player/MB-69/player1.png",1);
//        player2=new Player(400,500,"images/player/MB-70/player1.png",2);
        GameObject.add(player);
//        GameObject.add(player2);
        backBuffer=new BufferedImage(600,800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics=backBuffer.getGraphics();
    }

    protected void paintComponent(Graphics g){
        g.drawImage(backBuffer,0,0,null);

    }



    void update() {
      GameObject.runAll();

    }

     public void render(){
        GameObject.renderAll(backBufferGraphics);
        this.repaint();
    }


}
