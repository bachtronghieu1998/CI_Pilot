package players;

import basis.Vector2D;
import input.InputManager;

public class PlayerMove {


    public Vector2D run() {
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
        return verlocity;
    }
}
