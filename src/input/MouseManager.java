package input;

import bases.Vector2D;

import java.awt.event.MouseEvent;
import java.util.Vector;

public class MouseManager {
   public boolean isClicked=false;
   public boolean isMoved=false;
    public Vector2D position;
    public static MouseManager mouseManager=new MouseManager();

    public MouseManager() {
        position=new Vector2D();
    }


    public void MouseMove(MouseEvent e){
        if(position.x!=e.getX() && position.y!=e.getY()){
            position.x=e.getX();
            position.y=e.getY();
            isMoved=true;
        }else{
            isMoved=false;
        }

    }

    public void MousePress(MouseEvent e){
        isClicked=true;

    }
    public void MouseRelease(MouseEvent e) {
        isClicked=false;
    }
}
