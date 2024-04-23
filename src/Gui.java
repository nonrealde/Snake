import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    private static JFrame frame = new JFrame("Test");
    static Board gameboard = new Board();
    private static JButton btnStart = new JButton("Start");
    private static JButton btnReset = new JButton("Reset");
    static Integer GAME_HEIGHT = 300;
    static Integer GAME_WIDTH = 300;
    public static Color testColor = Color.green;

    public static void initGui() {
        createJFrame();
        frame.repaint();
    }
    public static void refreshFrame() {
        frame.repaint();
    }
    public static void btnStartMethod() {
        Game.spawnApple();
        frame.repaint();
    }
    public static void btnResetMethod() {
        Game.spawnApple();
        frame.repaint();
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
        gr.ipadx = GAME_HEIGHT;
        gr.ipady = GAME_WIDTH;
        gr.weightx = 2;
        
        gameboard.setSize(new Dimension(300, 300));
        gameboard.setBackground(Color.BLACK);
        frame.add(gameboard, gr);
        frame.pack();
        frame.setVisible(true);
    }

    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}