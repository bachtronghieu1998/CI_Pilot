package bases;

public class Vector2D {
   public  float x;
   public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0,0);
    }

    //Add
    public void addUp(float x,float y){
        this.x+=x;
        this.y+=y;
    }

    public Vector2D add(float x,float y){
        return new Vector2D(x+this.x,y+this.y);
    }

    public void addUp(Vector2D v){
       this.addUp(v.x,v.y);
    }

    public Vector2D add(Vector2D v){
       return this.add(v.x,v.y);
    }

    //Substract
    public void substractBy(float x,float y){
        this.x-=x;
        this.y-=y;
    }

    public Vector2D substract(float x,float y){
        return new Vector2D(this.x-x,this.y-y);
    }

    public void substractBy(Vector2D v){
       this.substractBy(v.x,v.y);
    }

    public Vector2D substract(Vector2D v){
        return this.substract(v.x,v.y);
    }

    //Scale
    public void scaleBy(float k){
        this.x*=k;
        this.y*=k;
    }

    public Vector2D scale(float k){
        return new Vector2D(this.x*k,this.y*k);
    }

    //length
    public float length(){
       return (float) Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    //nomalization
    public Vector2D nomalize(){
        float temp=this.length();
        return new Vector2D(this.x/temp,this.y/temp);
    }

    public void print(){
        System.out.println(x+", " +y);
    }
}
