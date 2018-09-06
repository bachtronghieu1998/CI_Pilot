package blood;

import bases.FrameCounter;
import bases.GameObject;

public class BloodSpawner {
    FrameCounter  counter;

    public static BloodSpawner bloodSpawner = new BloodSpawner();
    public BloodSpawner() {
        counter=new FrameCounter(500);
    }

    public  void insertBlood(){
        if(counter.expired){
            GameObject.add(new Blood());
            counter.reset();
        }else{
            counter.run();
        }

    }
}
