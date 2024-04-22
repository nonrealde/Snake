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
import java.awt.Toolkit;

public class Gui extends JPanel implements ActionListener {

    private static JFrame frame = new JFrame("Test");
    // private static JPanel board = new JPanel();
    private static Gui board = new Gui();
    private static JButton btnStart = new JButton("Start");
    private static JButton btnReset = new JButton("Reset");
    private static Integer GAME_HEIGHT = 300;
    private static Integer GAME_WIDTH = 300;
    private static Image dot;
    private static Image head;
    private static Image apple;
    public static boolean gameRunning = true;
    public static Color testColor = Color.green;

    public static void loadGui() {
        settings();
        loadImages();
    }

    public static void settings() {
        // frame.setSize(1200,800);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        btnStart.addActionListener(board);
        btnReset.addActionListener(board);

        GridBagConstraints gr = new GridBagConstraints();

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.5;
        gr.gridx = 0;
        gr.gridy = 1;
        frame.add(btnStart, gr);

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.5;
        gr.gridx = 1;
        gr.gridy = 1;
        frame.add(btnReset, gr);

        gr.gridx = 0;
        gr.gridy = 0;
        gr.gridwidth = 2;
        gr.ipadx = GAME_HEIGHT;
        gr.ipady = GAME_WIDTH;
        gr.weightx = 2;
        
        board.setSize(new Dimension(300, 300));
        board.setBackground(Color.BLACK);
        frame.add(board, gr);
        // board.repaint();

        frame.pack();
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
        // g.setColor(Color.orange);
        // g.fillRect(0, 0, getWidth(), getHeight());
        // g.setColor(testColor);
        // g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
        g.drawImage(apple, Game.appleX, Game.appleY, board);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnStart) {
            System.out.println("start");
            testColor = Color.red;
            Game.spawnApple();
        }
        if (e.getSource() == btnReset) {
            System.out.println("Reset");
            testColor = Color.blue;
        }
        frame.repaint();
    }
}