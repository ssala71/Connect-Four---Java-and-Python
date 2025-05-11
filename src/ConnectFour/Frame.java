package ConnectFour;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame implements ActionListener{

    JButton easyButton;
    JButton hardButton;

    public Frame(){
        //Create a frame object
        JFrame frame = createFrame();

        JLabel titleLabel = createTitleLabel();
        frame.add(titleLabel);

        JLabel subTitleLabel = createSubtitleLabel();
        frame.add(subTitleLabel);

        easyButton = createEasyButton();
        frame.add(easyButton);

        hardButton = createHardButton();
        frame.add(hardButton);

        frame.setLayout(null);
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
        ImageIcon image = new ImageIcon("C:\\Users\\ssala\\Downloads\\CS46B Folder\\Connect Four Game\\src\\resources\\logo.png");
        frame.setIconImage(image.getImage());


        return frame;
    }

    private JLabel createTitleLabel(){
        JLabel label = new JLabel("Connect Four");

        //Adding text, color, font, size
        label.setText("Connect Four");
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
        button.setBounds(180, 350, 1200, 125); 
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setFocusPainted(false);

        return button;
    }

    private JButton createHardButton(){
        JButton button = new JButton("Hard");
        button.setBounds(180, 500, 1200, 125); 
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setFocusPainted(false);

        return button;
    }

    public void easyButtonPressed(ActionEvent event){
        
    }

    public void hardButtonPressed(ActionEvent event){

    }

    public static void main(String[] args) {
        new Frame();
    }




}
