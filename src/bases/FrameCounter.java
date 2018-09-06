package bases;

public class FrameCounter {
    public int count;
    int countMax;
    public boolean expired;

    public FrameCounter(int countMax) {
        this.countMax = countMax;
        this.count=0;
        this.expired=false;
    }

    public void run(){
        if(count>countMax){
           expired=true;
        }else{
            count++;
        }
    }

    public void reset(){
        count=0;
        expired=false;
    }
}
