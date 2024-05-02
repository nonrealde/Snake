import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private static JFrame frame = new JFrame("Snake");
    static Board gameboard = new Board();
    public static JLabel scoreText = new JLabel("Score: " + Snake.score);
    private static JButton btnReset = new JButton("Reset");
    private static JButton btnTest = new JButton("2222");
    static Integer GAME_WIDTH = 400;
    static Integer GAME_HEIGHT = 400;

    public static void initGui() {
        createJFrame();
        gameboard.repaint();
    }
    public static void btnResetMethod() {
        if (Game.gameRunning != true) {
        new Thread() {
            public void run() {
                Game.newGame();
            }
        }.start();
        btnReset.setVisible(false);
        // Game.newGame();
    }
    }

    public static void btnTestMethod() {
        Gui.gameboard.repaint();
    }
    public static void gameOverScreen() {
        String gameOverText = "Your Score was: " + Snake.score;
        JOptionPane.showMessageDialog(frame, gameOverText, "GameOver!", 0);
        btnReset.setVisible(true);
    }
    public static void createJFrame() {
        // frame.setSize(1200,800);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        frame.setLocation(200,200);


        // scoreText.addActionListener(e -> btnStartMethod());
        btnReset.addActionListener(e -> btnResetMethod());
        btnTest.addActionListener(e -> btnTestMethod());

        GridBagConstraints gr = new GridBagConstraints();

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.5;
        gr.gridx = 0;
        gr.gridy = 0;
        frame.add(scoreText, gr);

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.5;
        gr.gridx = 1;
        gr.gridy = 0;
        frame.add(btnReset, gr);
        btnReset.setVisible(false);

        // gr.fill = GridBagConstraints.HORIZONTAL;
        // gr.weightx = 0.5;
        // gr.gridx = 0;
        // gr.gridy = 2;
        // frame.add(btnTest, gr);

        gr.gridx = 0;
        gr.gridy = 1;
        gr.gridwidth = 2;
        gr.ipadx = GAME_WIDTH;
        gr.ipady = GAME_HEIGHT;
        gr.weightx = 2;

    
        frame.add(gameboard, gr);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}