package ConnectFour;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class GamePanel extends JPanel {
    private boolean isHardMode;
    
    public GamePanel(boolean isHardMode){
        this.isHardMode = isHardMode;

        this.setPreferredSize(new Dimension(1920, 1080));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Draw grid and pieces here
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawRect(200, 200, 200, 200);
    }

}
