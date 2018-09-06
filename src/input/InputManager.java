package input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InputManager {
   public boolean rightPressed=false;
    public boolean leftPressed=false;
    public boolean upPressed=false;
    public boolean downPressed=false;
    public boolean xPressed=false;


    public static InputManager instance =new InputManager();

    public void KeyPress(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightPressed=true;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftPressed=true;
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            upPressed=true;
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downPressed=true;
        }else if(e.getKeyCode()==KeyEvent.VK_X){
            xPressed=true;
        }
    }

    public void KeyRelease(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            upPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downPressed=false;
        }else if(e.getKeyCode()==KeyEvent.VK_X){
            xPressed=false;
        }
    }


}
