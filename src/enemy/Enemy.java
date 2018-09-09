package enemy;

import bases.*;

import java.awt.*;
import java.util.ArrayList;


public class Enemy extends GameObject {

     int count=30;
     FrameCounter counter;

    public Enemy(int x, int y) {
        super(x, y);
        imageRenderer=new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        counter=new FrameCounter(50);
        counter.count=30;
        this.boxCollider=new BoxCollider(x,y,30,30);
    }



    public void LockBullet(){
        //Not add bullet if enemy go out of screen
        if(position.y>720){
            return;
        }

        if(counter.expired){
            GameObject.add(new EnemyBullet((int)position.x,(int)position.y));
            counter.reset();
        }else{
            counter.run();
        }

    }

    public void run(){
        super.run();
        Vector2D veclocity=new Vector2D();
       veclocity.y+=2;
       position.addUp(veclocity);
       LockBullet();

    }

   public void render(Graphics g){
        super.render(g);

    }

    public void getHit(){
        this.destroy();
    }
}
