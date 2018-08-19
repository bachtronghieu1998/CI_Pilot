import java.awt.*;
import java.util.ArrayList;

public class Player {
    int posX;
    int posY;
    Image img;
    InputManager inputManager;
    ArrayList<PlayerBullet> bullets;
    boolean locked =false;
    int count =0;

    public Player(int posX, int posY) {
       this.img= ImageUtil.LoadImage("images/player/MB-69/player1.png");
        bullets =new ArrayList<>();
        this.posX = posX;
        this.posY = posY;
    }

     void render(Graphics g){
        g.drawImage(img,posX,posY,null);
         for(PlayerBullet p: bullets){
             p.render(g);
         }
    }

    public void LockTheGun(){
        //Lock the player gun
        if(inputManager.xPressed && !locked){
            PlayerBullet b3=new PlayerBullet(this.posX,this.posY);
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


    void checkPosition(){
        if(this.posX==-32 && inputManager.leftPressed){
            inputManager.leftPressed=false;
        }
        if(this.posX==568 && inputManager.rightPressed){
            inputManager.rightPressed=false;
        }
        if(this.posY==620&& inputManager.downPressed){
            inputManager.downPressed=false;
        }
        if(this.posY==0&& inputManager.upPressed){
            inputManager.upPressed=false;
        }
    }

    void run(){
      checkPosition();
        if (inputManager.rightPressed) {
            this.posX += 5;
        }
        if (inputManager.leftPressed) {
            this.posX -= 5;
        }
        if (inputManager.downPressed) {
            this.posY += 5;
        }
        if (inputManager.upPressed) {
            this.posY -= 5;
        }
        for(PlayerBullet b:bullets){
            b.run();
        }
        LockTheGun();
    }
}
