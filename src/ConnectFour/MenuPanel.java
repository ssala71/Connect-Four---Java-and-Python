package ConnectFour;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener{

    
    JFrame frame;

    JButton easyButton;
    JButton hardButton;
    JButton humanButton;

    boolean isHardMode;

    public MenuPanel(){
        //Create a frame object
        frame = createFrame();

        BorderLayout border = new BorderLayout();

        JLabel titleLabel = createTitleLabel();
        frame.add(titleLabel);

        JLabel subTitleLabel = createSubtitleLabel();
        frame.add(subTitleLabel);

        easyButton = createEasyButton();
        easyButton.addActionListener(this);
        frame.add(easyButton);

        hardButton = createHardButton();
        hardButton.addActionListener(this);
        frame.add(hardButton);

        humanButton = createHumanButton();
        humanButton.addActionListener(this);
        frame.add(humanButton);

        frame.setLayout(border);
        frame.setVisible(true);

    }

    private JFrame createFrame(){
        JFrame frame = new JFrame("Connect Four");

        //We make it so user cant change size, and when closed, it fully closes
        frame.setSize(1920, 1080);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //We set the background to a certain color
        frame.getContentPane().setBackground(new Color(200,200,200));

        //Icon image will work on later
        ImageIcon image = new ImageIcon("C:\\Users\\ssala\\Downloads\\Coding\\Connect4\\src\\images\\logo.png");
        frame.setIconImage(image.getImage());


        return frame;
    }


    private JLabel createTitleLabel(){
        JLabel label = new JLabel("Connect Four");

        //Adding color, font, size
        label.setForeground(new Color(0,0,0));
        label.setFont(new Font("Arial", Font.BOLD, 100));

        //Text position
        label.setBounds(375, 75, 800, 100);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        return label;
    }

    private JLabel createSubtitleLabel(){
        JLabel label = new JLabel();

        label.setText("Choose a difficulty option");
        label.setForeground(new Color(0,0,0));
        label.setFont(new Font("Arial", Font.PLAIN, 32));

        //Text position
        label.setBounds(375, 75, 800, 260);
        label.setHorizontalAlignment(SwingConstants.CENTER);


        return label;
    }

    private JButton createEasyButton(){
        JButton button = new JButton("Easy");
        button.setBackground(new Color(255,255,255));

        button.setBounds(180, 350, 1200, 125); 
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setFocusPainted(false);

        return button;
    }

    private JButton createHardButton(){
        JButton button = new JButton("Hard");
        button.setBackground(new Color(255,255,255));

        button.setBounds(180, 500, 1200, 125); 
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setFocusPainted(false);

        return button;
    }

    private JButton createHumanButton(){
        JButton button = new JButton("vs Human");
        button.setBackground(new Color(255,255,255));

        button.setBounds(180, 650, 1200, 125); 
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setFocusPainted(false);

        return button;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == easyButton){
            isHardMode = false;
            System.out.println(1);

            frame.getContentPane().removeAll();
            
            frame.getContentPane().add(new GamePanel(isHardMode));
            frame.revalidate();
            frame.repaint();

        }

        if (e.getSource() == hardButton){
            isHardMode = true;
            System.out.println(2);

            frame.getContentPane().removeAll();
            
            frame.getContentPane().add(new GamePanel(isHardMode));
            frame.revalidate();
            frame.repaint();
            
        }

        if (e.getSource() == humanButton){
            isHardMode = false;
            System.out.println(3);

            frame.getContentPane().removeAll();
            
            frame.getContentPane().add(new GamePanel(isHardMode));
            frame.revalidate();
            frame.repaint();

        }


        
    }

    public static void main(String[] args){
        new MenuPanel();
    }




}
