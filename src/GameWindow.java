import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTimeRender=0;
    public GameWindow() throws HeadlessException {
        setTitle("Micro-Wave");
        this.setSize(600,800);
        //SetUp Canvas
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        gameCanvas=new GameCanvas();
        this.setContentPane(gameCanvas);
     //   setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Key listener
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
              gameCanvas.KeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
              gameCanvas.KeyRelease(e);
            }
        });
        this.setResizable(false);
        this.setVisible(true);
    }

    void MainLoop(){
        while(true){
            long currentTime=System.nanoTime();
            if(currentTime-lastTimeRender>=17_000_000){
                gameCanvas.update();
                gameCanvas.render();
                lastTimeRender=currentTime;
            }

        }
    }

}
