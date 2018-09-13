package blood;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Setting;

import java.util.Random;

public class Blood extends GameObject {

    public Blood(int x,int y) {
       super(x,y);
        renderer =new ImageRenderer("images/blood cells/blood-cell1.png");
    }

    public void run(){
//        super.run();
        Vector2D veclocity=new Vector2D();
        veclocity.x+=1;
        veclocity.y+=1;
        this.position.addUp(veclocity);
        deactiveIfNeeded();
    }

    @Override
    public void deactiveIfNeeded() {
        if(position.x>600){
            this.isActive=false;
        }
    }
}
