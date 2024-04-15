import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Gui extends JFrame implements ActionListener {
   
    private static JFrame frame = new JFrame("Test");
    private static JPanel board = new JPanel();
    private static JButton b1 = new JButton("Start");
    private static JButton b2 = new JButton("Reset");
    public static Integer GAME_HEIGHT = 600;
    public static Integer GAME_WIDTH = 400;
    private Image dot;
    private Image head;
    private Image apple;

    
    public static void settings() {
        // frame.setSize(1200,800);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        GridBagConstraints g = new GridBagConstraints();

        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 0.5;
        g.gridx = 0;
        g.gridy = 1;
        frame.add(b1, g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 0.5;
        g.gridx = 1;
        g.gridy = 1;
        frame.add(b2, g);
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        g.ipadx = GAME_HEIGHT;
        g.ipady = GAME_WIDTH;
        g.weightx = 2;
        frame.add(board, g);
        board.setSize(new Dimension(200,200));
        board.setBackground(Color.BLUE);
        frame.pack();
    }

    public static void addButtons() {

        
    }    
    
    private void loadImages() {
        ImageIcon imageIconDot = new ImageIcon("res/dot.png");
        dot = ImageIconDot.getImage();
    }

    
    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        testDraw(g);
    }

    public static void testDraw(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        repaint();
    }
}