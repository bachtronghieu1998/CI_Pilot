package enemy;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class EnemyExplosion extends GameObject {


    public EnemyExplosion(int x, int y) {
        super(x, y);

        this.renderer=new Animation(3,true,
                ImageUtil.LoadImage("images/enemy/bacteria/bacteria_dead1.png"),
        ImageUtil.LoadImage("images/enemy/bacteria/bacteria_dead2.png"),
        ImageUtil.LoadImage("images/enemy/bacteria/bacteria_dead3.png"),
        ImageUtil.LoadImage("images/enemy/bacteria/bacteria_dead4.png"),
        ImageUtil.LoadImage("images/enemy/bacteria/bacteria_dead5.png")
                );
    }

    @Override
    public void run() {
        super.run();
        Animation animation=(Animation) this.renderer;
        if(animation.finish){
           this.destroy();
        }
    }
}
