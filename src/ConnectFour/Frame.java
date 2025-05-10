package ConnectFour;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Frame {

    public Frame(){
        //Create a frame object
        JFrame frame = new JFrame();
        
        //We make it so user cant change size, and when closed, it fully closes
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //App title and size, as well as making it visible
        frame.setTitle("Connect Four");
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        
        //We set the background to a certain color
        frame.getContentPane().setBackground(new Color(245,245,245));

        //Icon image will work on later
        ImageIcon image = new ImageIcon("/resources/logo.png");
        frame.setIconImage(image.getImage());

        //Adding text, color, font, size
        JLabel label = new JLabel();
        label.setText("Connect Four");
        label.setForeground(new Color(0,0,0));
        label.setFont(new Font("Times new Roman", Font.PLAIN, 96));

        //Text position
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //Change Position
        label.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        frame.add(label);


    }

    public static void main(String[] args) {
        
        new Frame();

    }




}
