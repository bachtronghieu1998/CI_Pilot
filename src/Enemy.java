import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    Vector2D position;
     Image img;


    public Enemy(int posX, int posY) {
        position=new Vector2D(posX,posY);
        try {
            img= ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        Vector2D veclocity=new Vector2D();
       veclocity.y+=3;
       position.addUp(veclocity);
    }

    void render(Graphics g){
            g.drawImage(img,(int)position.x,(int)position.y,null);
    }
}
