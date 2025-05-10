package ConnectFour;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


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
        frame.getContentPane().setBackground(new Color(0,40,4));

        //Icon image will work on later
        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());

        //Adding text
        JLabel label = new JLabel();
        label.setText("Connect Four");

        frame.add(label);


    }

    public static void main(String[] args) {
        
        new Frame();

    }




}
