package bases;

import java.awt.*;

public class ImageRenderer extends Renderer {


    public ImageRenderer(String url) {
        this.img= ImageUtil.LoadImage(url);

    }

    public void render(Graphics g, Vector2D position){
        int imageWidth=this.img.getWidth(null);
        int imageHeight=this.img.getHeight(null);
        Vector2D renderPos=position.substract(imageWidth/2,imageHeight/2);
        g.drawImage(img,(int)renderPos.x,(int)renderPos.y,null);
    }
}
