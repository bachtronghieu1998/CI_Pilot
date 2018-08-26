import java.awt.*;
import java.util.ArrayList;

public class PlayerBullet {
   Vector2D position;
     Image img;

    public PlayerBullet(int x, int y) {
        position=new Vector2D(x,y);
        this.img=ImageUtil.LoadImage("images/bullet/player/mb69bullet1.png");
    }

    public PlayerBullet() {
    }

     public void run(){
          Vector2D velocity=new Vector2D();
           velocity.y-=7;
           position.addUp(velocity);
    }

     void render(Graphics g){
            g.drawImage(img,(int)position.x,(int)position.y,null);
    }
}
