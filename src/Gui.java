import javax.swing.JButton;
import javax.swing.JFrame;
public class Gui extends JFrame {
   
    private static JFrame f = new JFrame("Test");
    private static JFrame b = new JFrame();
    private static JButton b1 = new JButton("Button1");
    private static JButton b2 = new JButton("Button2");

    
    public static void settings() {
        f.setSize(800,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    public static void addButtons() {
        f.add(b1, java.awt.BorderLayout.PAGE_START);
        f.add(b2, java.awt.BorderLayout.PAGE_END);
        // f.add(b, java.awt.BorderLayout.CENTER);
        b.setLocation(200,200);
        f.pack();
    }    
}