package players;

import basis.FrameCounter;
import input.InputManager;

public class PlayerShoot {
    boolean locked =false;
   FrameCounter counter;

    public PlayerShoot() {
        counter=new FrameCounter(10);
    }

    public void run(Player player) {
        //Lock the player gun
        if(InputManager.instance.xPressed && !locked){
            PlayerBullet b3=new PlayerBullet((int)player.position.x,(int)player.position.y);
            player.bullets.add(b3);
            locked =true;
        }

        if(locked){
           counter.run();
           if(counter.expired){
               locked=false;
               counter.reset();
           }
        }
    }
}
