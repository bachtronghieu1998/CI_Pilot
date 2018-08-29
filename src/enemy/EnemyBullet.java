package enemy;

import basis.ImageRenderer;
import basis.Vector2D;

import java.awt.*;

public class EnemyBullet {
    Vector2D position;
    ImageRenderer img;
    public EnemyBullet(int x, int y) {
       position=new Vector2D(x,y);
       img=new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");

    }

    public void run(){
        Vector2D velocity=new Vector2D();
        velocity.y+=7;
        position.addUp(velocity);
    }

    public void render(Graphics g){
        img.render(g,position);
    }


}
