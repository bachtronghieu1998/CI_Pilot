import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {

    Image background;
    Image player;
   ArrayList<PlayerBullet> bs;
   ArrayList<Enemy> enemyArrayList;
    int  posX;
    int posY;
    boolean rightPressed=false;
    boolean leftPressed=false;
    boolean upPressed=false;
    boolean downPressed=false;
    boolean xPressed=false;

    boolean locked =false;
    int count =0;

    int countEnemy =0;
    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    public GameCanvas() {
        posY=500-40;
        posX=300-32;

        bs=new ArrayList<>();
        enemyArrayList=new ArrayList<>();

        backBuffer=new BufferedImage(600,800, BufferedImage.TYPE_INT_ARGB);

        try {
             background= ImageIO.read(new File("images/background/background.png"));
            player= ImageIO.read(new File("images/player/MB-69/player1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        backBufferGraphics=backBuffer.getGraphics();
    }

    protected void paintComponent(Graphics g){
       g.drawImage(backBuffer,0,0,null);

    }

    void KeyPress(KeyEvent e){
       if(e.getKeyCode()==KeyEvent.VK_RIGHT){
           rightPressed=true;
       }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
           leftPressed=true;
       }else if(e.getKeyCode()==KeyEvent.VK_UP){
           upPressed=true;
       }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
           downPressed=true;
       }else if(e.getKeyCode()==KeyEvent.VK_X){
           xPressed=true;
       }
    }

    void KeyRelease(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            upPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_X){
            xPressed=false;
        }
    }

    public void LockTheGun(){
        //Lock the player gun
        if(xPressed && !locked){
            PlayerBullet b3=new PlayerBullet();
            b3.x=posX;
            b3.y=posY;
            try {
                b3.img=ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bs.add(b3);
            locked =true;
        }
        if(locked){
            count++;
            if(count>20){
                count=0;
                locked =false;
            }
        }
    }

    public void StopTheEnemy(){
        countEnemy++;
        if(countEnemy>70){
            enemyArrayList.add(new Enemy());
            countEnemy=0;
        }
    }
    void update() {
        //Update player position
        if (rightPressed) {
            posX += 5;
        }
        if (leftPressed) {
            posX -= 5;
        }
        if (downPressed) {
            posY += 5;
        }
        if (upPressed) {
            posY -= 5;
        }
        //Update bullet pos
        for(PlayerBullet p: bs){
            p.y-=3;
        }
        //Update enemy pos
        for(Enemy e: enemyArrayList){
            e.posY+=3;
        }

        StopTheEnemy();
       LockTheGun();
    }



    void render(){
        backBufferGraphics.drawImage(background,0,0,null);
        backBufferGraphics.drawImage(player,posX,posY,null);
        for(Enemy e: enemyArrayList){
            backBufferGraphics.drawImage(e.img,e.posX,e.posY,null);
        }
        for(PlayerBullet p: bs){
            backBufferGraphics.drawImage(p.img,p.x,p.y,null);
        }
        this.repaint();
    }


}
