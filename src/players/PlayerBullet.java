package players;

import bases.*;
import enemy.Enemy;

public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y) {
        super(x, y);
        this.renderer =new Animation(
                5,false,
                ImageUtil.LoadImage("images/bullet/player/mb69bullet1.png"),
                ImageUtil.LoadImage("images/bullet/player/mb69bullet2.png"),
                ImageUtil.LoadImage("images/bullet/player/mb69bullet3.png"),
                ImageUtil.LoadImage("images/bullet/player/mb69bullet4.png")
        );
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
