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

        GridBagConstraints gr = new GridBagConstraints();

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.5;
        gr.gridx = 0;
        gr.gridy = 1;
        frame.add(b1, gr);

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.5;
        gr.gridx = 1;
        gr.gridy = 1;
        frame.add(b2, gr);

        gr.gridx = 0;
        gr.gridy = 0;
        gr.gridwidth = 2;
        gr.ipadx = GAME_HEIGHT;
        gr.ipady = GAME_WIDTH;
        gr.weightx = 2;
        frame.add(board, gr);

        board.setSize(new Dimension(200, 200));
        board.setBackground(Color.BLACK);
        //board.paintComponents(Graphics g);

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
}