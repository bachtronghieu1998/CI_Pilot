import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {
     int posX;
     int posY;
     Image img;


    public Enemy(int posX, int posY) {
        try {
            img= ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.posX = posX;
        this.posY = posY;
    }

    public void run(){
        this.posY+=3;
    }

    void render(Graphics g){
            g.drawImage(img,posX,posY,null);
    }
}
