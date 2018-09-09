package bases;

import blood.BloodSpawner;
import enemy.Enemy;
import enemy.EnemySpawner;
import players.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    static private ArrayList<GameObject> gameObjects=new ArrayList<>();
   private static ArrayList<GameObject> newGameObjects=new ArrayList<>();
   public boolean isActive;
    public GameObject(int x,int y) {
        this.position=new Vector2D(x,y);
        this.imageRenderer=null;
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

    public static Enemy checkCollision(BoxCollider boxCollider){
          for(GameObject go: gameObjects){
              if(go.isActive && go.boxCollider !=null){
                  if(go instanceof Enemy){
                      if(go.boxCollider.collideWith(boxCollider)){
                          return (Enemy) go;
                      }
                  }
              }
          }
          return null;
    }

    public static Player checkCollisionPlayer(BoxCollider boxCollider){
        for(GameObject go: gameObjects){
            if(go.isActive && go.boxCollider !=null){
                if(go instanceof Player){
                    if(go.boxCollider.collideWith(boxCollider)){
                        return (Player) go;
                    }
                }
            }
        }
        return null;
    }

    public BoxCollider boxCollider;

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
        if(this.imageRenderer != null){
            this.imageRenderer.render(g,position);
        }

        if(boxCollider!=null){
            this.boxCollider.render(g);
        }
    }

    public void destroy(){
        this.isActive=false;
    }
}
