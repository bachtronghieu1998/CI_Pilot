package players;

import basis.ImageRenderer;
import basis.Vector2D;

import java.awt.*;

public class PlayerBullet {
   Vector2D position;
     ImageRenderer img;

    public PlayerBullet(int x, int y) {
        position=new Vector2D(x,y);
        img=new ImageRenderer("images/bullet/player/mb69bullet1.png");

    }

    public PlayerBullet() {
    }

     public void run(){
          Vector2D velocity=new Vector2D();
           velocity.y-=8;
           position.addUp(velocity);
    }

    public void render(Graphics g){
           img.render(g,position);
    }
}
