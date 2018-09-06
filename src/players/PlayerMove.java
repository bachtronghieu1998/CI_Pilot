package players;

import bases.Vector2D;
import input.InputManager;
import input.MouseManager;

public class PlayerMove {


    public void run(Player p) {
        if(p.id==1){
            Vector2D verlocity=new Vector2D();
            if (InputManager.instance.rightPressed) {
                verlocity.x+=5;
            }
            if (InputManager.instance.leftPressed) {
                verlocity.x-= 5;
            }
            if (InputManager.instance.downPressed) {
                verlocity.y += 5;
            }
            if (InputManager.instance.upPressed) {
                verlocity.y -= 5;
            }
            p.position.addUp(verlocity);
        }else{
                p.position.x=MouseManager.mouseManager.position.x;
                p.position.y=MouseManager.mouseManager.position.y;
        }






    }


}
