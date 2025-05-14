package ConnectFour;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import org.python.util.PythonInterpreter;
import java.util.concurrent.TimeUnit;


public class GamePanel extends JPanel implements MouseListener{
    //Created colors to reference later
    public static Color RectColor = new Color(3,4,170);
    public static Color YellowColor = new Color(220,220,0);
    public static Color RedColor = new Color(250,0,10);

    //Position of Board
    public static int RectX = 300;
    public static int RectY = 75;
    public static int RectWidth = 1000;
    public static int RectHeight = 800;

    //True or false conditions of whether it should use hard AI or if person won
    private boolean isHardMode;
    private boolean isHuman;
    private boolean winCondition = false;

    JButton backButton;
    JFrame frame;

    //current player initialized and the board
    int[][] board = new int[6][7];
    int currentPlayer = 1;

    //Constructor with isHardMode variable used to dictate what AI to use depending on selection
    public GamePanel(boolean isHardMode, boolean isHuman){
        this.isHardMode = isHardMode;
        this.isHuman = isHuman;

        if (!isHuman){
            if (isHardMode){
                //put wtv for hard mode
            }
            else{
                //put wtv for easy mode
            }
        }
        
        addMouseListener(this);

        setLayout(null);


        backButton = backButton();
        backButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        frame = (JFrame) SwingUtilities.getWindowAncestor(GamePanel.this);

        frame.setContentPane(new MenuPanel());
        
        frame.revalidate();
        frame.repaint();
    }
});

        this.add(backButton);

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

        //Checks with board to see what color to change it to        
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 6; j++){
                switch (board[j][i]) {
                    case 0:
                        graphics.setColor(Color.WHITE);
                        break;
                    case 1:
                        graphics.setColor(Color.RED);
                        break;
                    case 2:
                        graphics.setColor(Color.YELLOW);
                        break;
                    default:
                        break;
                }
                //System.out.println("Drawing cell [" + j + "][" + i + "] = " + board[j][i]);
                graphics.fillOval(312 + i * 143, 90 + 130 * j,120, 120);
            }
        }


    }
    
    //Button to go back to menu
    private JButton backButton(){
        JButton button = new JButton("Back");
        button.setBackground(new Color(255,255,255));

        button.setBounds(0, 10, 250, 50); 
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setFocusPainted(false);

        return button;
    }
    

    public void dropDown(int column){
        //check if row is empty if empty then it inserts, if not keeps going until not empty
        //Case where does nothing if row is full

        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == 0){
                //Probably check if its either player one or player two then repaint circle
                board[row][column] = currentPlayer;
                if (currentPlayer == 1) {
                    currentPlayer = 2;
                    //System.out.println("Dropped at row " + row + ", col " + column + ", by player " + currentPlayer);
                    break;

                } else {
                    currentPlayer = 1;
                    //System.out.println("Dropped at row " + row + ", col " + column + ", by player " + currentPlayer);
                    break;
                }
            }
        }
        repaint();
    }
    
    //Helper Methods to make debugging easier, for any if cases where opponent loses
    public void checkWinCondition(){
        //We want to check up, rights and diagonals
        checkHorizontalWin();

        checkVerticalWin();

        checkUpDiagonalWin();

        checkDownDiagonalWin();

    }

    //First helper method that checks if someone won by stacking pieces
    public void checkVerticalWin(){
        //Gonna be 7 and 3 for i and j
        //int[6][7]
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 3; j++){
                if (board[j][i] == 1 && board[j+1][i] == 1 && board[j+2][i] == 1 && board[j+3][i] == 1||
                    board[j][i] == 2 && board[j+1][i] == 2 && board[j+2][i] == 2 && board[j+3][i] == 2){
                        System.out.println("You win!!!!!");
                        winCondition = true;
                        return;
                }
            }
        }
    }

    //Second helper method that checks if someone won by lining pieces together, horizontally
    public void checkHorizontalWin(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 6; j++){
                if (board[j][i] == 1 && board[j][i+1] == 1 && board[j][i+2] == 1 && board[j][i+3] == 1||
                    board[j][i] == 2 && board[j][i+1] == 2 && board[j][i+2] == 2 && board[j][i+3] == 2){
                        System.out.println("You win!!!!!");
                        winCondition = true;
                        return;
                }

            }
        }
    }
    //Third helper method, starts at top left then goes down right looking for pieces that won diagonally down
    public void checkDownDiagonalWin(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                if (board[j][i] == 1 && board[j+1][i+1] == 1 && board[j+2][i+2] == 1 && board[j+3][i+3] == 1||
                    board[j][i] == 2 && board[j+1][i+1] == 2 && board[j+2][i+2] == 2 && board[j+3][i+3] == 2){
                        System.out.println("WON");
                        winCondition = true;
                        return;
                }
            }
            
        }
    }

    //Last helper method, begins at bottome left that iterates to see if its possible that someone won diagonally up
    public void checkUpDiagonalWin(){
        for (int i = 0; i < 4; i++){
            for (int k = 5; k > 2; k--){
                if (board[k][i] == 1 && board[k-1][i+1] == 1 && board[k-2][i+2] == 1 && board[k-3][i+3] == 1||
                        board[k][i] == 2 && board[k-1][i+1] == 2 && board[k-2][i+2] == 2 && board[k-3][i+3] == 2){
                            winCondition = true;
                            return;
                    }
                }
        }
    }

    public int getAI(){
        //Easy mode AI done in java
        if (!isHardMode){
            int rand = (int) (Math.random() * 7);
            //if full then do back throuhg getAI()
            while (board[0][rand] == 1 || board[0][rand] == 2){
                rand = (int) (Math.random() * 7);
                if (board[0][rand] == 1 || board[0][rand] == 2){
                    continue;
                }
                return rand;
            }

            return rand;

            
        }
        else{
            //filer for hard for now
            return 2;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Whenever a mouse is clicked, it checks if game is over,
        //If game is over then it prints you won, used for debugging
        //If not, and if its within the axis of the baord then it drops the coin to lowest slot and repaints
    
        checkWinCondition();
            if (winCondition == false && e.getX() >= 300 && e.getX() <= 1300 && e.getY() > 77 && e.getY() < 872){
                int column = (e.getX() - 300)/ 143;
                int row = (e.getY() - 75)/130;

                        dropDown(column);

                        checkWinCondition();

                        if (!isHuman && currentPlayer == 2 && !winCondition) {
                            int AImove = getAI();
                            dropDown(AImove);
                    }

                }
            if (winCondition == true){
                System.out.println("You won");
            }
            
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }

    

}
