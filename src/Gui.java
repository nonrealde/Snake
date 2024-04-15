import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
public class Gui extends JFrame {
   
    private static JFrame frame = new JFrame("Test");
    private static JPanel board = new JPanel();
    private static JButton b1 = new JButton("Button1");
    private static JButton b2 = new JButton("Button2");

    
    public static void settings() {
        frame.setSize(1200,800);
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void addButtons() {
        frame.add(b1);
        frame.add(b2);
        // board.setLocation(200,200);
        frame.add(board);
        // board.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        board.setSize(new Dimension(200,200));
        board.setBackground(Color.BLUE);
        // frame.pack();
    }    
}