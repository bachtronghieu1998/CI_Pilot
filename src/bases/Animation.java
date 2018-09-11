package bases;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Animation extends Renderer {
    ArrayList<Image> images;
    int imageIndex=0;
    FrameCounter counter;
    boolean oneTime;
   public boolean finish;
    //Load img
    public Animation(int frameDelay,boolean oneTime,Image...imgs) {
        this.images = new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));
        counter=new FrameCounter(frameDelay);
        this.oneTime=oneTime;
        this.finish=false;
    }

    public Animation(Image ...images) {
        this(10,false,images);
    }

    //Draw img
    @Override
    public void render(Graphics g, Vector2D position) {
        super.render(g, position);
            renderCurrentImage(g,position);
            changeCurrentImage();
    }

    private void changeCurrentImage(){
        if(counter.expired){

            imageIndex++;
            if(imageIndex>=images.size()){
                if(this.oneTime){
                    this.finish=true;
                }else{
                    imageIndex=0;
                }
            }
            counter.reset();
        }else{
           counter.run();
        }

    }

    private void renderCurrentImage(Graphics g,Vector2D position){
        Image currentImage=images.get(imageIndex);
        int width=currentImage.getWidth(null);
        int height=currentImage.getHeight(null);
        g.drawImage(currentImage,(int)position.x-width/2,(int)position.y-height/2,null);
    }
}
