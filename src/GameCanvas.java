import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {

    Image background;
   ArrayList<Enemy> enemyArrayList;
   Player player;
    int countEnemy =0;
    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    ImageUtil imageUtil;
     InputManager inputManager;

    public GameCanvas() {
        inputManager=new InputManager();
        player=new Player(300-32,500-40);
       player.inputManager=inputManager;
        enemyArrayList=new ArrayList<>();
        backBuffer=new BufferedImage(600,800, BufferedImage.TYPE_INT_ARGB);
        background=ImageUtil.LoadImage("images/background/background.png");
        backBufferGraphics=backBuffer.getGraphics();
    }

    protected void paintComponent(Graphics g){
       g.drawImage(backBuffer,0,0,null);

    }

    public void StopTheEnemy(){
        countEnemy++;
        if(countEnemy>70){
            Random rd=new Random();
            int x= rd.nextInt(600-64*2)+64;
            int y=-64;
            enemyArrayList.add(new Enemy(x,y));
            countEnemy=0;
        }
    }

    void update() {
        //Update player position
        player.run();
        //Update enemy pos
        for(Enemy e: enemyArrayList){
            e.run();
        }

        StopTheEnemy();
    }

    void render(){
        ImageUtil.DrawImage(backBufferGraphics,background,0,0);
        player.render(backBufferGraphics);
        for(Enemy e: enemyArrayList){
          e.render(backBufferGraphics);
        }

        this.repaint();
    }


}
