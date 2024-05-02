import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Color;

public class Board extends JPanel {
    private static Image dot;
    private static Image head;
    private static Image apple;

    public static void initBoard() {
        loadImages();
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
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(head, Snake.headX, Snake.headY, this);
        g.drawImage(apple, Game.appleX, Game.appleY, this);
        for (int i = 0; i < Snake.body.length; i++) {
            g.drawImage(dot, Snake.body[i][0],Snake.body[i][1], this);
        }        
    }
}
