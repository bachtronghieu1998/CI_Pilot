package enemy;

import basis.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Enemy {
    Vector2D position;
    public ArrayList<EnemyBullet> enemyBullets;
     Image img;
     int count=30;

    public Enemy(int posX, int posY) {
        enemyBullets=new ArrayList<EnemyBullet>();
        position=new Vector2D(posX,posY);
        try {
            img= ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void LockBullet(){
        //Not add bullet if enemy go out of screen
        if(position.y>720){
            return;
        }
        count++;
        if(count>50){
            enemyBullets.add(new EnemyBullet((int)position.x+10,(int)position.y+20));
            count=0;
        }
//        System.out.println(position.y+" "+enemyBullets.size());
    }

    public void run(){
        Vector2D veclocity=new Vector2D();
       veclocity.y+=4;
       position.addUp(veclocity);
       for(EnemyBullet e:enemyBullets){
           e.run();
       }
       LockBullet();

    }

   public void render(Graphics g){
            g.drawImage(img,(int)position.x,(int)position.y,null);
       for(EnemyBullet e:enemyBullets){
           e.render(g);
       }
    }
}
