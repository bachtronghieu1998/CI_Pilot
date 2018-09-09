package enemy;

import bases.FrameCounter;
import bases.GameObject;
import game.Setting;

import java.util.Random;

public class EnemySpawner extends GameObject {
    FrameCounter countEnemy;

    public static EnemySpawner enemySpawner=new EnemySpawner();
    public EnemySpawner() {
        super();
        countEnemy=new FrameCounter(100);
    }



    public void insertEnemy(){
        if(countEnemy.expired){
            Random rd=new Random();
            int x= rd.nextInt(Setting.width-64*2)+64;
            int y=-64;
            GameObject.add(new Enemy(x,y));
            countEnemy.reset();
        }else{
            countEnemy.run();
        }

    }
}
