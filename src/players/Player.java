package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import enemy.Enemy;
import input.InputManager;


public class Player extends GameObject {
   PlayerShoot playerShoot;
    boolean locked =false;
    int count =0;
    int id;
    public Player(int x, int y,String picURL,int id) {
        super(x, y);
        this.renderer =new ImageRenderer(picURL);
        playerShoot=new PlayerShoot();
        this.id=id;
        this.boxCollider=new BoxCollider(x,y,30,30);
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
      hitEnemy();
    }

    private void hitEnemy() {
        Enemy enemy= GameObject.checkCollision(this.boxCollider,Enemy.class);
        if(enemy!=null){
         //  this.isActive=false;
        }
    }

    public void shoot() {
      playerShoot.run(this);
    }

    private void move() {
        new PlayerMove().run(this);

    }
}
