import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;

public class Gui extends JPanel implements ActionListener {

    private static JFrame frame = new JFrame("Test");
    private static JPanel board = new JPanel();
    private static JButton b1 = new JButton("Start");
    private static JButton b2 = new JButton("Reset");
    private static Integer GAME_HEIGHT = 300;
    private static Integer GAME_WIDTH = 300;
    private static Image dot;
    private static Image head;
    private static Image apple;
    public static boolean gameRunning = true;

    public static void loadGui() {
        settings();
        addButtons();
        loadImages();
    }

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

        board.setSize(new Dimension(200, 200));
        board.setBackground(Color.BLACK);

        frame.pack();
    }

    public static void addButtons() {


    }

    private static void loadImages() {
        ImageIcon imageIconDot = new ImageIcon("res/dot.png");
        dot = imageIconDot.getImage();

        ImageIcon imageIconHead = new ImageIcon("res/head.png");
        head = imageIconHead.getImage();

        ImageIcon imageIconApple = new ImageIcon("res/apple.png");
        apple = imageIconApple.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        draw(g);

    }

    public void draw(Graphics g) {
        if (gameRunning) {
            g.drawImage(apple, Game.appleX, Game.appleY, this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        repaint();
    }


    private class TAdapter extends KeyAdapter {
        private boolean leftDirection = false;
        private boolean rightDirection = true;
        private boolean upDirection = false;
        private boolean downDirection = false;
        
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            System.out.println(leftDirection + " " + rightDirection + " " + upDirection + " " + downDirection);
        }
    }
}