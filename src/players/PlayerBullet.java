package players;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y,String url) {
        super(x, y);
        this.imageRenderer=new ImageRenderer(url);
    }



     public void run(){
          super.run();
          Vector2D velocity=new Vector2D();
           velocity.y-=8;
           position.addUp(velocity);
    }


}
