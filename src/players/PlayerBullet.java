package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import enemy.Enemy;

public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y,String url) {
        super(x, y);
        this.renderer =new ImageRenderer(url);
        this.boxCollider=new BoxCollider(x,y,10,20);
    }


     public void run(){
          super.run();
         move();
         hitEnemies();
         deactiveIfNeeded();
    }

    public void deactiveIfNeeded(){
        if(position.y<0){
            this.isActive=false;
        }
    }

    private void hitEnemies() {
       Enemy enemy= GameObject.checkCollision(this.boxCollider,Enemy.class);
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
