package enemy;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class EnemyBullet extends GameObject {

    public EnemyBullet(int x, int y) {
        super(x,y);
       imageRenderer=new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");

    }

    public void run(){
        Vector2D velocity=new Vector2D();
        velocity.y+=7;
        position.addUp(velocity);
    }


}
