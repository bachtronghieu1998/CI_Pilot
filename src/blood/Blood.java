package blood;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Setting;

import java.util.Random;

public class Blood extends GameObject {


    public Blood() {
        renderer =new ImageRenderer("images/blood cells/blood-cell1.png");
        Random rd=new Random();
        int x= rd.nextInt(Setting.width-64*2)+64;
        int y=rd.nextInt(Setting.height/2);
        this.position=new Vector2D(x,y);
    }

    public void run(){
        Vector2D veclocity=new Vector2D();
        veclocity.x+=1;
        veclocity.y+=1;
        this.position.addUp(veclocity);
    }

}
