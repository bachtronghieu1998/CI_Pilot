import java.awt.*;
import java.util.ArrayList;

public class PlayerBullet {
    int x;
    int y;
     Image img;

    public PlayerBullet(int x, int y) {
        this.img=ImageUtil.LoadImage("images/bullet/player/mb69bullet1.png");
        this.x = x;
        this.y = y;
    }

    public PlayerBullet() {
    }

     public void run(){
            this.y-=5;
    }

     void render(Graphics g){
            g.drawImage(img,x,y,null);
    }
}
