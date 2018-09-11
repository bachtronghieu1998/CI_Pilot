package bases;

import blood.BloodSpawner;
import enemy.EnemySpawner;
import players.Player;
import players.PlayerBullet;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;
    public BoxCollider boxCollider;

    static private ArrayList<GameObject> gameObjects=new ArrayList<>();
   private static ArrayList<GameObject> newGameObjects=new ArrayList<>();
   public boolean isActive;
    public GameObject(int x,int y) {
        this.position=new Vector2D(x,y);
        this.renderer =null;
        this.boxCollider=null;
        this.isActive=true;
    }

    public GameObject() {
    }

    public void run(){
        if(this.boxCollider!=null){
            this.boxCollider.position.x=this.position.x;
            this.boxCollider.position.y=this.position.y;
            this.boxCollider.run();
        }

    }

    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

    public static void runAll(){
        for(GameObject g:gameObjects){

            if(g.isActive){
                g.run();

            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();

        BloodSpawner.bloodSpawner.insertBlood();
        EnemySpawner.enemySpawner.insertEnemy();
    }

    //generics
    public static <T extends GameObject> T checkCollision(BoxCollider boxCollider,Class<T> cls){
          for(GameObject go: gameObjects){
              if(go.isActive && go.boxCollider !=null){
                  if(go.getClass().equals(cls)){
                      if(go.boxCollider.collideWith(boxCollider)){
                          return (T) go;
                      }
                  }
              }
          }
          return null;
    }

    public static void renderAll(Graphics g){
        for(GameObject go:gameObjects){
            if(go instanceof  Player){
                go.render(g);
                continue;
            }
            if(go.isActive){
                go.render(g);

            }
        }
    }

    public void render(Graphics g){
        if(this.renderer != null){
            this.renderer.render(g,position);
        }

        if(boxCollider!=null){
            this.boxCollider.render(g);
        }
    }

    public void destroy(){
        this.isActive=false;
    }

    public static PlayerBullet recycle(int x,int y,String url){
        PlayerBullet pb=null;
        for(GameObject go:gameObjects){
            if (!go.isActive) {
                if(go instanceof PlayerBullet){
                    pb= (PlayerBullet) go;
                }
            }
        }
        if(pb==null){
            pb=new PlayerBullet(x,y,url);
            GameObject.add(pb);
        }else{
            pb.isActive=true;
            pb.position.x=x;
            pb.position.y=y;
        }
        return null;
    }
}
