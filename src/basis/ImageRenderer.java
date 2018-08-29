package basis;

import basis.ImageUtil;
import basis.Vector2D;

import java.awt.*;

public class ImageRenderer {
   public Image img;

    public ImageRenderer(String url) {
        this.img= ImageUtil.LoadImage(url);

    }

    public void render(Graphics g, Vector2D position){
        g.drawImage(img,(int)position.x,(int)position.y,null);
    }
}
