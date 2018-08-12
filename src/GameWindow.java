import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    public GameWindow() throws HeadlessException {
        setTitle("Micro-Wave");
        this.setSize(600,800);
        //SetUp Canvas
        gameCanvas=new GameCanvas();
        this.setContentPane(gameCanvas);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
