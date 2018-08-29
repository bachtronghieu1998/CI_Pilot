package players;

import basis.ImageRenderer;
import basis.Vector2D;
import input.InputManager;

import java.awt.*;
import java.util.ArrayList;

public class Player {
   public Vector2D position;
   public ArrayList<PlayerBullet> bullets;
   public ImageRenderer img;
   PlayerShoot playerShoot;
    boolean locked =false;
    int count =0;

    public Player(int posX, int posY) {
      img=new ImageRenderer("images/player/MB-69/player1.png");
        position=new Vector2D(posX,posY);
      playerShoot=new PlayerShoot();
    }

    public void render(Graphics g){
         img.render(g,position);

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
      checkPosition();
      this.move();
      this.shoot();
    }

    public void shoot() {
      playerShoot.run(this);
    }

    private void move() {
        this.position.addUp(new PlayerMove().run());
    }
}
