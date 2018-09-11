package enemy;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import players.Player;

public class EnemyBullet extends GameObject {

    public EnemyBullet(int x, int y) {
        super(x,y);
       renderer =new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
       this.boxCollider=new BoxCollider(x,y,30,25);
    }

    public void run(){
        super.run();
        move();
        hitPlayer();

    }

    private void hitPlayer() {
       Player player= GameObject.checkCollision(this.boxCollider,Player.class);
       if(player!=null){
//           player.isActive=false;
           this.isActive=false;
       }
    }


    private void move() {
        Vector2D velocity=new Vector2D();
        velocity.y+=7;
        position.addUp(velocity);
    }


}
