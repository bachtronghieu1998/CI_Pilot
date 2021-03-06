package players;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import input.InputManager;
import input.MouseManager;

import java.awt.event.MouseAdapter;

public class PlayerShoot {
   private boolean locked =false;
   FrameCounter counter;

    public PlayerShoot() {
        counter=new FrameCounter(10);
    }

    public void run(Player player) {
        //Lock the player gun
        if(player.id==1){
            if(InputManager.instance.xPressed && !locked){
                Vector2D bulletPos=player.position.substract(0,30);
                GameObject.recycle((int)bulletPos.x,(int)bulletPos.y,PlayerBullet.class);


                locked =true;
            }

        }
        if(player.id==2) {

            if (MouseManager.mouseManager.isClicked && !locked) {
                Vector2D bulletPos = player.position.substract(0, 30);
                PlayerBullet b3 = new PlayerBullet((int) bulletPos.x, (int) bulletPos.y);
                GameObject.add(b3);
                locked = true;
            }
        }
        if(this.locked){
            counter.run();
            if(counter.expired){
                locked=false;
                counter.reset();
            }
        }
    }
}
