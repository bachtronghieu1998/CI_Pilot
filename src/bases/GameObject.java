package bases;

import blood.BloodSpawner;
import enemy.EnemySpawner;
import players.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    static private ArrayList<GameObject> gameObjects=new ArrayList<>();
   private static ArrayList<GameObject> newGameObjects=new ArrayList<>();
    public GameObject(int x,int y) {
        this.position=new Vector2D(x,y);
        this.imageRenderer=null;
    }

    public GameObject() {
    }

    public void run(){

    }

    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

    public static void runAll(){
        for(GameObject g:gameObjects){

            g.run();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();

        BloodSpawner.bloodSpawner.insertBlood();
        EnemySpawner.enemySpawner.insertEnemy();
    }



    public static void renderAll(Graphics g){
        for(GameObject go:gameObjects){
            go.render(g);
        }
    }

    public void render(Graphics g){
        if(this.imageRenderer != null){
            this.imageRenderer.render(g,position);
        }
    }
}
