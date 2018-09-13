package blood;

import bases.FrameCounter;
import bases.GameObject;
import game.Setting;

import java.util.Random;

public class BloodSpawner {
    FrameCounter  counter;

    public static BloodSpawner bloodSpawner = new BloodSpawner();
    public BloodSpawner() {
        counter=new FrameCounter(300);
    }

    public  void insertBlood(){
        if(counter.expired){
            Random rd=new Random();
            int x= rd.nextInt(Setting.width-64*2)+64;
            int y=rd.nextInt(Setting.height/2);
          GameObject.recycle(x,y,Blood.class);
            counter.reset();
        }else{
            counter.run();
        }

    }
}
