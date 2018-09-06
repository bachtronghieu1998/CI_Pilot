package game;

import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        imageRenderer=new ImageRenderer("images/background/background.png");
        this.position=new Vector2D(0,0);
    }

    public void render(Graphics g){
       ImageUtil.DrawImage(g,imageRenderer.img,0,0);
    }
}
