package game;

import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;

public class Background extends GameObject {




    public Background(int x, int y) {
        super(x, y);
        imageRenderer=new ImageRenderer("images/background/background.png");
    }

    public void render(Graphics g){
       ImageUtil.DrawImage(g,imageRenderer.img,0,0);
    }
}
