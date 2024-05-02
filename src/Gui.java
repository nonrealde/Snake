import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    private static JFrame frame = new JFrame("Snake");
    static Board gameboard = new Board();
    private static JButton btnStart = new JButton("Start");
    private static JButton btnReset = new JButton("Reset");
    static Integer GAME_WIDTH = 400;
    static Integer GAME_HEIGHT = 400;

    public static void initGui() {
        createJFrame();
        frame.repaint();
    }
    public static void btnStartMethod() {
        gameboard.repaint();
    }
    public static void btnResetMethod() {
        Game.newGame();
    }
    public static void createJFrame() {
        // frame.setSize(1200,800);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        btnStart.addActionListener(e -> btnStartMethod());
        btnReset.addActionListener(e -> btnResetMethod());

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