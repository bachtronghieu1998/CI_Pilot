import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Enemy {
    int posX;
    int posY;
    Image img;
    public Enemy() {
        posY=-64;
        Random rd=new Random();
      posX= rd.nextInt(600-64*2)+64;
        try {
            img= ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
