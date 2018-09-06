package players;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import input.InputManager;


public class Player extends GameObject {
   PlayerShoot playerShoot;
    boolean locked =false;
    int count =0;
    int id;
    public Player(int x, int y,String picURL,int id) {
        super(x, y);
        this.imageRenderer=new ImageRenderer(picURL);
        playerShoot=new PlayerShoot();
        this.id=id;
    }

    public void checkPosition(){
        if(position.x==-32 && InputManager.instance.leftPressed){
            InputManager.instance.leftPressed=false;
        }
        if(position.x==568 && InputManager.instance.rightPressed){
            InputManager.instance.rightPressed=false;
        }
        if(position.y==620&& InputManager.instance.downPressed){
            InputManager.instance.downPressed=false;
        }
        if(position.y==0&& InputManager.instance.upPressed){
            InputManager.instance.upPressed=false;
        }
    }


     public void run(){
        super.run();
      checkPosition();
      this.move();
      this.shoot();
    }

    public void shoot() {
      playerShoot.run(this);
    }

    private void move() {
        new PlayerMove().run(this);

    }
}
