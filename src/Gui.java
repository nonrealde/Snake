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
    private static JFrame frame = new JFrame("Snake");
    static Board gameboard = new Board();
    public static JLabel scoreText = new JLabel("Score: " + Snake.score);
    private static JButton btnReset = new JButton("Reset");
    public static JButton btnPause = new JButton("Pause (space)");
    public static JButton btnResume = new JButton("Resume (space)");
    // private static JButton btnScoreboard = new JButton("Scoreboard");
    private static JButton btnSettings = new JButton("Settings");
    // private static JButton btnTest = new JButton("2222");
    static Integer GAME_WIDTH = 400;
    static Integer GAME_HEIGHT = 400;

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

    public static void btnTestMethod() {
        Gui.gameboard.repaint();
    }

    public static void btnSettingsMethod() {
        new Thread() {
            public void run() {
                Scoreboard.sendScore("Wumpe", Snake.score);
            }
        }.start();
    }

    public static void gameOverScreen() {
        String gameOverText = "Your Score was: " + Snake.score;
        btnReset.setVisible(true);
        btnPause.setVisible(false);
        JOptionPane.showMessageDialog(frame, gameOverText, "GameOver!", 1);
        if (Snake.score > 0 ) {
            Scoreboard.name = JOptionPane.showInputDialog("What's your name?");
            if (Scoreboard.name == null) {
                System.out.println("no input detected");
                Scoreboard.name = "Player";
            }
            Scoreboard.sendScore(Scoreboard.name, Snake.score);
        }
        // 
        // String[] options = {"Yes", "No"};
        // int choosenOption = JOptionPane.showOptionDialog(frame, "Send Score to Leaderboard?", gameOverText, 0, 3, null, options, options[1]);
        // if (choosenOption == 0) {
        //     Scoreboard.name = JOptionPane.showInputDialog("What's your name?");
        //     Scoreboard.sendScore(Scoreboard.name, Snake.score);
        //     }
        // JOptionPane.showOptionDialog(frame, gameOverText, "GameOver!", 1, 1);
        // JOptionPane.show
    }

    public static void createJFrame() {
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(250,250);

        btnReset.addActionListener(e -> btnResetMethod());
        btnSettings.addActionListener(e -> btnSettingsMethod());
        btnPause.addActionListener(e -> Game.pauseGame());
        btnResume.addActionListener(e -> Game.resumeGame());

        btnReset.setFocusable(false);
        btnSettings.setFocusable(false);
        btnPause.setFocusable(false);
        btnResume.setFocusable(false);

        // btnTest.addActionListener(e -> btnTestMethod());

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
        frame.add(btnSettings, gr);

        gr.gridx = 0;
        gr.gridy = 1;
        gr.gridwidth = 5;
        gr.ipadx = GAME_WIDTH;
        gr.ipady = GAME_HEIGHT;
        gr.weightx = 1;

        frame.add(gameboard, gr);
        frame.pack();
        frame.setVisible(true);
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