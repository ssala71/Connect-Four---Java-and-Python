package ConnectFour;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GamePanel extends JPanel implements MouseListener{
    public static Color RectColor = new Color(3,4,170);
    public static Color YellowColor = new Color(220,220,0);
    public static Color RedColor = new Color(250,0,10);

    public static int RectX = 300;
    public static int RectY = 75;
    public static int RectWidth = 1000;
    public static int RectHeight = 800;

    private boolean isHardMode;
    JLabel label;

    int[][] board = new int[6][7];

    public GamePanel(boolean isHardMode){
        this.isHardMode = isHardMode;

        label = new JLabel();
        label.addMouseListener(this);

        setBackground(new Color(200,200,200));
        this.setPreferredSize(new Dimension(1920, 1080));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Draw grid and pieces here
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;

        graphics.setStroke(new BasicStroke(6f));
        graphics.setColor(RectColor);
        graphics.fillRect(RectX,RectY,RectWidth,RectHeight);

        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(4f));

        for (int i = 0; i < 8; i++){
        graphics.drawLine(300 + i * 143,77,300 + i*143,872);
        }
        graphics.drawLine(300,872,1300,872);

        graphics.setColor(Color.WHITE);

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 6; j++){
                if (board[j][i] == 0) {
                    graphics.setColor(Color.WHITE);
                } else if (board[j][i] == 1) {
                    graphics.setColor(Color.RED);
                } else if (board[j][i] == 2) {
                    graphics.setColor(Color.YELLOW);
                }

                graphics.fillOval(312 + i * 143, 90 + 130 * j,120, 120);
            }
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getX() >= 300 && e.getX() <= 1300 && e.getY() > 77 && e.getY() < 872){
            int column = (e.getX() - 300)/ 143;

            switch(column){
                case 0:

                case 1:
            }


        }
        

        
    }
    

}
