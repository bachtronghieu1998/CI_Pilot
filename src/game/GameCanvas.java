package game;

import basis.FrameCounter;
import basis.ImageUtil;
import enemy.Enemy;
import enemy.EnemyBullet;
import input.InputManager;
import players.Player;
import players.PlayerBullet;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {

    Image background;
   ArrayList<Enemy> enemyArrayList;
   Player player;
   FrameCounter countEnemy;
    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    ImageUtil imageUtil;
     InputManager inputManager;
    ArrayList<PlayerBullet> bullets;

    public GameCanvas() {
        bullets=new ArrayList<PlayerBullet>();

        inputManager= InputManager.instance;
        player=new Player(300-32,500-40);
        player.bullets=this.bullets;
        countEnemy=new FrameCounter(70);

        enemyArrayList=new ArrayList<>();
        backBuffer=new BufferedImage(600,800, BufferedImage.TYPE_INT_ARGB);
        background=ImageUtil.LoadImage("images/background/background.png");
        backBufferGraphics=backBuffer.getGraphics();
    }

    protected void paintComponent(Graphics g){
       g.drawImage(backBuffer,0,0,null);

    }

    public void StopTheEnemy(){
        if(countEnemy.expired){
            Random rd=new Random();
            int x= rd.nextInt(Setting.width-64*2)+64;
            int y=-64;
            enemyArrayList.add(new Enemy(x,y));
            countEnemy.reset();
        }else{
            countEnemy.run();
        }

    }

    void update() {
        //Update player position
        player.run();

        //Update Bullet
        for(PlayerBullet b:bullets){
            b.run();
        }

        //Update enemy pos
        for(Enemy e: enemyArrayList){
            e.run();
        }

        StopTheEnemy();
    }

     public void render(){
        ImageUtil.DrawImage(backBufferGraphics,background,0,0);
        player.render(backBufferGraphics);
        for(Enemy e: enemyArrayList){
          e.render(backBufferGraphics);
        }
        for(PlayerBullet p: bullets){
            p.render(backBufferGraphics);
        }

        this.repaint();
    }


}
