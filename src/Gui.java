import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    // create gui components
    private static JFrame frame = new JFrame("Snake");
    static Board gameboard = new Board();
    public static JLabel scoreText = new JLabel("  Score: " + Snake.score);
    public static JButton btnReset = new JButton("Reset");
    public static JButton btnPause = new JButton("Pause (space)");
    public static JButton btnResume = new JButton("Resume (space)");
    public static JButton btnDifficulty = new JButton("Select Difficulty");

    // set static optins
    static Integer GAME_WIDTH = 400, GAME_HEIGHT = 400;

    // init function called at startup
    public static void initGui() {
        createJFrame();
        gameboard.repaint();
        setTheme();
    }

    public static void btnResetMethod() {
        if (Game.running != true) {
        new Thread() {
            public void run() {
                Game.newGame();
            }
        }.start();
        btnReset.setVisible(false);
        btnPause.setVisible(true);
        }
    }

    public static void btnDifficultyMethod() {
        showSelectDifficultyPanel();
    }

    public static void showSelectDifficultyPanel() {
        String[] options = {"Easy", "Medium", "Hard"};
        int choosenOption = JOptionPane.showOptionDialog(frame, "Wähle Schwierigkeitsgrad", "", 0, 3, null, options, options[1]);
            switch (choosenOption) {
                case 0:
                Game.FPS = 8;
                new Thread() {
                    public void run() {
                        Game.newGame();
                    }
                }.start();
                break;
                case 1:
                Game.FPS = 12;
                new Thread() {
                    public void run() {
                        Game.newGame();
                    }
                }.start();
                break;
                case 2:
                Game.FPS = 18;
                new Thread() {
                    public void run() {
                        Game.newGame();
                    }
                }.start();
                break;
            default:
                break;
        }
    }

    public static void gameOverScreen() {
        String gameOverText = "Your Score was: " + Snake.score;
        btnReset.setVisible(true);
        btnPause.setVisible(false);
        btnDifficulty.setVisible(true);
        JOptionPane.showMessageDialog(frame, gameOverText, "GameOver!", 1);
    }

    public static void createJFrame() {
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnReset.addActionListener(e -> btnResetMethod());
        btnDifficulty.addActionListener(e -> btnDifficultyMethod());
        btnPause.addActionListener(e -> Game.pauseGame());
        btnResume.addActionListener(e -> Game.resumeGame());

        btnReset.setFocusable(false);
        btnDifficulty.setFocusable(false);
        btnPause.setFocusable(false);
        btnResume.setFocusable(false);

        GridBagConstraints gr = new GridBagConstraints();

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.2;
        gr.gridx = 0;
        gr.gridy = 0;
        frame.add(scoreText, gr);

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.2;
        gr.gridx = 1;
        gr.gridy = 0;
        frame.add(btnReset, gr);
        btnReset.setVisible(false);
        

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.2;
        gr.gridx = 2;
        gr.gridy = 0;
        frame.add(btnPause, gr);

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.2;
        gr.gridx = 3;
        gr.gridy = 0;
        frame.add(btnResume, gr);
        btnResume.setVisible(false);

        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.weightx = 0.2;
        gr.gridx = 4;
        gr.gridy = 0;
        frame.add(btnDifficulty, gr);
        btnDifficulty.setVisible(false);

        gr.gridx = 0;
        gr.gridy = 1;
        gr.gridwidth = 5;
        gr.ipadx = GAME_WIDTH;
        gr.ipady = GAME_HEIGHT;
        gr.weightx = 1;

        frame.add(gameboard, gr);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public static void setTheme() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}