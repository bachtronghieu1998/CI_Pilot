import java.awt.*;
import java.util.ArrayList;

public class Player {
    Vector2D position;
    Image img;
    InputManager inputManager;
    ArrayList<PlayerBullet> bullets;

    boolean locked =false;
    int count =0;

    public Player(int posX, int posY) {
       this.img= ImageUtil.LoadImage("images/player/MB-69/player1.png");
        position=new Vector2D(posX,posY);
    }

     void render(Graphics g){
        g.drawImage(img,(int)position.x,(int)position.y,null);
         for(PlayerBullet p: bullets){
             p.render(g);
         }
    }



    void checkPosition(){
        if(position.x==-32 && inputManager.leftPressed){
            inputManager.leftPressed=false;
        }
        if(position.x==568 && inputManager.rightPressed){
            inputManager.rightPressed=false;
        }
        if(position.y==620&& inputManager.downPressed){
            inputManager.downPressed=false;
        }
        if(position.y==0&& inputManager.upPressed){
            inputManager.upPressed=false;
        }
    }



    void run(){
      checkPosition();
      this.move();
      this.shoot();
    }

    private void shoot() {
        //Lock the player gun
        if(inputManager.xPressed && !locked){
            PlayerBullet b3=new PlayerBullet((int)position.x,(int)position.y);
            bullets.add(b3);
            locked =true;
        }

        if(locked){
            count++;
            if(count>20){
                count=0;
                locked =false;
            }
        }
    }

    private void move() {
        Vector2D verlocity=new Vector2D();
        if (inputManager.rightPressed) {
            verlocity.x+=5;
        }
        if (inputManager.leftPressed) {
            verlocity.x-= 5;
        }
        if (inputManager.downPressed) {
            verlocity.y += 5;
        }
        if (inputManager.upPressed) {
            verlocity.y -= 5;
        }
        this.position.addUp(verlocity);
    }
}
