import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTimeRender=0;
   // InputManager inputManager;
    public GameWindow() throws HeadlessException {
   //     inputManager=new InputManager();
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

        //Key listener
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
              gameCanvas.inputManager.KeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
              gameCanvas.inputManager.KeyRelease(e);
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
