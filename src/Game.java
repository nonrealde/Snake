import javax.swing.Timer;

public class Game {
    enum Direction {
        LEFT,
        TOP,
        RIGHT,
        DOWN
    }
    public static void initGame() {
        spawnApple();
    }
    private final int ALLE = 900;
    private final int x[] = new int[ALLE];
    private final int y[] = new int[ALLE];
    public static int appleX;
    public static int appleY;

    private Timer t;

    private static void spawnApple() {
    
        int rand = (int) (Math.random() * 30);
        appleX = (rand * 300);
        rand = (int) (Math.random() * 30);
        appleY = (rand * 300);
        
    }
}
