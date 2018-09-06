package bases;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageUtil {

   static public Image LoadImage(String url){
        Image img=null;
        try {
            img= ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    static public void DrawImage(Graphics g,Image img,int x, int y){
       g.drawImage(img,x,y,null);
    }
}
