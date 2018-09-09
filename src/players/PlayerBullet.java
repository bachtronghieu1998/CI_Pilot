package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import enemy.Enemy;

import java.awt.*;

public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y,String url) {
        super(x, y);
        this.imageRenderer=new ImageRenderer(url);
        this.boxCollider=new BoxCollider(x,y,10,20);
    }


     public void run(){
          super.run();
         move();
         hitEnemies();
    }

    private void hitEnemies() {
       Enemy enemy= GameObject.checkCollision(this.boxCollider);
       if(enemy!=null){
           System.out.println("hit");
           enemy.getHit();
           this.destroy();
       }
    }

    private void move() {
        Vector2D velocity=new Vector2D();
        velocity.y-=8;
        position.addUp(velocity);
    }


}
