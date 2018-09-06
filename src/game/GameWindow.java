package game;

import input.InputManager;
import input.MouseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTimeRender = 0;

    public GameWindow() throws HeadlessException {
        setTitle("Micro-Wave");
        this.setSize(Setting.width, Setting.height);
        //SetUp Canvas
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);


        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                MouseManager.mouseManager.MouseMove(e);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                MouseManager.mouseManager.MousePress(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                MouseManager.mouseManager.MouseRelease(e);
            }
        });

        //Key listener
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                InputManager.instance.KeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                InputManager.instance.KeyRelease(e);
            }
        });
//



        this.setResizable(false);
        this.setVisible(true);
    }

    boolean update = true;

    public void MainLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                gameCanvas.update();
                update = !update;
                gameCanvas.render();
                lastTimeRender = currentTime;
            }

        }
    }


}
